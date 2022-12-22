package org.github.mlb.content.biz.category.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.github.mlb.content.category.entity.CategoryEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/18 10:26
 */
@Repository
public interface CategoryMapper extends BaseMapper<CategoryEntity> {

    /**
     * 查询列表
     *
     * @param repositoryId   仓库ID
     * @param repositorySlug 仓库路径
     * @return list
     */
    List<CategoryEntity> selectListByIdOrSlug(@Param("repositoryId") Long repositoryId, @Param("repositorySlug") String repositorySlug);

    List<Long> selectListIdByUserId(Long userId);

}