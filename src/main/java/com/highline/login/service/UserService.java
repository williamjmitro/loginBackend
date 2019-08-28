package com.highline.login.service;

import com.highline.login.dto.*;

public interface UserService {

    public UpdateUserPasswordResponse updateUserPassword(UpdateUserPasswordRequest request);

    public ListUsersResponse listUsers();

    public void addUser(AddUserRequest request);

    public UserDto getUser(String userId);
}
