package dev.jeroen.plushie_backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import dev.jeroen.plushie_backend.dtos.OrderDTO;
import dev.jeroen.plushie_backend.entities.Order;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "user.id", target = "userId")
    OrderDTO orderToOrderDTO(Order order);
}
