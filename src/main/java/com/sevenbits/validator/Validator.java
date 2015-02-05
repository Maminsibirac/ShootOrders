package com.sevenbits.validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validator {
    @Resource(name = "conditionsMap")
    private Map<String, Boolean> conditions;
    @Autowired
    private Pattern pattern;

    public boolean isEmailValid(String mail) {
        Matcher matcher = pattern.matcher(mail);

        return matcher.matches();
    }

    public boolean isNameValid(String name) {
        if(name.isEmpty()) {
            return false;
        }

        return true;
    }

    public boolean isSurnameValid(String surname) {
        if(surname.isEmpty()) {
            return false;
        }

        return true;
    }

    public boolean isServiceValid(String checkRadio) {
        if(checkRadio == null) {
            return false;
        }

        return true;
    }

    public Map<String, Boolean> validConditions(Map<String, String[]> parameters, String radio) {
        boolean isName = isNameValid(parameters.get("first")[0]);
        boolean isSurname = isSurnameValid(parameters.get("last")[0]);
        boolean isMail = isEmailValid(parameters.get("email")[0]);
        boolean isService = isServiceValid(radio);

        boolean isSuccess = (isName && isSurname && isMail && radio != null);

        conditions.put("success", isSuccess);
        conditions.put("first", isName);
        conditions.put("last", isSurname);
        conditions.put("email", isMail);
        conditions.put("service", isService);

        return conditions;
    }
}
