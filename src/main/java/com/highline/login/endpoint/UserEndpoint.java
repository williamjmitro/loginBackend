package com.highline.login.endpoint;

import com.highline.login.base.BaseEndpoint;
import com.highline.login.dto.*;
import com.highline.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping(path = "/get/{userId}")
    public String updatePassword(@PathVariable(name = "userId", required = true) String userId, Model model) {
        UserDto userDto = userService.getUser(userId);
        model.addAttribute(userDto.getUserName());
        return "updatePassword";
    }

}
