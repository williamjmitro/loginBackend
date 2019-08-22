package com.highline.login.service;

import com.highline.login.dto.ListUsersResponse;
import com.highline.login.dto.UpdateUserPasswordRequest;
import com.highline.login.dto.UpdateUserPasswordResponse;

public interface UserService {

    public UpdateUserPasswordResponse updateUserPassword(UpdateUserPasswordRequest request);

    public ListUsersResponse listUsers();
}
