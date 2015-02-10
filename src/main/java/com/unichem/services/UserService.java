package com.unichem.services;

import com.unichem.model.entity.User;
import com.unichem.model.entity.UserRole;
import com.unichem.model.viewmodel.UserModel;
import com.unichem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 2/10/2015.
 */
@Service
@Transactional
public class UserService extends BaseService{

    @Autowired
    private UserRepository userRepository;

    public boolean createUser(UserModel userModel){
        User user = this.getUserEntityFromUserModel(userModel);
        try{
            userRepository.create(user);
            return true;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    private User getUserEntityFromUserModel(UserModel userModel){

        User user = new User();
        user.setUsername(userModel.getUsername());
        user.setPassword(this.encrypt(userModel.getPassword()));
        user.setFullName(userModel.getFullName());
        user.setSecretQuestion(userModel.getSecretQuestion());
        user.setSecretAnswer(userModel.getSecretAnswer());
        user.setLogo(userModel.getLogo());
        user.setPhone(userModel.getPhone());
        user.setCreateDate(new Date());
        user.setEnabled(true);

        Set<UserRole> rolesEntity = new HashSet<UserRole>();
        String[] roles = userModel.getRoles();
        if(roles!=null && roles.length > 0){
            for(String role:roles){

                UserRole userRole = new UserRole();
                userRole.setRole(role);
                user.getUserRole().add(userRole);
            }
        }

        return user;
    }


}
