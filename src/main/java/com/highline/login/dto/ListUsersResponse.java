package com.highline.login.dto;

import java.util.List;


public class ListUsersResponse {

    List<UserDto> userList;

    public List<UserDto> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDto> userList) {
        this.userList = userList;
    }
}
