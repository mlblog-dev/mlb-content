package org.github.mlb.content.repository.param;

import org.github.mlb.common.utils.AddOperate;
import org.github.mlb.common.utils.ModifyOperate;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @author JiHongYuan
 * @date 2021/9/18 14:44
 */
@Getter
@Setter
public class AddOrModifyRepositoryParam {

    @Null(groups = {AddOperate.class})
    @NotNull(groups = {ModifyOperate.class})
    private Long repositoryId;

    /**
     * 路径名称
     */
    @Null(groups = {AddOperate.class})
    private String slug;

    /**
     * 仓库名称
     */
    @NotEmpty(message = "仓库名称不能为空")
    private String name;

    /**
     * 仓库描述
     */
    @NotEmpty(message = "仓库描述不能为空")
    private String describe;

    /**
     * 图标
     */
    @NotEmpty(message = "图标不能为空")
    private String icon;

    /**
     * 封面
     */
    private String cover;

    /**
     * 是否公开
     */
    @NotNull(message = "是否公开标识不能为空")
    private Boolean isPublic;

}