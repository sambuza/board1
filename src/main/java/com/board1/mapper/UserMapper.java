package com.board1.mapper;

import com.board1.dto.UserDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Insert("INSERT INTO Users (Username, PasswordHash, Email, CreatedAt) VALUES (#{username}, #{passwordHash}, #{email}, #{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    void createUser(UserDTO user);

    @Select("SELECT * FROM Users WHERE UserID = #{userId}")
    UserDTO selectUserById(int userId);

    @Select("SELECT * FROM Users")
    List<UserDTO> selectAllUsers();

    @Update("UPDATE Users SET Username = #{username}, PasswordHash = #{passwordHash}, Email = #{email} WHERE UserID = #{userId}")
    void updateUser(UserDTO user);

    @Delete("DELETE FROM Users WHERE UserID = #{userId}")
    void deleteUser(int userId);
}
