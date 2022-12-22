package org.github.mlb.content.repository.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author JiHongYuan
 * @date 2022/1/21 14:28
 */
@Getter
@Setter
@ToString
public class PageRepositoryVO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 作为仓库url的末尾部分
     */
    private String slug;

    /**
     * 描述
     */
    private String description;

    /**
     * 文档数
     */
    private Integer itemsCount;

    /**
     * 喜爱数
     */
    private Integer likesCount;

    /**
     * 关注数
     */
    private Integer watchesCount;

    /**
     * 是否公开标识
     * */
    private Integer isPublic;

    private Date createAt;

    private Date updateAt;

}
