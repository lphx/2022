package com.example.common.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: AController
 * @Author: lph
 * @Description:
 * @Date: 2022/4/10 23:17
 */
@RestController
public class TestController {

    @GetMapping("/get")
    @Dome(value = {"aaa","bbb"},num=10)
    public  void aa(){
        System.out.println(111);
    }

}
