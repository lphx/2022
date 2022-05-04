package com.example.regra.dependenceinversion;

/**
 * @ClassName: JavaCourse
 * @Author: lph
 * @Description:
 * @Date: 2022/5/2 16:32
 */
public class JavaCourse implements ICourse{
    @Override
    public void studyCourse() {
        System.out.println("学习java课程");
    }
}
