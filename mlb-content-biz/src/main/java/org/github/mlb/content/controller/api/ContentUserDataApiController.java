package org.github.mlb.content.controller.api;

import lombok.AllArgsConstructor;
import org.github.mlb.common.utils.Result;
import org.github.mlb.content.api.ContentUserDataApi;
import org.github.mlb.content.biz.article.service.ArticleService;
import org.github.mlb.content.biz.category.service.CategoryService;
import org.github.mlb.content.biz.repository.service.RepositoryService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * @author jihongyuan
 * @date 2022/6/29 16:10
 */
@AllArgsConstructor
@RestController
public class ContentUserDataApiController implements ContentUserDataApi {

    private final RepositoryService repositoryService;

    private final CategoryService categoryService;

    private final ArticleService articleService;

    @Override
    public Result<List<Long>> listRepositoryByUserId(Long userId, String token) {
        return Result.ofSuccess(repositoryService.listIdByUserId(userId));
    }

    @Override
    public Result<List<Long>> listCategoryByUserId(Long userId, String token) {
        return Result.ofSuccess(categoryService.listIdByUserId(userId));
    }

    @Override
    public Result<List<Long>> listArticleByUserId(Long userId, String token) {
        return Result.ofSuccess(articleService.listIdByUserId(userId));
    }

}
