package org.github.mlb.content.api;

import feign.Headers;
import org.github.mlb.common.utils.Result;
import org.github.mlb.content.api.fallback.ContentUserDataApiCallback;
import org.github.mlb.content.constant.ContentConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
 * @author jihongyuan
 * @date 2022/6/29 15:28
 */
@FeignClient(name = ContentConstants.SERVICE_ID, path = ContentConstants.SERVLET_CONTEXT_PATH, fallback = ContentUserDataApiCallback.class)
public interface ContentUserDataApi {

    @GetMapping(value = ContentConstants.BASE_URI + "/repository/users/{userId}")
    Result<List<Long>> listRepositoryByUserId(@PathVariable Long userId, @RequestHeader(HttpHeaders.AUTHORIZATION) String token);

    @GetMapping(ContentConstants.BASE_URI + "/category/users/{userId}")
    Result<List<Long>> listCategoryByUserId(@PathVariable Long userId, @RequestHeader(HttpHeaders.AUTHORIZATION) String token);

    @GetMapping(ContentConstants.BASE_URI + "/article/users/{userId}")
    @Headers({"Content-Type: application/json;charset=UTF-8", "Authorization: {token}"})
    Result<List<Long>> listArticleByUserId(@PathVariable Long userId, @RequestHeader(HttpHeaders.AUTHORIZATION) String token);

}
