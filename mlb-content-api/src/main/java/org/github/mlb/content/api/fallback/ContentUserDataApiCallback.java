package org.github.mlb.content.api.fallback;

import org.github.mlb.common.utils.Result;
import org.github.mlb.content.api.ContentUserDataApi;
import org.github.mlb.content.constant.ContentConstants;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jihongyuan
 * @date 2022/6/29 15:42
 */
@Service
public class ContentUserDataApiCallback implements ContentUserDataApi {

    @Override
    public Result<List<Long>> listRepositoryByUserId(Long userId, String token) {
        return Result.ofFail(0, ContentConstants.HYSTRIX_FALLBACK);
    }

    @Override
    public Result<List<Long>> listCategoryByUserId(Long userId, String token) {
        return Result.ofFail(0, ContentConstants.HYSTRIX_FALLBACK);
    }

    @Override
    public Result<List<Long>> listArticleByUserId(Long userId, String token) {
        return Result.ofFail(0, ContentConstants.HYSTRIX_FALLBACK);
    }

}
