package com.highline.login.endpoint;

import com.highline.login.base.BaseEndpoint;
import com.highline.login.dto.AddUserRequest;
import com.highline.login.dto.ListUsersResponse;
import com.highline.login.dto.UpdateUserPasswordRequest;
import com.highline.login.dto.UpdateUserPasswordResponse;
import com.highline.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/user")
public class UserEndpoint extends BaseEndpoint {

    @Autowired
    UserService userService;

    @ResponseBody
    @PutMapping(value = "/update")
    public UpdateUserPasswordResponse updateUserPassword(@RequestBody UpdateUserPasswordRequest request) {
        return userService.updateUserPassword(request);
    }

    @ResponseBody
    @GetMapping(path = "/list")
    public ListUsersResponse listUser() {
        return userService.listUsers();
    }

    @ResponseBody
    @PostMapping(path = "/add")
    public void addUser(@RequestBody AddUserRequest request) {
        userService.addUser(request);
    }

    @GetMapping(path = "/get")
    public String index() {
        return "index";
    }

}
