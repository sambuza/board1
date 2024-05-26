package com.board1;

import com.board1.dto.UserDTO;
import com.board1.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;


@SpringBootTest
public class UserTests2 {


    @Autowired
    private UserService userService;

    @Test
    public void insertUser() {

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(6);
        userDTO.setUsername("john_doe6");
        userDTO.setPasswordHash("pass1236");
        userDTO.setEmail("john6@example.com");
        userDTO.setCreatedAt(LocalDateTime.now());

        userService.createUser(userDTO);

    }
}
