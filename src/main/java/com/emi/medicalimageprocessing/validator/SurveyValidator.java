package com.emi.medicalimageprocessing.validator;

import com.emi.medicalimageprocessing.dto.SurveyDto;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
@Component
public class SurveyValidator {


    public static List<String> validate(SurveyDto surveyDto) {


        List<String> errors = new ArrayList<>();

        validateFirstName(surveyDto.getFirstName(), "First Name", errors);
        validateLastName(surveyDto.getLastName(), "Last name", errors);
        validateAge(surveyDto.getAge(), "Age", errors);
        validateCountryCode(surveyDto.getCountryCode(),"Country Code",errors);
        validatePhoneNumber(surveyDto.getPhoneNumber(),"Phone Number", errors);
        validateEmail(surveyDto.getEmail(),"Email",errors);
        validateMaritalStatus(surveyDto.getMaritalStatus(),"Marital Status", errors);
        validateGender(surveyDto.getGender(),"Gender", errors);
        validateCIN(surveyDto.getCin(),"CIN", errors);




        validateWeight(surveyDto.getWeight(),"Weight",errors);
        validateHeight(surveyDto.getHeight(),"Height",errors);
        validateBMI(surveyDto.getBmi(),"BMI", errors);
        validateCholesterolTotal(surveyDto.getTotalCholesterol(),"Total Cholesterol",errors);
        validateLDL(surveyDto.getLdlCholesterol(),"LDL", errors);
        validateHDL(surveyDto.getHdlCholesterol(),"HDL",errors);
        validateGlucose(surveyDto.getGlucoseLevel(),"Glucose",errors);
        validateHeartDisease(surveyDto.getHeartDisease(),"Heart Disease",errors);
        validateDiabetes(surveyDto.getDiabetes(),"Diabetes",errors);
        validateHypertension(surveyDto.getHypertension(),"Hypertension",errors);



        validateHistoryOfTIAs(surveyDto.getHistoryOfTIAs(),"History of TIAS",errors);
        validateHeredityOrGenetics(surveyDto.getHeredityOrGenetics(),"Heredity or Genetics",errors);
        validateResidentialArea(surveyDto.getResidentialArea(),"Residential Area",errors);
        validateSmokingStatus(surveyDto.getSmokingStatus(),"Smoking Status",errors);
        validateAlcoholStatus(surveyDto.getAlcoholStatus(),"Alcohol Status",errors);
        validateWorkType(surveyDto.getWorkType(),"Work Type",errors);


        return errors;


    }


    public static void validateFirstName(String fieldValue, String fieldName, List<String> errors) {

        int minLength = 2;
        int maxLength = 50;
        String pattern = "^[a-zA-Z\\s]*$";


        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        }

