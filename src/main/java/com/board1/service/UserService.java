package com.board1.service;

import com.board1.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface UserService {

    void createUser(UserDTO user);
    UserDTO getUserById(int UserID);
    List<UserDTO> getAllUsers();
    void updateUser(int UserID, String username, String email, String PasswordHash, LocalDateTime createdAt);
    void deleteUser(int UserID);
    int authenticateUser(String userid, String password);

}
