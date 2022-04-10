package com.example.design_patterns.builder.one;

/**
 * @ClassName: Item
 * @Author: lph
 * @Description:
 * @Date: 2022/4/5 22:57
 */
public class Item {

    private String itemName;

    private Integer type;

    private String code;

    private String url;


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", type=" + type +
                ", code='" + code + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
