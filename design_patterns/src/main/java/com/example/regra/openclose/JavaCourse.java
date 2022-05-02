package com.example.regra.openclose;

/**
 * @ClassName: JavaCourse
 * @Author: lph
 * @Description:
 * @Date: 2022/5/2 15:54
 */
public class JavaCourse implements ICourse{

    private Integer id;

    private String name;

    private Double price;

    public JavaCourse(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public Double price() {
        return this.price;
    }

    @Override
    public Integer id() {
        return this.id;
    }
}
