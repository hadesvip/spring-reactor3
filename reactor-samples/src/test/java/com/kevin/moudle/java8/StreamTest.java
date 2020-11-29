package com.kevin.moudle.java8;

import com.kevin.domain.dto.BaseDTO;
import com.kevin.domain.dto.UserDTO;
import com.kevin.domain.vo.UserVO;
import com.kevin.mapper.UserMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.junit.Test;

public class StreamTest {

  @Test
  public void comparatorTest() {

    UserDTO zhangsanUserDTO = new UserDTO();
    zhangsanUserDTO.setCreateDateTime(new Date());
    zhangsanUserDTO.setCreateUserName("admin");
    zhangsanUserDTO.setCreateUserId(UUID.randomUUID().toString().replace("-", ""));
    zhangsanUserDTO.setUserName("zhangsan");
    zhangsanUserDTO.setAge(20);
    zhangsanUserDTO.setEmail("zhangsan@126.com");

    UserDTO lisiUserDTO = new UserDTO();
    lisiUserDTO.setCreateDateTime(new Date());
    lisiUserDTO.setCreateUserName("admin");
    lisiUserDTO.setCreateUserId(UUID.randomUUID().toString().replace("-", ""));
    lisiUserDTO.setUserName("lisi");
    lisiUserDTO.setAge(20);
    lisiUserDTO.setEmail("lisi@126.com");

    UserDTO wangwuUserDTO = new UserDTO();
    wangwuUserDTO.setCreateDateTime(new Date());
    wangwuUserDTO.setCreateUserName("admin");
    wangwuUserDTO.setCreateUserId(UUID.randomUUID().toString().replace("-", ""));
    wangwuUserDTO.setUserName("lisi");
    wangwuUserDTO.setAge(20);
    wangwuUserDTO.setEmail("lisi@126.com");
    UserVO userVO = UserMapper.INSTANCE.convertDTOToVO(zhangsanUserDTO);
    System.out.println(userVO);

    List<UserDTO> userDTOList = new ArrayList<>();
    userDTOList.add(zhangsanUserDTO);
    userDTOList.add(lisiUserDTO);
    userDTOList.add(wangwuUserDTO);
    userDTOList.sort(Comparator.comparing(UserDTO::getId));
    userDTOList.forEach(System.out::println);
  }




}
