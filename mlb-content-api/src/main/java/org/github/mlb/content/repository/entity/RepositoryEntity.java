package org.github.mlb.content.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.github.mlb.common.model.BaseEntity;
import lombok.*;

/**
 * @author JiHongYuan
 * @date 2021/9/18 9:38
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("b_content_repository")
public class RepositoryEntity extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 作为仓库url的末尾部分
     */
    private String slug;

    /**
     * 仓库名称
     */
    private String name;

    /**
     * 仓库描述
     */
    @TableField("`describe`")
    private String describe;

    /**
     * 图标
     */
    private String icon;

    /**
     * 封面
     * */
    private String cover;

    /**
     * 是否公开
     */
    private Boolean isPublic;

}