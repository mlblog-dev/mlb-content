package org.github.mlb.content.repository.convert;

import org.github.mlb.content.repository.entity.RepositoryEntity;
import org.github.mlb.content.repository.param.AddOrModifyRepositoryParam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author JiHongYuan
 * @date 2022/1/21 14:49
 */
@Mapper
public interface RepositoryConvert {
    RepositoryConvert INSTANCE = Mappers.getMapper(RepositoryConvert.class);

    /**
     * {@code param} to RepositoryEntity
     *
     * @param param request param
     * @return convert
     */
    @Mapping(target = "id", source = "repositoryId")
    RepositoryEntity toEntity(AddOrModifyRepositoryParam param);

}
