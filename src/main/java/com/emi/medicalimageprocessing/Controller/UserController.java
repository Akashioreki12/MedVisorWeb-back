package com.emi.medicalimageprocessing.Controller;

import com.emi.medicalimageprocessing.Controller.api.UserApi;
import com.emi.medicalimageprocessing.dto.UserDto;
import com.emi.medicalimageprocessing.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService=userService;
    }

    @Override
    public UserDto save(UserDto dto) {
        return userService.save(dto);
    }

    @Override
    public UserDto findById(Integer id) {
        return userService.findById(id);
    }

    @Override
    public UserDto findByUsername(String username) {
        return userService.findByUsername(username);
    }

    @Override
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @Override
    public void delete(Integer id) {
        userService.delete(id);
    }
}