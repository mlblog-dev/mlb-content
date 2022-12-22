package org.github.mlb.content.biz.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.github.mlb.content.repository.entity.RepositoryEntity;
import org.github.mlb.content.repository.param.QueryRepositoryParam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author JiHongYuan
 * @date 2021/9/18 9:40
 */
@Repository
public interface RepositoryMapper extends BaseMapper<RepositoryEntity> {

    /**
     * 根据 {@code slug} 查询仓库信息
     *
     * @param slug 仓库路径
     * @return do
     */
    @Select("select * from b_content_repository where slug = #{slug}")
    RepositoryEntity selectBySlug(String slug);

    /**
     * 分页查询
     *
     * @param page  分页信息
     * @param param 入参
     * @return page
     */
    Page<RepositoryEntity> selectPageByParam(IPage<?> page, @Param("param") QueryRepositoryParam param);

    List<Long> selectListIdByUserId(Long userId);
}
