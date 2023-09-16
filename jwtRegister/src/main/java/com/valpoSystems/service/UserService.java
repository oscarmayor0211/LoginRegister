package com.valpoSystems.service;

import com.valpoSystems.domain.models.UserModel;
import com.valpoSystems.domain.request.UserRequest;
import com.valpoSystems.domain.response.UserResponse;
import com.valpoSystems.exception.InvalidPasswordException;
import com.valpoSystems.exception.UserException;

public interface UserService {
    UserModel save(UserRequest userRequest) throws UserException, InvalidPasswordException;
    UserModel UpdateUser(UserModel UserModel) throws UserException, InvalidPasswordException;
}
