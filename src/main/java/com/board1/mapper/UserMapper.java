package com.board1.mapper;

import com.board1.dto.UserDTO;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Insert("INSERT INTO Users (Username, PasswordHash, Email, CreatedAt) VALUES (#{username}, #{passwordHash}, #{email}, #{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    void createUser(UserDTO user);



    @Select("SELECT * FROM Users WHERE UserID = #{UserID}")
    UserDTO selectUserById(int UserId);

    @Select("SELECT * FROM Users")
    List<UserDTO> selectAllUsers();

    void updateUser(@Param("params") Map<String, Object> params);

    @Delete("DELETE FROM Users WHERE UserID = #{userId}")
    void deleteUser(int userId);
    
    int authenticateUser(@Param("userid") String userid, @Param("password") String password);

}
