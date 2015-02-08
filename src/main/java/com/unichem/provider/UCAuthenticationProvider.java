package com.unichem.provider;

import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UCAuthenticationProvider implements AuthenticationProvider {


    private String ROLE_USER = "ROLE_USER";

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if (authentication.getName() != null && authentication.getCredentials() != null) {
            try {

                WebAuthenticationDetails authenticationDetails = (WebAuthenticationDetails) authentication.getDetails();

                if ("admin@unichem.com".equalsIgnoreCase(authentication.getName()) && "123".equalsIgnoreCase(authentication.getCredentials().toString())) {
                    List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
                    AUTHORITIES.add(new SimpleGrantedAuthority(ROLE_USER));
                    HashMap<String, String> userDetails = new HashMap<String, String>();
                    userDetails.put("userName", authentication.getName());
                    return new UsernamePasswordAuthenticationToken(userDetails, "", AUTHORITIES);
                } else {
                    throw new UCUserStatusException("Login credentials not matching, please login again.");
                }


            } catch (ResourceAccessException ex) {
                throw new UCUserStatusException("Sorry! Our system upgrading.Please be patient for some time.");
            } catch (NullPointerException ex) {
                throw new UCUserStatusException("Login credentials not matching, please login again.");
            } catch (Exception ex) {
                throw new UCUserStatusException(ex.getMessage());
            }
        } else {
            throw new UCUserStatusException("Login credentials not matching, please login again.");
        }


    }

    @Override
    public boolean supports(Class<? extends Object> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);

    }
}

class UCUserStatusException extends AccountStatusException {
    public UCUserStatusException(String msg) {
        super(msg);
    }
}

