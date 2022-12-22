package org.github.mlb.content.category.param;

import org.github.mlb.common.utils.AddOperate;
import org.github.mlb.common.utils.ModifyOperate;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @author JiHongYuan
 * @date 2022/3/10 14:45
 */
@Getter
@Setter
public class AddOrModifyCategoryParam {

    @Null(groups = {AddOperate.class})
    @NotNull(groups = {ModifyOperate.class})
    private Long categoryId;

    /**
     * 仓库ID
     */
    @NotNull(groups = {AddOperate.class})
    @Null(groups = {ModifyOperate.class})
    private Long repositoryId;

    /**
     * 标题
     */
    @NotNull
    private String title;

    /**
     * 类型
     */
    private String type;

    /**
     * 父节点
     */
    private Long parentId;

}
