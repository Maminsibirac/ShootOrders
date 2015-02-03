package com.sevenbits.service.booking;

import com.sevenbits.domain.Contact;
import com.sevenbits.transactions.ContactServiceImpl;
import com.sevenbits.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class BookingService {
    private Map<String, Boolean> conditions;
    private Map<String, String> fields;

    @Autowired
    private ContactServiceImpl contactService;
    @Autowired
    private Contact contact;

    private Validator validator;



    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    public Map<String, Boolean> getConditions() {
        return conditions;
    }

    public Map<String, String> getFields() {
        return fields;
    }



    private boolean repeatRegistration(String email) {
        if(contactService.findByEmail(email) != null)
            return true;

        return false;
    }

    public void doWork(Map<String, String[]> parameters, String radio, String checkbox) {
        conditions = validator.validConditions(parameters, radio);
        fields = validator.validFields(parameters, radio, checkbox);

        if (conditions.get("success")) {
            if (!repeatRegistration(parameters.get("email")[0])) {
                contact.saveFieldsContatcs(fields);
                contactService.save(contact);

                conditions.put("repeatRegistered", false);
            } else {
                conditions.put("repeatRegistered", true);
            }
        } else {
            conditions.put("repeatRegistered", false);
        }

        if(conditions.get("success") && !conditions.get("repeatRegistered")) {
            validator.startField(fields);
        }
    }
}
