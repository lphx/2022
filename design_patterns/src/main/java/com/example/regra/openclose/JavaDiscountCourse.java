package com.example.regra.openclose;

/**
 * @ClassName: JavaDiscountCourse
 * @Author: lph
 * @Description:
 * @Date: 2022/5/2 15:57
 */
public class JavaDiscountCourse extends JavaCourse{
    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }


    public Double originPrice(){
        return super.price() * 0.8;
    }

    @Override
    public Double price() {
        return super.price();
    }
}
