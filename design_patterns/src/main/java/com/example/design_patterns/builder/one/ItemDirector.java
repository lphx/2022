package com.example.design_patterns.builder.one;

/**
 * @ClassName: ItemDirector
 * @Author: lph
 * @Description:
 * @Date: 2022/4/5 23:06
 */
public class ItemDirector {
    private ItemBuilder itemBuilder;

    public ItemDirector(ItemBuilder itemBuilder) {
        this.itemBuilder = itemBuilder;
    }

    public Item normalConstruct(){
        itemBuilder.buildNormal();
        return itemBuilder.item;
    }


    public Item cardConstruct(){
        itemBuilder.buildCard();
        return itemBuilder.item;
    }

    public Item videoConstruct(){
        itemBuilder.buildVideo();
        return itemBuilder.item;
    }


}
