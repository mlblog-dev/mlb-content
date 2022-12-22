package org.github.mlb.content.controller.repository;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.github.mlb.content.biz.repository.service.RepositoryService;
import org.github.mlb.common.utils.AddOperate;
import org.github.mlb.common.utils.ModifyOperate;
import org.github.mlb.common.utils.Result;
import lombok.AllArgsConstructor;
import org.github.mlb.content.repository.entity.RepositoryEntity;
import org.github.mlb.content.repository.param.AddOrModifyRepositoryParam;
import org.github.mlb.content.repository.param.QueryRepositoryParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author JiHongYuan
 * @date 2021/9/18 9:45
 */
@AllArgsConstructor
@RestController
@RequestMapping("/repository")
public class RepositoryController {

    private final RepositoryService repositoryService;

    @GetMapping("/{repositoryId}")
    public Result<RepositoryEntity> get(@PathVariable("repositoryId") Long repositoryId) {
        return Result.ofSuccess(repositoryService.getByRepositoryId(repositoryId));
    }

    @GetMapping
    public Result<Page<RepositoryEntity>> list(QueryRepositoryParam param,
                                               @RequestParam(defaultValue = "1") Integer index,
                                               @RequestParam(defaultValue = "10") Integer size) {
        return Result.ofSuccess(repositoryService.pageByParam(new Page<>(index, size), param));
    }

    @PostMapping
    public Result<RepositoryEntity> add(@Validated(value = {AddOperate.class}) @RequestBody AddOrModifyRepositoryParam param) {
        return Result.ofSuccess(repositoryService.add(param));
    }

    @PutMapping
    public Result<RepositoryEntity> update(@Validated(value = {ModifyOperate.class}) @RequestBody AddOrModifyRepositoryParam param) {
        return Result.ofSuccess(repositoryService.updateById(param));
    }

    @PutMapping("/{repositoryId}")
    public Result<Long> tombstone(@PathVariable("repositoryId") Long repositoryId) {
        repositoryService.tombstoneById(repositoryId);
        return Result.ofSuccess(repositoryId);
    }

    @DeleteMapping("/{repositoryId}")
    public Result<Long> delete(@PathVariable("repositoryId") Long repositoryId) {
        repositoryService.removeByRepositoryId(repositoryId);
        return Result.ofSuccess(repositoryId);
    }

}