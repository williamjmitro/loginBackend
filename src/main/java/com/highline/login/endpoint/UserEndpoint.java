package com.highline.login.endpoint;

import com.highline.login.dto.UpdateUserPasswordRequest;
import com.highline.login.dto.UpdateUserPasswordResponse;
import com.highline.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hasher")
public class UserEndpoint {

    @Autowired
    UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/update", method = RequestMethod.GET, produces = "application/json")
    public UpdateUserPasswordResponse updateUserPassword(UpdateUserPasswordRequest request) {
        return userService.updateUserPassword(request);
    }

}
