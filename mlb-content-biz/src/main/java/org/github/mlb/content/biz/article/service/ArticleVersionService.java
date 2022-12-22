package org.github.mlb.content.biz.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.github.mlb.content.article.entity.ArticleVersionEntity;

import java.util.Date;

/**
 * @author JiHongYuan
 * @date 2021/9/15 21:51
 */

public interface ArticleVersionService extends IService<ArticleVersionEntity> {

    /**
     * 根据当前之前和最新版本更新时间相比,如果超出设置则{@code add}, 否则{@code update}
     *
     * @param articleVersion       数据
     * @param newVersionUpdateTime 最新版本更新时间
     * @return {@code true} add, {@code false} update
     */
    boolean addOrUpdateByNewVersionOnUpdateTime(ArticleVersionEntity articleVersion, Date newVersionUpdateTime);

}