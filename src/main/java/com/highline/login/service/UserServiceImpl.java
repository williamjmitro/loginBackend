package com.highline.login.service;

import com.highline.login.base.BaseService;
import com.highline.login.data.UserRepository;
import com.highline.login.domain.User;
import com.highline.login.dto.UpdateUserPasswordRequest;
import com.highline.login.dto.UpdateUserPasswordResponse;
import org.springframework.beans.factory.annotation.Autowired;

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
}
