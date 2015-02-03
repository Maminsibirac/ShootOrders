package com.sevenbits.transactions;

import com.sevenbits.domain.Contact;
import com.sevenbits.persistence.ContactMapper;
import com.sevenbits.service.contact.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    ContactMapper contactMapper;

    public void save(Contact contact) {
        contactMapper.save(contact);
    }

    public Contact findByEmail(String email) {
        return contactMapper.findByEmail(email);
    }
}
