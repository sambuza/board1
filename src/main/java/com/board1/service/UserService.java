package com.board1.service;

import com.board1.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void createUser(UserDTO user);
    UserDTO getUserById(int userId);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(int userId, UserDTO user);
    void deleteUser(int userId);
}
