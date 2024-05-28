package com.board1;

import com.board1.dto.UserDTO;
import com.board1.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class UserTests2 {


    @Autowired
    private UserService userService;

    @Test
    public void insertUser() {

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("john_doe44");
        userDTO.setPasswordHash("pass12344");
        userDTO.setEmail("john44@example.com");
        userDTO.setCreatedAt(LocalDateTime.now());

        userService.createUser(userDTO);


    }
    @Test
    public void getUserByID(){

        UserDTO user = userService.getUserById(37);
    
        // 사용자의 정보가 null이 아닌지 확인합니다.
        assertNotNull(user);
        
        // 사용자의 정보를 출력하여 확인합니다.
        System.out.println("User ID: " + user.getUserId());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Created At: " + user.getCreatedAt());

    }

    @Test
    public void getAllUsersTest() {
        // 사용자 목록을 가져옵니다.
        List<UserDTO> userList = userService.getAllUsers();

        // 사용자 목록이 null이 아니고 비어있지 않은지 확인합니다.
        assertNotNull(userList);
        assertFalse(userList.isEmpty());

        // 사용자 목록의 크기를 출력하여 확인합니다.
        System.out.println("Number of users: " + userList.size());

        // 각 사용자의 정보를 출력하여 확인합니다.
        for (UserDTO user : userList) {
            System.out.println("User ID: " + user.getUserId());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Created At: " + user.getCreatedAt());
            System.out.println("--------------------------");
        }
    }

    @Test
    void testUpdateUser() {
// Arrange: 사용자 추가
        UserDTO user = new UserDTO();
        user.setUserId(9);


// Act: 사용자 정보 업데이트
        userService.updateUser(user.getUserId(), "new_username9", "new_email9@example.com", "NewLast9",LocalDateTime.now());

//
//        Optional<UserDTO> updatedUser = Optional.ofNullable(userService.getUserById(4));
//        assertTrue(updatedUser.isPresent());
//        assertEquals("new_username2", updatedUser.get().getUsername());
//        assertEquals("new_email2@example.com", updatedUser.get().getEmail());
//        assertEquals("NewFirst2", updatedUser.get().getPasswordHash());
////        assertEquals("NewLast", updatedUser.get().getCreatedAt());
//
    }
//    @Test
//    @BeforeEach
//    public void setup() {
//        // 테스트에 사용할 사용자 리스트를 생성합니다.
//        UserDTO user = new UserDTO( 0,"John114", "Doe1", "test114@example.com", LocalDateTime.now());
//
//            userService.createUser(user);
//    }

    @Test
    public void insertMultipleUsers() {
        int numberOfUsers = 10; // 생성할 사용자 수를 지정합니다.

        for (int i = 0; i < numberOfUsers; i++) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername("Jejus_Christ" + i);
            userDTO.setPasswordHash("pass123" + i);
            userDTO.setEmail("jejuschrist" + i + "@example.com");
            userDTO.setCreatedAt(LocalDateTime.now());

            userService.createUser(userDTO);
        }
    }

    @Test
    public void testDeleteUser() {
        // 테스트에 필요한 객체를 생성하고 초기화합니다.


        // 사용자를 삭제합니다.
        userService.deleteUser(10);

        // 사용자를 삭제한 후에 해당 사용자가 더 이상 존재하지 않는지 확인합니다.
        // 삭제된 사용자의 ID로 getUser 메서드를 호출하면 null을 반환해야 합니다.

    }


}
