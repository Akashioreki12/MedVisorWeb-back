package com.emi.medicalimageprocessing.Controller.api;

import com.emi.medicalimageprocessing.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.emi.medicalimageprocessing.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/users")
public interface UserApi {
    @GetMapping(value = APP_ROOT + "/users/{idUser}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Find a user by ID", notes = "This method allow to find a user by its ID", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User found in database"),
            @ApiResponse(code = 404, message = "User with provided ID not found")
    })
    UserDto findById(@PathVariable("idUser") Integer id);
    @PostMapping(value = APP_ROOT + "/users/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Save a user (Create/Edit)", notes = "This method allow to create or edit a user ",
            response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User object Created/Edited"),
            @ApiResponse(code = 400, message = "User object not valid")
    })
    UserDto save(@RequestBody UserDto dto);




    @GetMapping(value = APP_ROOT + "/users/byusername/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Find a user by username", notes = "This method allow to find a user by its " +
            "username ", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User found in database"),
            @ApiResponse(code = 404, message = "User with provided username not found")
    })
    UserDto findByUsername(@PathVariable("userName") String username);

    @GetMapping(value = APP_ROOT + "/users/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Send the list of users", notes = "This method allow to send the list of users " +
            "in the BDD", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of users / void list"),
    })
    List<UserDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/users/delete/{idUser}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Delete a user", notes = "This method allow to delete a user by its ID", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User deleted successfully"),
    })
    void delete(@PathVariable("idUser") Integer id);

}