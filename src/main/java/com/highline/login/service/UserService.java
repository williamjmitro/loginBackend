package com.highline.login.service;

import com.highline.login.dto.UpdateUserPasswordRequest;
import com.highline.login.dto.UpdateUserPasswordResponse;

public interface UserService {

    public UpdateUserPasswordResponse updateUserPassword(UpdateUserPasswordRequest request);
}
