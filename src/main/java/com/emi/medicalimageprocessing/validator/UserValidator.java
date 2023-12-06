package com.emi.medicalimageprocessing.validator;

import com.emi.medicalimageprocessing.dto.UserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {
    public static List<String> validate (UserDto userDto){
        List<String> errors = new ArrayList<>();
        if (!StringUtils.hasLength(userDto.getFullName())){
            errors.add("Veuiller renseigner le nom complet");
        }
        if (!StringUtils.hasLength(userDto.getUsername())){
            errors.add("Veuiller renseigner le nom d'utilisateur");
        }
        if (!StringUtils.hasLength(userDto.getPassword())){
            errors.add("Veuiller renseigner le mot de passe");
        }

        return errors;
    }
}
