package com.emi.medicalimageprocessing.Controller.api;
import com.emi.medicalimageprocessing.dto.SurveyDto;
import com.emi.medicalimageprocessing.model.Survey;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


import static com.emi.medicalimageprocessing.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/surveys")
public interface SurveyApi {
    @PostMapping(value = APP_ROOT + "/surveys/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    @ApiOperation(value = "Save a survey (Create/Edit)", notes = "This method allow to create or edit a survey ",
            response = SurveyDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Survey object Created/Edited"),
            @ApiResponse(code = 400, message = "Survey object not valid")
    })
    ResponseEntity<String> save(@RequestBody SurveyDto dto);




    @GetMapping(value = APP_ROOT+"/surveys/find/{id}")
    Optional<Survey> getSurveyById(@PathVariable Integer id);

    @GetMapping(APP_ROOT+"/surveys/findByCin/{cin}")
    Optional<Survey> findByCin(@PathVariable String cin);

    @GetMapping(APP_ROOT+"/surveys/all")
    List<Survey> getAllSurveys();



    @PutMapping(APP_ROOT+"/surveys/update/{id}")
    ResponseEntity<Survey> updateSurvey(@PathVariable Integer id, @RequestBody Survey survey);

    @DeleteMapping(APP_ROOT+"/surveys/delete/{id}")
    ResponseEntity<Void> deleteSurvey(@PathVariable Integer id);

    @GetMapping(APP_ROOT+"/surveys/search/{searchTerm}")
    List<Survey> searchSurveys(@PathVariable String searchTerm);

    @GetMapping(APP_ROOT+"/surveys/searchByDate/{date}")
    List<Survey> searchSurveysByDate(@PathVariable String date);

    @GetMapping(APP_ROOT+"/surveys/allByCin/{cin}")
    List<Survey> findAllByCin(@PathVariable String cin);
}



