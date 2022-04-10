package com.example.design_patterns.factory.method;

import org.springframework.stereotype.Component;

/**
 * @ClassName: SuccessOrderShare
 * @Author: lph
 * @Description:
 * @Date: 2022/4/5 21:49
 */
@Component
public class SuccessOrderShare implements Share{


    @Override
    public String getShareFunctionType() {
        return ShareFactory.EnumShareType.SUCCESS_ORDER.getName();
    }

    @Override
    public String mainProcess(String shareName) {
        //这里写一些处理分享的业务逻辑代码
        return shareName;
    }

}
