package com.unichem.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Mahmud on 2/9/2015.
 */
public class BaseService {

    protected String encrypt(String text){
        String hashedText = "";
        try{
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            hashedText = encoder.encode(text);
        }
        catch (Exception ex){

        }
        return hashedText;
    }

    protected String decrypt(String hashedText){
        String text = "";
        try{
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            text = encoder.encode(hashedText);
        }
        catch (Exception ex){

        }
        return text;
    }
}
