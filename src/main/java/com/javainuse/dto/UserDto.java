package com.javainuse.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private long age;
    private String login;
    private String password;
    private String phone;
    private List<PostDto> blogDtos;
}
