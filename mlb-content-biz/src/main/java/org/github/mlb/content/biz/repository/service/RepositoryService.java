package org.github.mlb.content.biz.repository.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.github.mlb.content.repository.entity.RepositoryEntity;
import org.github.mlb.content.repository.param.AddOrModifyRepositoryParam;
import org.github.mlb.content.repository.param.QueryRepositoryParam;

import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/18 9:43
 */
public interface RepositoryService {

    /**
     * get repository by {@code repositoryId}
     *
     * @param repositoryId 仓库ID
     * @return entity
     */
    RepositoryEntity getByRepositoryId(Long repositoryId);

    /**
     * 查询分页
     *
     * @param page  分页入参
     * @param param 入参
     * @return list
     */
    Page<RepositoryEntity> pageByParam(IPage<?> page, QueryRepositoryParam param);

    /**
     * list repository id by {@code userId}
     *
     * @param userId 用户ID
     * @return ids
     */
    List<Long> listIdByUserId(Long userId);

    /**
     * add repository
     *
     * @param param param
     * @return entity
     */
    RepositoryEntity add(AddOrModifyRepositoryParam param);

    /**
     * modify repository {@code param} by repositoryId
     *
     * @param param param
     * @return entity
     */
    RepositoryEntity updateById(AddOrModifyRepositoryParam param);

    void tombstoneById(Long repositoryId);

    /**
     * remove repository by {@code slug}
     *
     * @param repositoryId 仓库ID
     */
    void removeByRepositoryId(Long repositoryId);

}
