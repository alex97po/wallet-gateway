package com.goit.wallet.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

public class UriConfiguration {

    private String httpbin = "http://httpbin.org:80";

    public String getHttpbin() {
        return httpbin;
    }
}
