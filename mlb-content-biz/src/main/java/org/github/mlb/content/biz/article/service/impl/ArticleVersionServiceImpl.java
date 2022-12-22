package org.github.mlb.content.biz.article.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.github.mlb.content.article.entity.ArticleVersionEntity;
import org.github.mlb.content.biz.article.mapper.ArticleVersionMapper;
import org.github.mlb.content.biz.article.service.ArticleVersionService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author JiHongYuan
 * @date 2021/9/15 21:52
 */
@Service
public class ArticleVersionServiceImpl extends
        ServiceImpl<ArticleVersionMapper, ArticleVersionEntity> implements ArticleVersionService {

    @Override
    public boolean addOrUpdateByNewVersionOnUpdateTime(ArticleVersionEntity articleVersion, Date newVersionUpdateTime) {

        if (System.currentTimeMillis() - newVersionUpdateTime.getTime() >= 5000) {
            update(articleVersion, Wrappers.<ArticleVersionEntity>lambdaQuery()
                    .eq(ArticleVersionEntity::getArticleId, articleVersion.getArticleId())
                    .eq(ArticleVersionEntity::getContent, articleVersion.getContent())
                    .eq(ArticleVersionEntity::getVersion, articleVersion.getVersion()));

            return false;
        }
        save(articleVersion);
        return true;
    }
}
