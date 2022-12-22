package org.github.mlb.content.article.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.github.mlb.common.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author JiHongYuan
 * @date 2021/9/15 21:39
 */
@Getter
@Setter
@TableName("b_content_article_version")
public class ArticleVersionEntity extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String articleId;

    private String content;

    private Integer version;

}