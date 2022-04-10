package com.example.design_patterns.builder.one;

/**
 * @ClassName: ItemConCreteBuilder
 * @Author: lph
 * @Description:
 * @Date: 2022/4/5 23:03
 */
public class ItemConCreteBuilder extends ItemBuilder {
    @Override
    public void buildNormal() {
        item.setItemName("普通商品");
        item.setType(1);
    }

    @Override
    public void buildCard() {
        item.setItemName("卡卷商品");
        item.setCode("123456");
        item.setType(2);
    }

    @Override
    public void buildVideo() {
        item.setItemName("视频商品");
        item.setType(3);
        item.setUrl("http://www.baidu.com");
    }
}
