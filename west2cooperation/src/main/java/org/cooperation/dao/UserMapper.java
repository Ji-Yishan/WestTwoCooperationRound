package org.cooperation.dao;

import org.apache.ibatis.annotations.Mapper;
import org.cooperation.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUser();
    int addUser(User user);
    int updateUser(User user);
    List<User> queryUserByName(String username);
    int queryDegree(String username);

}
