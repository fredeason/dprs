package com.weimai.dprs.config;

import com.weimai.configcenter.ConfigCenter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * Copyright (c) 2017 Choice, Inc.
 * All Rights Reserved.
 * Choice Proprietary and Confidential.
 *
 * @author mugua
 * @since 2017/11/13 0013
 */
@Component
@ConfigurationProperties(prefix = "weimai.dprs")
public class DprsConfig extends ConfigCenter {

    /**
     * test
     */
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public void refresh() {

    }
}
