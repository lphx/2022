package lph.controller;

import lph.domain.User;
import lph.service.UserService;
import springmvc.annotation.AutoWired;
import springmvc.annotation.Controller;
import springmvc.annotation.RequestMapping;
import springmvc.annotation.ResponseBody;

/**
 * @ClassName: UserController
 * @Author: lph
 * @Description:
 * @Date: 2022/4/23 22:13
 */
@Controller
public class UserController {

    @AutoWired(value="userService")
    private UserService userService;


    //定义方法
    @RequestMapping("/findUser")
    public  String  findUser(String name){
        //调用服务层
        userService.findUser();
        return "forward:/success.jsp";
    }

    @RequestMapping("/getData")
    @ResponseBody  //返回json格式的数据
    public User getData(){
        //调用服务层
        return userService.getUser();
    }
}
