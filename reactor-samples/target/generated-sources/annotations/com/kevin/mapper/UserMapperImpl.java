package com.kevin.mapper;

import com.kevin.domain.dto.UserDTO;
import com.kevin.domain.vo.UserVO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-07T13:34:30+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_151 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserVO convertDTOToVO(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserVO userVO = new UserVO();

        userVO.setUserId( userDTO.getId() );
        userVO.setAge( userDTO.getAge() );

        return userVO;
    }
}
