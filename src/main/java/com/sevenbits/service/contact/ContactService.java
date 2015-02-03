package com.sevenbits.service.contact;

import com.sevenbits.domain.Contact;

public interface ContactService {
    public void save(Contact contact);
    public Contact findByEmail(String contact);
}
