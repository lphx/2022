package com.example.design_patterns.builder.one;

/**
 * @ClassName: testDemo
 * @Author: lph
 * @Description:
 * @Date: 2022/4/5 23:02
 */
public class testDemo {

    public static void main(String[] args) {
        ItemBuilder builder = new ItemConCreteBuilder();
        ItemDirector director = new ItemDirector(builder);
        Item item2 = director.normalConstruct();
        System.out.println(item2.toString());
        Item item3 = director.cardConstruct();
        System.out.println(item3);

        ItemBuilder builder2 = new ItemConCreteBuilder();
        builder2.buildNormal();
        Item result = builder2.getResult();
        System.out.println(result);

    }

}
