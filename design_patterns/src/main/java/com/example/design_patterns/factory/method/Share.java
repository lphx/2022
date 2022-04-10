package com.example.design_patterns.factory.method;

/**
 * @ClassName: Share
 * @Author: lph
 * @Description:
 * @Date: 2022/4/5 21:40
 */
public interface Share {

    /**
     * 获取分享类型
     * @return
     */
    String getShareFunctionType();


    /**
     *
     * @param shareName
     * @return
     */
    String mainProcess(String shareName);

}
