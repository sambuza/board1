package com.board1.service;

import com.board1.dto.UserDTO;
import com.board1.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void createUser(UserDTO user) {

        userMapper.createUser(user);
    }

    @Override
    public UserDTO getUserById(int UserID) {
        return userMapper.selectUserById(UserID);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userMapper.selectAllUsers();
    }

    @Override
    public void updateUser(int UserID, String username, String email, String PasswordHash, LocalDateTime createdAt) {
        Map<String, Object> params = new HashMap<>();
        params.put("UserID", UserID);
        if (username != null) params.put("username", username);
        if (email != null) params.put("email", email);
        if (PasswordHash != null) params.put("PasswordHash", PasswordHash);
        if (createdAt != null) params.put("createdAt", createdAt);

        userMapper.updateUser(params);
    }

    @Override
    public void deleteUser(int UserId) {
        userMapper.deleteUser(UserId);
    }

    @Override
    public int authenticateUser(String userid, String password) {
        return userMapper.authenticateUser(userid, password);

    }
    

}
