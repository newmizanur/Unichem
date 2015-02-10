package com.unichem.controller;

import com.unichem.model.viewmodel.UserModel;
import com.unichem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;


@Controller
@RequestMapping(value = "/account")
public class AccountController extends BaseController {

    @Autowired
    private UserService userService;

    private boolean isPhotoRequired = true;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin(Model model){

        return "login";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfile(Model model){

        UserModel userModel = new UserModel();
        userModel.setUsername("shantousa1@gmail.com");
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


    @RequestMapping(value = "/create", method = RequestMethod.POST,headers = "content-type=multipart/*")
    public String createUser(Model model,@ModelAttribute("user") @Valid UserModel userModel,@RequestParam("file") MultipartFile file,BindingResult result){

        if(result.hasErrors()){

            model.addAttribute("userMessage",result.getAllErrors().get(0));
            return "createAccount";
        }

        String fileName = this.saveFile(userModel,file);
        if(isPhotoRequired && fileName.isEmpty()){
            model.addAttribute("userMessage","Please check upload file.");
            return "createAccount";
        }
        userModel.setLogo(fileName);
        userService.createUser(userModel);

        return "redirect:/";
    }

    private String saveFile(UserModel userModel, MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                CommonsMultipartFile actualFile =  (CommonsMultipartFile)file;
                String name = new Date().getTime()+"_" + actualFile.getFileItem().getName();
                userModel.setLogo(name);
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                System.out.print("Server File Location="
                        + serverFile.getAbsolutePath());

                //return "You successfully uploaded file=" + name;
                return name;
            } catch (Exception e) {
                return "";
                //return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            /*return "You failed to upload " + name
                    + " because the file was empty.";*/
            return "";
        }
    }

}
