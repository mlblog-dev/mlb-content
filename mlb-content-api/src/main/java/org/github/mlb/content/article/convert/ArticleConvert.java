package org.github.mlb.content.article.convert;

import org.github.mlb.content.article.entity.ArticleEntity;
import org.github.mlb.content.article.param.AddArticleParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author jihongyuan
 * @date 2022/6/28 9:10
 */
@Mapper
public interface ArticleConvert {

    ArticleConvert INSTANCE = Mappers.getMapper(ArticleConvert.class);

    ArticleEntity toEntity(AddArticleParam param);

}
