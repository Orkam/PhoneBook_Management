/**
@project PhoneBook-SpringBoot-Thymeleaf
@author Gustavo Guevara
@created 11 Oct 2023
*/
package com.app.phonebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.phonebook.Model.Contact;

@Repository
public interface PhoneBookRepository  extends JpaRepository<Contact, Long>{

}


