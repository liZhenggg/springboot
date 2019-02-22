package com.lzg.cloudshop.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "initinfo")
public class InitInfo {

    private String paramInfo1;

    private String paramInfo2;

    public InitInfo() {
    }

    public String getParamInfo1() {
        return paramInfo1;
    }

    public void setParamInfo1(String paramInfo1) {
        this.paramInfo1 = paramInfo1;
    }

    public String getParamInfo2() {
        return paramInfo2;
    }

    public void setParamInfo2(String paramInfo2) {
        this.paramInfo2 = paramInfo2;
    }
}
