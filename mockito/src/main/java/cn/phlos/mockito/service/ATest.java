package cn.phlos.mockito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ATest
 * @Author: lph
 * @Description:
 * @Date: 2022/5/25 21:47
 */
@Component
public class ATest {

    @Autowired
    private BTest bTest;

    public String aaa(){
        String aaa = bTest.aaa();
        return "11111";
    }

}
