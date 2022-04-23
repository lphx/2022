package lph.service.impl;

import lph.domain.User;
import lph.service.UserService;
import springmvc.annotation.Service;

/**
 * @ClassName: UserServiceImpl
 * @Author: lph
 * @Description:
 * @Date: 2022/4/23 22:14
 */
@Service(value="userService")
public class UserServiceImpl implements UserService {


    public  void  findUser(){
        System.out.println("====调用UserServiceImpl==findUser===");
    }

    public User getUser(){

        return new User(1,"老王","admin");
    }

}
