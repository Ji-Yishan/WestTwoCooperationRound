package org.cooperation.service;

import org.cooperation.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<User> selectUser();
    int addUser(User user);
    int updateUser(User user);
    List<User> queryUserByName(String username);
    int queryDegree(String username);
}
