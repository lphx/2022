package com.example.regra.openclose;

/**
 * @ClassName: Test
 * @Author: lph
 * @Description:
 * @Date: 2022/5/2 15:56
 *
 * 开闭原则，如修改价格只在子类JavaDiscountCourse上去修改，而不涉及到原父类或是接口的变动，减少依赖
 *
 *
 */
public class Test {

    public static void main(String[] args) {
        ICourse course = new JavaDiscountCourse(96, "lph开闭原则", 348d);
        JavaDiscountCourse javaDiscountCourse = (JavaDiscountCourse)course;
        System.out.println("课程ID:"+javaDiscountCourse.id()+"课程名称："+javaDiscountCourse.name()
                +"课程价格："+javaDiscountCourse.price()+"打折后价格："+javaDiscountCourse.originPrice());

    }

}
