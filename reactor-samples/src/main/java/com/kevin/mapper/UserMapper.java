package com.kevin.mapper;

import com.kevin.domain.dto.UserDTO;
import com.kevin.domain.vo.UserVO;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @Mappings({
      @Mapping(source = "id",target = "userId")
  })
  UserVO convertDTOToVO(UserDTO userDTO);


}
