package com.unichem.services;

import com.unichem.model.entity.User;
import com.unichem.model.entity.UserRole;
import com.unichem.model.viewmodel.UserModel;
import com.unichem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

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
        user.setEmail(userModel.getEmail());
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
                userRole.setUser(user);
                user.getUserRole().add(userRole);
            }
        }

        return user;
    }

    public List<UserModel> getAccounts(){
        List<UserModel> userModelList  = new ArrayList<UserModel>();
        try{
            List<User> users = userRepository.getAll();
            userModelList = this.getAllUserModelFromUser(users);
        }
        catch (Exception ex){

        }


        return userModelList;
    }

    private List<UserModel> getAllUserModelFromUser(List<User> users){
        List<UserModel> userModelList  = new ArrayList<UserModel>();
        if(users !=null && users.size() > 0){
            for (User user:users){
                UserModel userModel = this.getUserEntityFromUserModel(user);
                userModelList.add(userModel);
            }
        }
        return userModelList;
    }

    private UserModel getUserEntityFromUserModel(User user){

        UserModel userModel = new UserModel();
        if(user!=null) {
            userModel.setId(user.getId());
            userModel.setUsername(user.getUsername());
            userModel.setPassword(this.decrypt(user.getPassword()));
            userModel.setFullName(user.getFullName());
            userModel.setSecretQuestion(user.getSecretQuestion());
            userModel.setSecretAnswer(user.getSecretAnswer());
            userModel.setEmail(user.getEmail());
            userModel.setLogo(user.getLogo());
            userModel.setPhone(user.getPhone());
            userModel.setCreateDate(user.getCreateDate());
            userModel.setEnabled(user.isEnabled());

            Set<UserRole> rolesEntity = user.getUserRole();
            List<String> roles = new ArrayList<String>();
            if (rolesEntity != null && rolesEntity.size() > 0) {
                for (UserRole role : rolesEntity) {
                    roles.add((role.getRole()));
                }
            }

            userModel.setRoles(roles.toArray(new String[roles.size()]));
        }
        return userModel;
    }


}
