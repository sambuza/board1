package com.board1.service;

import com.board1.dto.UserDTO;
import com.board1.mapper.UserMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void createUser(UserDTO user) {

        try {
            String plainPassword = user.getPasswordHash();
            String hashedPassword = passwordEncoder.encode(plainPassword);
            System.out.println(hashedPassword); // 이 줄이 정상적으로 실행되지 않을 경우를 대비해 try 블록 내부로 이동

            user.setPasswordHash(hashedPassword);
            userMapper.createUser(user);
        } catch (Exception e) {
            // 예외가 발생할 경우 로그를 출력합니다.
            e.printStackTrace();
            // 또는 로그를 사용하여 예외를 기록할 수 있습니다.
            // logger.error("Error occurred while hashing password: " + e.getMessage());
        }
    }

    @Override
    public UserDTO getUserById(int userId) {
        return userMapper.selectUserById(userId);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userMapper.selectAllUsers();
    }

    @Override
    public UserDTO updateUser(int userId, UserDTO user) {
        user.setUserId(userId);
        userMapper.updateUser(user);
        return user;
    }

    @Override
    public void deleteUser(int userId) {
        userMapper.deleteUser(userId);
    }
}