        if (fieldValue != null) {
            if (fieldValue.length() < minLength || fieldValue.length() > maxLength) {
                errors.add(fieldName + " must be between " + minLength + " and " + maxLength + " characters");
            }

            if (!fieldValue.matches(pattern)) {
                errors.add(fieldName + " can only contain alphabetical characters and spaces");
            }
        }

    }

    public static void validateLastName(String fieldValue, String fieldName, List<String> errors) {

        int minLength = 2;
        int maxLength = 50;
        String pattern = "^[a-zA-Z\\s]*$";


        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        }

        if (fieldValue != null) {
            if (fieldValue.length() < minLength || fieldValue.length() > maxLength) {
                errors.add(fieldName + " must be between " + minLength + " and " + maxLength + " characters");
            }

            if (!fieldValue.matches(pattern)) {
                errors.add(fieldName + " can only contain alphabetical characters and spaces");
            }
        }

    }

    public static void validateAge(Integer fieldValue, String fieldName, List<String> errors) {
        int minAge = 2;
        int maxAge = 100;
        String pattern = "^\\d+$";

        if (fieldValue == null) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else {
            if (fieldValue < minAge || fieldValue > maxAge) {
                errors.add(fieldName + " must be between 18 and 100");
            }

            if (!String.valueOf(fieldValue).matches(pattern)) {
                errors.add(fieldName + " must be a positive integer");
            }
        }

    }


    public static void validateGender(String fieldValue,String fieldName,List<String> errors) {
        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!fieldValue.equals("Female") && !fieldValue.equals("Male")) {
            errors.add(fieldName + " must be either Female or Male");
        }
    }

    public static void validatePhoneNumber(String fieldValue,String fieldName,List<String> errors) {
        String pattern = "^[0-9]{9}$";
        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!fieldValue.matches(pattern)) {
            errors.add(fieldName + " must be a 9-digit number");
        }
    }

    public static void validateMaritalStatus(String fieldValue,String fieldName ,List<String> errors) {
        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!fieldValue.equals("Yes") && !fieldValue.equals("No")) {
            errors.add(fieldName + " must be either Yes or No");
        }
    }

    public static void validateEmail(String fieldValue,String fieldName ,List<String> errors) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else {
            Pattern pattern = Pattern.compile(emailRegex);

            if (!pattern.matcher(fieldValue).matches()) {
                errors.add("Please provide a valid " + fieldName.toLowerCase());
            }
        }
    }

    public static void validateCIN(String fieldValue,String fieldName ,List<String> errors) {

        String pattern = "^[a-zA-Z0-9]*$";

        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (fieldValue.length() != 8) {
            errors.add(fieldName + " must be exactly 8 characters long");
        } else if (!fieldValue.matches(pattern)) {
            errors.add(fieldName + " must contain only alphanumeric characters");
        }
    }

    public static void validateCountryCode(String fieldValue,String fieldName ,List<String> errors) {

        String pattern = "^\\+\\d{1,5}$";
        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!fieldValue.matches(pattern)) {
            errors.add(fieldName + " must be in the format of a plus sign followed by up to 5 digits");
        }
    }





    public static void validateWeight(String fieldValue,String fieldName ,List<String> errors) {

        double minValue = 40;
        double maxValue = 200;
        String pattern = "^\\d+(\\.\\d{1,2})?$";

        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!fieldValue.matches(pattern)) {
            errors.add(fieldName + " must be a numeric value with up to two decimal places");
        } else {
            double numericWeight = Double.parseDouble(fieldValue);



            if (numericWeight < minValue || numericWeight > maxValue) {
                errors.add(fieldName + " must be between " + minValue + " and " + maxValue);
            }
        }
    }


    public static void validateHeight(String fieldValue,String fieldName ,List<String> errors) {

        double minValue = 1.40;
        double maxValue = 2.2;
        String pattern = "^\\d+(\\.\\d{1,2})?$";

        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!fieldValue.matches(pattern)) {
            errors.add(fieldName + " must be a numeric value with up to two decimal places");
        } else {
            double numericWeight = Double.parseDouble(fieldValue);


            if (numericWeight < minValue || numericWeight > maxValue) {
                errors.add(fieldName + " must be between " + minValue + " and " + maxValue);
            }
        }
    }



    public static void validateBMI(String fieldValue,String fieldName ,List<String> errors) {

        double minValue = 10;
        double maxValue = 40;

        String pattern = "^\\d+(\\.\\d{1,2})?$";

        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!fieldValue.matches(pattern)) {
            errors.add(fieldName + " must be a numeric value with up to two decimal places");
        } else {
            double numericBMI = Double.parseDouble(fieldValue);



            if (numericBMI < minValue || numericBMI > maxValue) {
                errors.add(fieldName + " must be between " + minValue + " and " + maxValue);
            }
        }
    }

    public static void validateCholesterolTotal(String fieldValue,String fieldName ,List<String> errors) {

        double minValue = 2.0;
        double maxValue = 6.0;
        String pattern = "^\\d+(\\.\\d{1,2})?$";

        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!fieldValue.matches(pattern)) {
            errors.add(fieldName + " must be a numeric value with up to two decimal places");
        } else {
            double numericCholesterol = Double.parseDouble(fieldValue);



            if (numericCholesterol < minValue || numericCholesterol > maxValue) {
                errors.add(fieldName + " must be between " + minValue + " and " + maxValue + " g/L");
            }
        }
    }

    public static void validateLDL(String fieldValue, String fieldName, List<String> errors) {
        double minValue = 0.5;  // Example minimum LDL value
        double maxValue = 4.0;  // Example maximum LDL value
        String pattern = "^\\d+(\\.\\d{1,2})?$";

        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!fieldValue.matches(pattern)) {
            errors.add(fieldName + " must be a numeric value with up to two decimal places");
        } else {
            double numericLDL = Double.parseDouble(fieldValue);

            if (numericLDL < minValue || numericLDL > maxValue) {
                errors.add(fieldName + " must be between " + minValue + " and " + maxValue + " g/L");
            }
        }
    }

    public static void validateHDL(String fieldValue, String fieldName, List<String> errors) {
        double minValue = 0.5;  // Example minimum HDL value
        double maxValue = 3.0;  // Example maximum HDL value
        String pattern = "^\\d+(\\.\\d{1,2})?$";

        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!fieldValue.matches(pattern)) {
            errors.add(fieldName + " must be a numeric value with up to two decimal places");
        } else {
            double numericHDL = Double.parseDouble(fieldValue);

            if (numericHDL < minValue || numericHDL > maxValue) {
                errors.add(fieldName + " must be between " + minValue + " and " + maxValue + " g/L");
            }
        }
    }

    public static void validateGlucose(String fieldValue, String fieldName, List<String> errors) {
        double minValue = 70.0;  // Example minimum glucose value in mg/dL
        double maxValue = 140.0; // Example maximum glucose value in mg/dL
        String pattern = "^\\d+(\\.\\d{1,2})?$";

        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!fieldValue.matches(pattern)) {
            errors.add(fieldName + " must be a numeric value with up to two decimal places");
        } else {
            double numericGlucose = Double.parseDouble(fieldValue);

            if (numericGlucose < minValue || numericGlucose > maxValue) {
                errors.add(fieldName + " must be between " + minValue + " and " + maxValue + " mg/dL");
            }
        }
    }


    public static void validateHypertension(String fieldValue,String fieldName ,List<String> errors) {
        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!fieldValue.equals("Yes") && !fieldValue.equals("No")) {
            errors.add(fieldName + " must be either Yes or No");
        }
    }

    public static void validateHeartDisease(String fieldValue,String fieldName ,List<String> errors) {
        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!fieldValue.equals("Yes") && !fieldValue.equals("No")) {
            errors.add(fieldName + " must be either Yes or No");
        }
    }

    public static void validateDiabetes(String fieldValue,String fieldName ,List<String> errors) {
        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!fieldValue.equals("True") && !fieldValue.equals("False")) {
            errors.add(fieldName + " must be either True or False");
        }
    }




    public static void validateHistoryOfTIAs(String fieldValue,String fieldName ,List<String> errors) {
        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!fieldValue.equals("True") && !fieldValue.equals("False")) {
            errors.add(fieldName + " must be either True or False");
        }
    }

    public static void validateHeredityOrGenetics(String fieldValue,String fieldName ,List<String> errors) {
        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!fieldValue.equals("True") && !fieldValue.equals("False")) {
            errors.add(fieldName + " must be either True or False");
        }
    }

    public static void validateResidentialArea(String fieldValue,String fieldName ,List<String> errors) {
        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!fieldValue.equals("Urban") && !fieldValue.equals("Ruran")) {
            errors.add(fieldName + " must be either Urban or Rual");
        }
    }


    public static void validateSmokingStatus(String fieldValue, String fieldName, List<String> errors) {
        List<String> allowedValues = Arrays.asList("Fumeur", "Ex-fumeur", "Jamais fumé");

        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!allowedValues.contains(fieldValue)) {
            errors.add(fieldName + " must be one of the following values: " + String.join(", ", allowedValues));
        }
    }

    public static void validateAlcoholStatus(String fieldValue,String fieldName ,List<String> errors) {
        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!fieldValue.equals("True") && !fieldValue.equals("False")) {
            errors.add(fieldName + " must be either True or False");
        }
    }

    public static void validateWorkType(String fieldValue, String fieldName, List<String> errors) {
        List<String> allowedValues = Arrays.asList("Secteur privé", "Secteur public","Indeterminé","Sans travail","Au foyer","Activité indépendante");

        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!allowedValues.contains(fieldValue)) {
            errors.add(fieldName + " must be one of the following values: " + String.join(", ", allowedValues));
        }
    }

































}
