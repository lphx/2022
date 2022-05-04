package com.example.regra.dependenceinversion;

/**
 * @ClassName: FECourse
 * @Author: lph
 * @Description:
 * @Date: 2022/5/2 16:33
 */
public class FECourse implements ICourse{
    @Override
    public void studyCourse() {
        System.out.println("学习前端FE课程");
    }
}
