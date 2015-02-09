package com.unichem.controller;

import com.unichem.model.viewmodel.UserModel;
import com.unichem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/account")
public class AccountController extends BaseController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin(Model model){

        return "login";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfile(Model model){

        UserModel userModel = new UserModel();
        userModel.setUsername("shantousa@gmail.com");
        userModel.setPassword("123456");
        userModel.setFullName("test user");
        userModel.setSecretQuestion("what is black?");
        userModel.setSecretAnswer("a color");
        userModel.setLogo("/img/demo.png");
        userModel.setPhone("01716280820");
        userModel.setRoles(new String[]{"ROLE_USER"});

        //userService.createUser(userModel);

        return "homeTemplate";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getCreateUser(Model model){

        UserModel userModel = new UserModel();
        userModel.setAppRoles((new String[]{"ROLE_USER","ROLE_ADMIN"}));
        model.addAttribute("user",userModel);
        return "createAccount";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createUser(Model model,@ModelAttribute("user") UserModel userModel){

        return "createAccount";
    }

}
