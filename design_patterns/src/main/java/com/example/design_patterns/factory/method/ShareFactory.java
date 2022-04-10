package com.example.design_patterns.factory.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: ShareFactory
 * @Author: lph
 * @Description:
 * @Date: 2022/4/5 21:43
 */
@Component
public class ShareFactory {

    @Autowired
    private List<Share> shareFunctionList;


    public Share getShareFunction(String type){
        for (Share share : shareFunctionList) {
            if (share.getShareFunctionType().equals(type)){
                return share;
            }
        }
        return null;
    }



    public enum EnumShareType{
        SUCCESS_ORDER("successORder");

        private String name;

        EnumShareType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
