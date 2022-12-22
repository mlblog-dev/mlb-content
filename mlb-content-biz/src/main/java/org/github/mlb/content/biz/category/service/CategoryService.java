package org.github.mlb.content.biz.category.service;

import org.github.mlb.content.category.entity.CategoryEntity;
import org.github.mlb.content.category.param.AddOrModifyCategoryParam;

import java.util.List;

/**
 * @author JiHongYuan
 * @date 2022/3/9 15:00
 */
public interface CategoryService {

    /**
     * list category by {@code repositoryId}
     *
     * @param repositoryId 仓库ID
     * @return list
     */
    List<CategoryEntity> listByRepositoryId(Long repositoryId);

    /**
     * list category by {@code repositorySlug}
     *
     * @param repositorySlug 仓库路径
     * @return list
     */
    List<CategoryEntity> listByRepositorySlug(String repositorySlug);

    List<Long> listIdByUserId(Long userId);

    /**
     * add category
     *
     * @param param param
     * @return do
     */
    CategoryEntity add(AddOrModifyCategoryParam param);

    /**
     * modify category {@code param} categoryId
     *
     * @param param param
     * @return do
     */
    CategoryEntity updateById(AddOrModifyCategoryParam param);

    /**
     * remove by {@code categoryId}
     *
     * @param categoryId 分类ID
     */
    void removeByCategoryId(Long categoryId);

    void tombstoneById(Long categoryId);

}
