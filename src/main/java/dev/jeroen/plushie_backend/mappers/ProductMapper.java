package dev.jeroen.plushie_backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import dev.jeroen.plushie_backend.dtos.ProductDTO;
import dev.jeroen.plushie_backend.entities.Product;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "category.id", target = "category_id")
    ProductDTO productToProductDTO(Product product);

}
