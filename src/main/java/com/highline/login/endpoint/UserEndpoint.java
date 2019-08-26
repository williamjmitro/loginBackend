package com.highline.login.endpoint;

import com.highline.login.base.BaseEndpoint;
import com.highline.login.dto.AddUserRequest;
import com.highline.login.dto.ListUsersResponse;
import com.highline.login.dto.UpdateUserPasswordRequest;
import com.highline.login.dto.UpdateUserPasswordResponse;
import com.highline.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserEndpoint extends BaseEndpoint {

    @Autowired
    UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public UpdateUserPasswordResponse updateUserPassword(@RequestBody UpdateUserPasswordRequest request) {
        return userService.updateUserPassword(request);
    }

    @CrossOrigin
    @GetMapping(path = "/list")
    public ListUsersResponse listUser() {
        return userService.listUsers();
    }

    @CrossOrigin
    @PostMapping(path = "/add")
    public void addUser(@RequestBody AddUserRequest request) {
        userService.addUser(request);
    }
}
