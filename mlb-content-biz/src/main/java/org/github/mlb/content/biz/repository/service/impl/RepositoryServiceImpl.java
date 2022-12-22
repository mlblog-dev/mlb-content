package org.github.mlb.content.biz.repository.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.github.mlb.common.model.UserInfo;
import org.github.mlb.common.utils.IdUtil;
import org.github.mlb.common.utils.UserHolder;
import org.github.mlb.content.biz.repository.mapper.RepositoryMapper;
import org.github.mlb.content.repository.convert.RepositoryConvert;
import org.github.mlb.content.repository.entity.RepositoryEntity;
import org.github.mlb.content.repository.param.QueryRepositoryParam;
import org.github.mlb.content.biz.repository.manager.RepositoryManager;
import org.github.mlb.content.repository.param.AddOrModifyRepositoryParam;
import org.github.mlb.content.biz.repository.service.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/18 9:43
 */
@Service
@AllArgsConstructor
public class RepositoryServiceImpl implements RepositoryService {

    private final RepositoryManager repositoryManager;
    private final RepositoryMapper repositoryMapper;

    @Override
    public RepositoryEntity getByRepositoryId(Long repositoryId) {
        Assert.isTrue(repositoryId > 0, "非法操作");
        return repositoryManager.selectRepositoryById(repositoryId);
    }

    @Override
    public Page<RepositoryEntity> pageByParam(IPage<?> page, QueryRepositoryParam param) {
        return repositoryManager.selectPageByParam(page, param);
    }

    @Override
    public List<Long> listIdByUserId(Long userId) {
        return repositoryMapper.selectListIdByUserId(userId);
    }

    @Override
    public RepositoryEntity add(AddOrModifyRepositoryParam addRepositoryParam) {
        RepositoryEntity repository = RepositoryConvert.INSTANCE.toEntity(addRepositoryParam);

        String slug = IdUtil.generateSlug();
        repository.setSlug(slug);

        // insert
        repository.setUserId(UserHolder.getId());
        return repositoryManager.add(repository);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RepositoryEntity updateById(AddOrModifyRepositoryParam modifyRepositoryParam) {
        validateUserId(modifyRepositoryParam.getRepositoryId());

        RepositoryEntity repository = RepositoryConvert.INSTANCE.toEntity(modifyRepositoryParam);
        // 验证slug唯一
        String slug = repository.getSlug();
        Assert.isTrue(!repositoryManager.existSlugByUserId(UserHolder.getId(), repository.getId(), slug), "路径名称不能重复!");

        repositoryManager.updateById(repository);
        return repository;
    }

    @Override
    public void tombstoneById(Long repositoryId) {
        validateUserId(repositoryId);
        repositoryManager.deleteRepositoryById(repositoryId);
        UserHolder.get().getRepositories().remove(repositoryId);
    }

    @Override
    public void removeByRepositoryId(Long repositoryId) {
        RepositoryEntity repository = repositoryManager.getById(repositoryId);
        Assert.isTrue(repository.getUserId().equals(UserHolder.getId()), "非法操作");
        Assert.isTrue(repository.getIsDeleted().equals(Boolean.TRUE), "非法操作");

        repositoryManager.removeById(repositoryId);
    }

    public void validateUserId(Long repositoryId){
        UserInfo userInfo = UserHolder.get();
        // 补偿机制
        if(userInfo. getRepositories() == null){
            userInfo.setRepositories(new HashSet<>(listIdByUserId(userInfo.getId())));
        }
        Assert.isTrue(userInfo.getRepositories().contains(repositoryId),"非法操作");
    }

}