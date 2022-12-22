package org.github.mlb.content.biz.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.github.mlb.content.article.entity.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/15 21:44
 */

@Mapper
public interface ArticleMapper extends BaseMapper<ArticleEntity> {
    List<Long> selectListIdByUserId(Long userId);
}
