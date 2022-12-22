package org.github.mlb.content.controller.category;

import org.github.mlb.common.utils.AddOperate;
import org.github.mlb.common.utils.ModifyOperate;
import org.github.mlb.common.utils.Result;
import org.github.mlb.content.biz.category.service.CategoryService;
import lombok.AllArgsConstructor;
import org.github.mlb.content.category.entity.CategoryEntity;
import org.github.mlb.content.category.param.AddOrModifyCategoryParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author JiHongYuan
 * @date 2022/3/10 14:31
 */
@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/id/{repositoryId}")
    public Result<List<CategoryEntity>> list(@PathVariable("repositoryId") Long repositoryId) {
        return Result.ofSuccess(categoryService.listByRepositoryId(repositoryId));
    }

    @GetMapping("/slug/{repositorySlug}")
    public Result<List<CategoryEntity>> list(@PathVariable("repositorySlug") String repositorySlug) {
        return Result.ofSuccess(categoryService.listByRepositorySlug(repositorySlug));
    }

    @PostMapping
    public Result<CategoryEntity> add(@Validated(value = {AddOperate.class}) @RequestBody AddOrModifyCategoryParam param) {
        return Result.ofSuccess(categoryService.add(param));
    }

    @PutMapping
    public Result<CategoryEntity> update(@Validated(value = {ModifyOperate.class}) @RequestBody AddOrModifyCategoryParam param) {
        return Result.ofSuccess(categoryService.updateById(param));
    }

    @PutMapping("/{categoryId}")
    public Result<Long> tombstone(@PathVariable("categoryId") Long categoryId) {
        categoryService.tombstoneById(categoryId);
        return Result.ofSuccess(categoryId);
    }

    @DeleteMapping("/{categoryId}")
    public Result<Long> delete(@PathVariable("categoryId") Long categoryId) {
        categoryService.removeByCategoryId(categoryId);
        return Result.ofSuccess(categoryId);
    }

}
