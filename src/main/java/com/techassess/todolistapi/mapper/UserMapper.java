package com.techassess.todolistapi.mapper;

import com.techassess.todolistapi.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User getUserById(@Param("id") Long id);
    List<User> getAllUsers();
}
