package com.kevin.moudle.java8;

import com.kevin.domain.dto.UserDTO;
import java.util.Optional;
import org.junit.Test;

/**
 * @author wangyong
 */
public class OptionalTest {


  @Test
  public void optTest() {
    Optional<UserDTO> userDTOOpt = Optional.empty();
    Optional<String> idOpt = userDTOOpt.map(UserDTO::getId);
    System.out.println(idOpt.get());
  }



}
