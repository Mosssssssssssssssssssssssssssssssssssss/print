package com.nnxy.print116.controller;

import com.nnxy.print116.entity.User;
import com.nnxy.print116.service.LoginAndRegisterService;
import com.nnxy.print116.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class LoginAndRegisterController {
    @Autowired
    private LoginAndRegisterService loginAndRegisterService;
    @RequestMapping("/register")
    @ResponseBody
    public Message register(@RequestParam("registerNum") String registerNum,
                            @RequestParam("name") String name,
                            @RequestParam("phone") String phone,
                            @RequestParam("password") String password){
        User user = new User();
        user.setNumber(registerNum);
        user.setName(name);
        user.setPassword(password);
        user.setPhone(phone);
        System.out.println(user);
        boolean exist = loginAndRegisterService.exist(registerNum);
        if(true==exist){
            return new Message("error","你的学号已存在，请重新输入！");
        }else {
            boolean b = loginAndRegisterService.register(user);
            if (true == b) {
                return new Message("success", "用户注册成功！");
            } else {
                return new Message("error", "用户注册失败，请重试！");
            }
        }
    }
    @RequestMapping("/login")
    @ResponseBody
    public Message login(User user){
        System.out.println(user);
        boolean exist = loginAndRegisterService.exist(user.getNumber());
        if(false==exist){
            return new Message("error","没有这个用户");
        }else {
            boolean flag = loginAndRegisterService.login(user);
            if (true == flag) {
                User loginedUser = loginAndRegisterService.getUser(user);
                return new Message("success", "用户登陆成功！",loginedUser);
            } else {
                System.out.println("3");
                return new Message("error", "用户名或密码错误，请重新输入！");
            }
        }
    }
}
