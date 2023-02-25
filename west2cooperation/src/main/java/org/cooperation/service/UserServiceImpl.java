package org.cooperation.service;

import org.cooperation.dao.UserMapper;
import org.cooperation.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper){
        this.userMapper=userMapper;
    }
    public List<User> selectUser() {

        return userMapper.selectUser();
    }

    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public List<User> queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }
    public int queryDegree(String username){
        return userMapper.queryDegree(username);
    }
}
