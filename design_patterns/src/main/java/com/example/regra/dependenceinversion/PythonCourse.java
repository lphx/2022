package com.example.regra.dependenceinversion;

/**
 * @ClassName: PythonCourse
 * @Author: lph
 * @Description:
 * @Date: 2022/5/2 16:34
 */
public class PythonCourse implements ICourse{
    @Override
    public void studyCourse() {
        System.out.println("学习Python课程");
    }
}
