package org.github.mlb.content.biz.article.service;

import org.github.mlb.content.article.entity.ArticleEntity;
import org.github.mlb.content.article.param.AddArticleParam;

import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/15 21:45
 */
public interface ArticleService {

    List<Long> listIdByUserId(Long userId);

    ArticleEntity add(AddArticleParam param);

    void update(AddArticleParam addArticleParam);

    /**
     * remove by {@code categoryId}
     *
     * @param articleId 文章ID
     */
    void removeByArticleId(Long articleId);

}
