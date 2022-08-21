package com.example.douyin.zhichuandi0511;

/**
 * @ClassName: ParamTest
 * @Author: lph
 * @Description:
 * @Date: 2022/5/11 22:42
 */
public class ParamTest {

    public static void main(String[] args) {
        String name = "lph";
        Cool cool = new Cool(name);
        x = name.length();
        if (x < 15) name = "hello world";

    }



    public void pass(String name) {
        name = "holler";
        System.out.println("print in pass , name:" + name);
    }

    public void chang(User user) {
        User holler = new User();
        user.setName("holler");
        user.setAge(20);
        System.out.println("print in chang:" + user);
    }

    public static void sout(int param) {//param为形式参数
        param = 20;
        System.out.println("print in sout:" + param);
    }


}
