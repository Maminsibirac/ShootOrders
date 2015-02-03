package com.sevenbits.persistence;

import com.sevenbits.domain.Contact;
import org.apache.ibatis.annotations.*;

public interface ContactMapper {
    final String SAVE_CONTACT = "INSERT INTO contacts(name, surname, email) VALUES(#{name}, #{surname}, #{email})";
    final String FIND_CONTACT_BY_EMAIL = "SELECT name, surname, email FROM contacts WHERE email=#{email}";

    @Insert(SAVE_CONTACT)
    public void save(Contact contact);

    @Select(FIND_CONTACT_BY_EMAIL)
    @Results({
            @Result(column = "name", property = "name"),
            @Result(column = "surname", property = "surname"),
            @Result(column = "email", property = "email")
    })
    public Contact findByEmail(String email);
}
