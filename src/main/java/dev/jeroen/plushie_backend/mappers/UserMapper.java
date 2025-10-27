package dev.jeroen.plushie_backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import dev.jeroen.plushie_backend.entities.CustomUser;
import dev.jeroen.plushie_backend.dtos.UserRegisterDTO;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "role", constant = "ROLE_USER")
    CustomUser userRegisterDTOToCustomUser(UserRegisterDTO user);

}
