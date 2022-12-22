package org.github.mlb.content.biz.category.service.impl;

import lombok.AllArgsConstructor;
import org.github.mlb.common.model.UserInfo;
import org.github.mlb.common.utils.UserHolder;
import org.github.mlb.content.biz.category.mapper.CategoryMapper;
import org.github.mlb.content.category.convert.CategoryConvert;
import org.github.mlb.content.category.entity.CategoryEntity;
import org.github.mlb.content.category.param.AddOrModifyCategoryParam;
import org.github.mlb.content.biz.category.manger.CategoryManager;
import org.github.mlb.content.biz.category.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.List;

/**
 * @author JiHongYuan
 * @date 2022/3/9 15:00
 */
@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryManager categoryManager;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryEntity> listByRepositoryId(Long repositoryId) {
        return categoryManager.listByRepositoryId(repositoryId);
    }

    @Override
    public List<CategoryEntity> listByRepositorySlug(String repositorySlug) {
        return categoryManager.listByRepositorySlug(repositorySlug);
    }

    @Override
    public List<Long> listIdByUserId(Long userId) {
        return categoryMapper.selectListIdByUserId(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CategoryEntity add(AddOrModifyCategoryParam param) {
        CategoryEntity category = CategoryConvert.INSTANCE.toEntity(param);

        category.setUserId(UserHolder.getId());

        /* 当前设置前驱节点 */
        CategoryEntity lastCategory = categoryManager.selectLastParentId(category.getParentId());
        category.setPrevId(lastCategory == null ? 0L : lastCategory.getId());
        categoryManager.add(category);

        /* 修改后驱节点 */
        if (lastCategory != null) {
            lastCategory.setNextId(category.getId());
            categoryManager.updateById(lastCategory);
        }

        UserHolder.get().getCategories().add(category.getId());
        return category;
    }

    @Override
    public CategoryEntity updateById(AddOrModifyCategoryParam param) {
        validateUserId(param.getCategoryId());

        CategoryEntity category = CategoryConvert.INSTANCE.toEntity(param);
        categoryManager.updateById(CategoryEntity.builder().id(category.getId()).title(category.getTitle()).build());
        return category;
    }

    @Override
    public void tombstoneById(Long categoryId) {
        validateUserId(categoryId);
        categoryManager.tombstoneById(categoryId);
        UserHolder.get().getCategories().remove(categoryId);
    }

    @Override
    public void removeByCategoryId(Long categoryId) {
        CategoryEntity category = categoryManager.getById(categoryId);
        Assert.isTrue(category.getUserId().equals(UserHolder.getId()), "非法操作");
        Assert.isTrue(category.getIsDeleted().equals(Boolean.TRUE), "非法操作");

        categoryManager.removeById(categoryId);
    }

    public void validateUserId(Long categoryId) {
        UserInfo userInfo = UserHolder.get();
        // 补偿机制
        if (userInfo.getCategories() == null) {
            userInfo.setCategories(new HashSet<>(listIdByUserId(userInfo.getId())));
        }
        Assert.isTrue(userInfo.getCategories().contains(categoryId), "非法操作");
    }

}
