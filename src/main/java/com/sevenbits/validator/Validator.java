package com.sevenbits.validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validator {
    @Resource(name = "fieldsMap")
    private Map<String, String> fields;
    @Resource(name = "conditionsMap")
    private Map<String, Boolean> conditions;
    @Autowired
    private Pattern pattern;
    private Matcher matcher;

    private static final Logger logger = Logger.getLogger(Validator.class);

    public boolean isEmailValid(String mail) {
        matcher = pattern.matcher(mail);
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

    public Map<String, Boolean> validConditions(Map<String, String[]> parameters, String radio) {
        boolean isName = isNameValid(parameters.get("first")[0]);
        boolean isSurname = isSurnameValid(parameters.get("last")[0]);
        boolean isMail = isEmailValid(parameters.get("email")[0]);

        boolean isSuccess = (isName && isSurname && isMail && radio != null);

        conditions.put("success", isSuccess);
        conditions.put("first", isName);
        conditions.put("last", isSurname);
        conditions.put("email", isMail);

        return conditions;
    }

    public void startField(Map<String, String> fields) {
        fields.put("name", "");
        fields.put("surname", "");
        fields.put("mail", "");
        fields.put("comments", "");
        fields.put("radio", "photo");
        fields.put("check", "on");
    }

    public Map<String, String> validFields(Map<String, String[]> parameters, String radio, String checkbox) {
        fields.put("name", parameters.get("first")[0]);
        fields.put("surname", parameters.get("last")[0]);
        fields.put("mail", parameters.get("email")[0]);
        fields.put("comments", parameters.get("comments")[0]);

        if(radio != null && radio.equals("photo")) {
            fields.put("radio", "photo");
        }
        else if(radio != null && radio.equals("video")){
            fields.put("radio", "video");
        } else {
            fields.put("radio", "fail");
        }

        if(checkbox != null && checkbox.equals("on")) {
            fields.put("check", "on");
        }
        else {
            fields.put("check", "off");
        }

        return fields;
    }
}
