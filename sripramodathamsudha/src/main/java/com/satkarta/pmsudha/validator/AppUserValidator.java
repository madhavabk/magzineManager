package com.satkarta.pmsudha.validator;

import com.satkarta.pmsudha.dao.AppUserDAO;
import com.satkarta.pmsudha.formbean.AppUserForm;
import com.satkarta.pmsudha.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
 
@Component
public class AppUserValidator implements Validator {
 
    // common-validator library.
    
 
    @Autowired
    private AppUserDAO appUserDAO;
 
    // The classes are supported by this validator.
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == AppUserForm.class;
    }
 
    @Override
    public void validate(Object target, Errors errors) {
        AppUserForm appUserForm = (AppUserForm) target;
 
        // Check the fields of AppUserForm.
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.appUserForm.firstName");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.appUserForm.lastName");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.appUserForm.email");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.appUserForm.password");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.appUserForm.confirmPassword");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "NotEmpty.appUserForm.gender");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countryCode", "NotEmpty.appUserForm.countryCode");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stateCode", "NotEmpty.appUserForm.stateCode");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cityCode", "NotEmpty.appUserForm.cityCode");
        ValidationUtils.rejectIfEmpty(errors, "mobileNo", "NotEmpty.appUserForm.mobileNo");
        
        //Adding minimum validations to ensure that user does not exist already.
       
        if (!errors.hasFieldErrors("firstName")) {
            AppUser dbUser = appUserDAO.findAppUserByUserName(appUserForm.getFirstName(), appUserForm.getLastName(), appUserForm.getMobileNo());
            if (dbUser != null) {
                // Username is not available.
                errors.rejectValue("firstName", "Duplicate.appUserForm.firstName");
            }
        }
    }
 
}