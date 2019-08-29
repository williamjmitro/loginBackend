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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UpdateUserPasswordResponse updateUserPassword(UpdateUserPasswordRequest request) {

        log.info("> updateUserPassword " + request.toString());
        User user = userRepository.findByUsername(request.getUserName());

        UpdateUserPasswordResponse response = new UpdateUserPasswordResponse();
        boolean passwordMatch = (request.getNewPasswordFirst().equals(request.getNewPasswordSecond()) ? true : false);
        boolean validPassword = validatePassword(request.getNewPasswordFirst());


        if (user != null && passwordMatch && validPassword) {

            byte[] password = request.getNewPasswordFirst().getBytes();
            String newPassword = BaseEncoding.base16().encode(password);

            user.setPassword(newPassword);
            userRepository.save(user);
            log.info("Updated password!");

            response.setSuccess(true);
        } else if (!passwordMatch) {
            response.setSuccess(false);
            response.setErrorCode("1");
        } else if (!validPassword) {
            response.setSuccess(false);
            response.setErrorCode("2");
        } else {
            response.setSuccess(false);
            response.setErrorCode("9999");
        }

        log.info("< updateUserPassword " + response.toString());
        return response;
    }

    private Boolean validatePassword(String password) {
        StringBuilder passwordRegex = new StringBuilder("((?=.*[a-z])(?=.*d)(?=.*[A-Z]).{8})");
        Pattern p = Pattern.compile(passwordRegex.toString());
        Matcher m = p.matcher(password);
        return m.matches();
    }

    @Override
    public ListUsersResponse listUsers() {


        List<User> userList = userRepository.findAll();

        ListUsersResponse response = new ListUsersResponse();
        List<UserDto> returnList = new ArrayList<>();
        for (User user : userList) {
            UserDto returnUser = new UserDto();
            returnUser.setUserName(user.getUsername());
            byte[] decodedPassword = BaseEncoding.base16().decode(user.getPassword());
            returnUser.setPassword(new String(decodedPassword));
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

    @Override
    public UserDto getUser(String userId) {

        User user = userRepository.getOne(Integer.valueOf(userId));
        log.info("Found user= " + user.getUsername());
        UserDto returnUser = new UserDto();

        returnUser.setUserName(user.getUsername());

        return returnUser;

    }
}
