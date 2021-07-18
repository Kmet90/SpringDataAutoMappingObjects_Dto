package com.example.springdataautomappingobjects_dto.service;

import com.example.springdataautomappingobjects_dto.model.dto.UserLoginDto;
import com.example.springdataautomappingobjects_dto.model.dto.UserRegisterDto;

public interface UserService {

    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();
}
