package com.itcast.demo.controller;

import com.itcast.demo.domain.User;
import com.itcast.demo.service.UserService;
import com.itcast.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/loginUser")
    public String login(Model model){
        return "loginUser";
    }

    @PostMapping("/judeg")
    @ResponseBody
    public Result judge(User user){

        User user1 = userService.selectUserByName(user.getUserName());
        if (user1 == null) {
            return new Result(false, 1, "用户名不存在");
        }
        User user2 = userService.selectUserByLog(user.getUserName(), user.getPassword());
        if (!user.getUserName().equals(user2.getUserName()) || !user.getPassword().equals(user2.getPassword())) {
            return new Result(true, 1, "用户名或密码不正确！");
        } else {
            return new Result(true, 0, "登录成功!！");
        }

    }
}
