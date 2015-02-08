package com.unichem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AccountController extends BaseController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model){

        return "login";
    }
}