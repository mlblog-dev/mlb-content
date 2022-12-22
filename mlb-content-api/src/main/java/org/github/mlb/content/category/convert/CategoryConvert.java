package org.github.mlb.content.category.convert;

import org.github.mlb.content.category.entity.CategoryEntity;
import org.github.mlb.content.category.param.AddOrModifyCategoryParam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author JiHongYuan
 * @date 2022/3/10 15:04
 */
@Mapper
public interface CategoryConvert {
    CategoryConvert INSTANCE = Mappers.getMapper(CategoryConvert.class);

    @Mapping(target = "id", source = "categoryId")
    @Mapping(target = "type", source = "type")
    CategoryEntity toEntity(AddOrModifyCategoryParam param);

}
