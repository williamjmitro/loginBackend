package com.highline.login.service;

import com.highline.login.dto.AddUserRequest;
import com.highline.login.dto.ListUsersResponse;
import com.highline.login.dto.UpdateUserPasswordRequest;
import com.highline.login.dto.UpdateUserPasswordResponse;

public interface UserService {

    public UpdateUserPasswordResponse updateUserPassword(UpdateUserPasswordRequest request);

    public ListUsersResponse listUsers();

    public void addUser(AddUserRequest request);

    public void getUser(String userId);
}
