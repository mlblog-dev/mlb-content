package org.github.mlb.content.biz.article.manager;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.github.mlb.common.utils.UserHolder;
import org.github.mlb.content.article.entity.ArticleEntity;
import org.github.mlb.content.biz.article.mapper.ArticleMapper;
import org.github.mlb.content.biz.article.service.ArticleVersionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author jihongyuan
 * @date 2022/6/27 17:02
 */
@Component
@AllArgsConstructor
public class ArticleManager extends ServiceImpl<ArticleMapper, ArticleEntity> {

    private final ArticleVersionService articleVersionService;

    public ArticleEntity add(ArticleEntity article) {
        super.save(article);
        UserHolder.get().getArticles().add(article.getId());
        return article;
    }

    public void deleteArticleById(Long articleId) {
        super.update(Wrappers.<ArticleEntity>lambdaUpdate()
                .set(ArticleEntity::getIsDeleted, true)
                .eq(ArticleEntity::getId, articleId));
        UserHolder.get().getRepositories().remove(articleId);
    }


}
