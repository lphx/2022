package com.example.design_patterns.builder.one;

/**
 * @ClassName: ItemBuilder
 * @Author: lph
 * @Description:
 * @Date: 2022/4/5 22:56
 */
public abstract class ItemBuilder {

    //创建产品对象
    protected Item item = new Item();

    public abstract void buildNormal();

    public abstract void buildCard();

    public abstract void buildVideo();

    //返回产品对象
    public Item getResult(){
        return item;
    }


}
