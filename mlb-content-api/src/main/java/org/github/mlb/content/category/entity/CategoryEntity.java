package org.github.mlb.content.category.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.github.mlb.common.model.BaseEntity;
import org.github.mlb.content.category.enums.CategoryType;
import lombok.*;

/**
 * @author JiHongYuan
 * @date 2021/9/18 10:24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("b_content_category")
public class CategoryEntity extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 仓库ID
     */
    private Long repositoryId;

    /**
     * 分类标题
     */
    private String title;

    /**
     * 类型(1:title;)
     */
    private CategoryType type;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 前驱节点
     */
    private Long prevId;

    /**
     * 后驱节点
     */
    private Long nextId;

    /**
     * 父亲节点
     */
    private Long parentId;

}