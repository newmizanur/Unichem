package com.unichem.services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Mizan on 8/13/2014.
 */
@Service
public class HomeService extends BaseService{

    @Value("${webapp.host}")
    private String webAppHostUrl;

    public String getWebAppHostUrl(){
        return webAppHostUrl;
    }
}
