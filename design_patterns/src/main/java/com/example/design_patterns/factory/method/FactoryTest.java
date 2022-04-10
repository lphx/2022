package com.example.design_patterns.factory.method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: FactoryTest
 * @Author: lph
 * @Description:
 * @Date: 2022/4/5 21:51
 */
public class FactoryTest {


    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        ShareFactory shareFactory = (ShareFactory) applicationContext.getBean("shareFactory");
        Share shareFunction = shareFactory.getShareFunction(ShareFactory.EnumShareType.SUCCESS_ORDER.getName());
        String success_order = shareFunction.mainProcess("Success order");
        System.out.println(success_order);


    }

}
