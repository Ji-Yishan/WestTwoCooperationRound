package org.cooperation.service;

import org.apache.ibatis.annotations.Param;
import org.cooperation.dao.UserMapper;
import org.cooperation.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
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

    public String queryUUID(String username,String password){
        return userMapper.queryUUID(username,password);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
    public List<String> queryId(String username){
        return userMapper.queryId(username);
    }
    public List<User> queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }

    public int queryDegree(String userid){
        return userMapper.queryDegree(userid);
    }
    public Map queryProfile(String userid){
        return userMapper.queryProfile(userid);
    }
}
