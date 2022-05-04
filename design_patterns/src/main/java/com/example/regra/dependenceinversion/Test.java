package com.example.regra.dependenceinversion;

/**
 * @ClassName: Test
 * @Author: lph
 * @Description:
 * @Date: 2022/5/2 16:37
 *
 *
 * 依赖倒置
 * Test应用层    Geely是更高层的   ICourse是契约类   继承ICourse的类是底层类
 *   高层次的模块，不能依赖于低层次的模块
 *
 */
public class Test {

    public static void main(String[] args) {

        Geely geely = new Geely();
        geely.setiCourse(new JavaCourse());
        geely.studyImoocCourse();

        geely.setiCourse(new PythonCourse());
        geely.studyImoocCourse();


    }

}
