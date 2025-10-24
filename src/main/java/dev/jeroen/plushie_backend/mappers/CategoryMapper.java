package dev.jeroen.plushie_backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import dev.jeroen.plushie_backend.dtos.CategoryDTO;
import dev.jeroen.plushie_backend.entities.Category;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);
}
