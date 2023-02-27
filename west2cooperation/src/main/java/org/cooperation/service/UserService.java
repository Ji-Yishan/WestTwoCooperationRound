package org.cooperation.service;

import org.cooperation.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    List<User> selectUser();
    int addUser(User user);
    int updateUser(User user);
    String queryId(String username);
    List<User> queryUserByName(String username);
    int queryDegree(String userid);
    Map queryProfile(String userid);
    String queryUUID(String username,String password);
}
