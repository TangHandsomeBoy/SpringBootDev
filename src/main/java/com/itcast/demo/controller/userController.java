package com.itcast.demo.controller;

import com.github.pagehelper.PageInfo;
import com.itcast.demo.domain.User;
import com.itcast.demo.service.QuartzService;
import com.itcast.demo.service.UserService;
import com.itcast.demo.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.util.logging.Log;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author tzc
 * @date 2020/3/26 9:46
 */

@Controller
@Slf4j
public class userController {

    @Autowired
    private UserService userService;


    /**查询所有用户
     * @param userA
     * @return
     */
    @PostMapping("/selectUser")
    @ResponseBody
    public List<User> selectUser(User userA){
        List<User> list = userService.selectUser();
        String str="这是Slf4j打印的日志";
        log.info("this is 日志:{}",str);
        return list;
    }

    @PostMapping("/selectUser/{page}/{size}")
    @ResponseBody
    public Result<PageInfo> selectPageUser(@PathVariable int page,@PathVariable int size){

        PageInfo<User> userPageInfo = userService.selectPageUser(page, size);
        String str="这是Slf4j打印的日志";
        log.info("this is 日志:{}",str);
        return new Result<>(true,200,"查询成功",userPageInfo);
    }


    /**
     * 根据用户id查询用户
     * @param userId
     * @return
     */
    @PostMapping("/selectById")
    @ResponseBody
    public User selectById(Integer userId ){
        User user = userService.selectUserById(userId);
        return user;
    }

    @PostMapping("/updateById")
    @ResponseBody
    public int updateById(User user ){
        int a = userService.updateUser(user);
        return a;
    }


    @PostMapping("/hello")
    @ResponseBody
    public String hello(Model model){
        String name="hello";
        model.addAttribute("name",name);
        return "hello";
    }

    @RequestMapping("/user")
    public String user(Model model){
        return "user";
    }

    @RequestMapping("/cuowu")
    public String cuowu(){
        return  "cuowu";
    }

    @RequestMapping("/userDetail")
    public String userDetail(){
        return  "userDetail";
    }

    @RequestMapping("/updateUser")
    public String updateUser(Integer userId){
        return  "updateUser";
    }

    @Autowired
    private QuartzService quartzService;

/*    @PostMapping("/timer")
    @ResponseBody
    public String timer(){
        quartzService.taskDoSomthing();
        return "成功";
    }*/

}
