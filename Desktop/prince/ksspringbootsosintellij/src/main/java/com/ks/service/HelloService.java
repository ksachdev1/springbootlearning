package com.ks.service;

import org.springframework.stereotype.Service;

/**
 * Created by kasachde on 7/20/2016.
 */
@Service
public class HelloService {
    String serviceStr;

    public HelloService() {
        this.serviceStr = "kanwaljeet";
    }

    public String getServiceStr() {
        return serviceStr;
    }

    public void setServiceStr(String serviceStr) {
        this.serviceStr = serviceStr;
    }
}
