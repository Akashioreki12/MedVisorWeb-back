package com.emi.medicalimageprocessing.services;

import com.emi.medicalimageprocessing.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto save(UserDto dto);
    UserDto findById(Integer id);
    UserDto findByUsername(String username);
    List<UserDto> findAll();
    void delete(Integer id);


}
