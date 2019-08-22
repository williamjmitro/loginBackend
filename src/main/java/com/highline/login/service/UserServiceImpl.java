package com.highline.login.service;

import com.highline.login.base.BaseService;
import com.highline.login.data.UserRepository;
import com.highline.login.domain.User;
import com.highline.login.dto.ListUsersResponse;
import com.highline.login.dto.UpdateUserPasswordRequest;
import com.highline.login.dto.UpdateUserPasswordResponse;
import com.highline.login.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UpdateUserPasswordResponse updateUserPassword(UpdateUserPasswordRequest request) {

        User user = userRepository.findByUsername(request.getUserName());

        UpdateUserPasswordResponse response = new UpdateUserPasswordResponse();

        if (user.getPassword().equals(request.getOldPassword())) {

            user.setPassword(request.getNewPassword());
            userRepository.save(user);

            response.setSuccess(true);

        } else {
            response.setSuccess(false);
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
}
