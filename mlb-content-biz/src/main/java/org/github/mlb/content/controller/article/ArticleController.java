package org.github.mlb.content.controller.article;

import org.github.mlb.common.utils.Result;
import org.github.mlb.content.article.entity.ArticleEntity;
import org.github.mlb.content.article.param.AddArticleParam;
import org.github.mlb.content.biz.article.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/15 22:24
 */
@AllArgsConstructor
@RestController
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public List<ArticleEntity> list() {
        return null;
    }

    @GetMapping("/{articleId}")
    public ArticleEntity get(@PathVariable String articleId) {
        return null;
    }

    @PostMapping
    public Result<ArticleEntity> add(@RequestBody AddArticleParam addArticleParam) {
        return Result.ofSuccess(articleService.add(addArticleParam));
    }

}
