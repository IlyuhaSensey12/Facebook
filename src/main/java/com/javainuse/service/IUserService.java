package com.javainuse.service;

import com.javainuse.dto.UserDto;
import com.javainuse.model.UserEntity;
import org.springframework.security.core.userdetails.User;

public interface IUserService {
    void save(UserDto userDto);
}
