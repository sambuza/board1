package com.board1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.board1.dto.UserDTO;
import com.board1.mapper.UserMapper;
import com.board1.service.UserService;
import com.board1.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class UserTests {

    @Mock
    private UserMapper userMapper = mock(UserMapper.class);; // UserMapper를 목 객체로 대체합니다.

    @InjectMocks
    private UserService userService = new UserServiceImpl(userMapper); // UserService에 목 객체를 주입합니다.

    private List<UserDTO> userList;

    @BeforeEach
    public void setup() {
        // 테스트에 사용할 사용자 리스트를 생성합니다.
        userList = new ArrayList<>();
        userList.add(new UserDTO(1, "John1", "Doe1", "test1@example.com", LocalDateTime.now()));
        userList.add(new UserDTO(2, "John2", "Doe2", "test2@example.com", LocalDateTime.now()));
        userList.add(new UserDTO(3, "John3", "Doe3", "test3@example.com", LocalDateTime.now()));


    }

    @Test
    public void testCreateUser() {
        // 테스트에 사용할 사용자를 생성합니다.
        UserDTO newUser = new UserDTO(4, "John4", "Doe4", "test4@example.com", LocalDateTime.now());
        System.out.println(newUser);
        // userMapper의 insertUser 메서드가 호출되었을 때, 생성된 사용자를 반환하도록 설정합니다.
        userService.createUser(newUser);


    }

    @Test
    public void testGetUserById() {
        // 테스트에 사용할 사용자 ID를 지정합니다.
        int userId = 1;

        // userMapper의 getUserById 메서드가 호출되었을 때, 지정된 사용자를 반환하도록 설정합니다.
        when(userMapper.selectUserById(userId)).thenReturn(userList.get(0));

        // 테스트할 메서드를 호출합니다.
        UserDTO foundUser = userService.getUserById(userId);

        // 지정된 사용자가 반환되었는지 확인합니다.
        assertNotNull(foundUser);
        assertEquals(userList.get(0), foundUser);
    }

    // 이하 테스트 코드는 getAllUsers, updateUser, deleteUser 등의 기능을 테스트합니다.
}
