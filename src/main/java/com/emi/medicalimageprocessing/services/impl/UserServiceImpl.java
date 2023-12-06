package com.emi.medicalimageprocessing.services.impl;

import com.emi.medicalimageprocessing.dto.UserDto;
import com.emi.medicalimageprocessing.exception.EntityNotFoundException;
import com.emi.medicalimageprocessing.exception.ErrorCodes;
import com.emi.medicalimageprocessing.exception.InvalidEntityException;
import com.emi.medicalimageprocessing.model.User;
import com.emi.medicalimageprocessing.repository.UserRepository;
import com.emi.medicalimageprocessing.services.UserService;
import com.emi.medicalimageprocessing.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Autowired
    public  UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public UserDto save(UserDto dto) {
        List<String> errors = UserValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Article is not valid {}", dto);
            throw  new InvalidEntityException("L'article n'est pas valide", ErrorCodes.USER_NOT_VALID, errors);
        }
        return UserDto.fromEntity(userRepository.save(UserDto.toEntity(dto)));
    }

    @Override
    public UserDto findById(Integer id) {
        if (id== null){
            log.error("User ID is null");
            return null;
        }
        Optional<User> user = userRepository.findById(id);
        UserDto dto = UserDto.fromEntity(user.get());
        return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucun" +
                " article avec l'ID =" + id +"n'a été trouve dans la BD", ErrorCodes.USER_NOT_FOUND ));
    }

    @Override
    public UserDto findByUsername(String username) {
        if (!StringUtils.hasLength(username)){
            log.error("User name is null");
            return null;
        }
        Optional<User> user = userRepository.findByUsername(username);
        UserDto dto = UserDto.fromEntity(user.get());
        return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Aucun" +
                " article avec le username =" + username +"n'a été trouve dans la BD", ErrorCodes.USER_NOT_FOUND ));
    }


    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id==null){
            log.error("User ID is null");
        }
        userRepository.deleteById(id);
    }

}
