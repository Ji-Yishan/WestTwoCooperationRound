package org.cooperation.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.cooperation.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> selectUser();
    int addUser(User user);
    int updateUser(User user);
    List<User> queryUserByName(String username);
    int queryDegree(String userid);
    Map queryProfile(String userid);
    List<String> queryId(String username);
    String queryUUID(@Param("username") String username,@Param("password") String password);
}
