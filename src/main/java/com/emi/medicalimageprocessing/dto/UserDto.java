package com.emi.medicalimageprocessing.dto;

import com.emi.medicalimageprocessing.model.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String prenom;
    private Long numero;

    public static UserDto fromEntity (User user){
        if (user ==null) {
            return null;
        }
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .password(user.getPassword())
                .username(user.getUsername())
                .prenom(user.getPrenom())
                .numero(user.getNumero())
                .build();
    }

    public static User toEntity (UserDto userDto){
        if (userDto ==null) {
            return null;
        }
        User user=new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user.setPrenom(userDto.getPrenom());
        user.setNumero(userDto.getNumero());
        return user;
    }
}