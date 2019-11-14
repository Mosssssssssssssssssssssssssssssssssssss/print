package com.nnxy.print116.service;

import com.nnxy.print116.dao.LoginAndRegisterMapper;
import com.nnxy.print116.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginAndRegisterService {
    @Autowired
    private LoginAndRegisterMapper loginAndRegisterMapper;

    public boolean register(User user){
        Integer flag = loginAndRegisterMapper.insert(user);
        if(1 > flag){
            return false;
        }else{
            return true;
        }
    }

    public boolean exist(String registerNum) {
        Integer count = loginAndRegisterMapper.exist(registerNum);
        if(1==count){
            return true;
        }else {
            return false;
        }
    }

    public boolean login(User user) {
        Integer count = loginAndRegisterMapper.select(user);
        if(1==count){
            return true;
        }else {
            return false;
        }
    }

    public User getUser(User user){
        return loginAndRegisterMapper.selectUser(user);
    }
}
