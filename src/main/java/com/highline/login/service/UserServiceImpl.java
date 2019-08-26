package com.highline.login.service;

import com.google.common.io.BaseEncoding;
import com.highline.login.base.BaseService;
import com.highline.login.data.UserRepository;
import com.highline.login.domain.User;
import com.highline.login.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UpdateUserPasswordResponse updateUserPassword(UpdateUserPasswordRequest request) {

        log.info("> updateUserPassword ");
        User user = userRepository.findByUsername(request.getUserName());

        UpdateUserPasswordResponse response = new UpdateUserPasswordResponse();
        byte[] currentPassword = BaseEncoding.base16().decode(user.getPassword());
        log.info("current password " + currentPassword.toString());

        byte[] testPassword = request.getOldPassword().getBytes();
        String newTestPassword = BaseEncoding.base16().encode(testPassword);

        log.info("passed in password " + newTestPassword.toString());
        if (currentPassword.toString().equals(request.getOldPassword())) {

            byte[] password = request.getNewPassword().getBytes();
            String newPassword = BaseEncoding.base16().encode(password);

            user.setPassword(newPassword);
            userRepository.save(user);

            response.setSuccess(true);

        } else {

            response.setSuccess(false);
            response.setError("Invalid password");

        }

        return response;
    }

    @Override
    public ListUsersResponse listUsers() {


        List<User> userList = userRepository.findAll();

        ListUsersResponse response = new ListUsersResponse();
        List<UserDto> returnList = new ArrayList<>();
        for (User user : userList) {
            UserDto returnUser = new UserDto();
            returnUser.setUserName(user.getUsername());
            returnList.add(returnUser);
        }
        response.setUserList(returnList);
        return response;
    }

    @Override
    public void addUser(AddUserRequest request) {
        User newUser = new User();

        newUser.setUsername(request.getUserName());
        byte[] password = request.getPassword().getBytes();
        String newPassword = BaseEncoding.base16().encode(password);
        newUser.setPassword(newPassword);
        newUser.setCreatedOn(new Date());

        userRepository.save(newUser);


    }
}
