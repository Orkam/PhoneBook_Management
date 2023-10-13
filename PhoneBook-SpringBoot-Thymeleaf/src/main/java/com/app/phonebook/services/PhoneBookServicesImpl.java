/**
@project PhoneBook-SpringBoot-Thymeleaf
@author Gustavo Guevara
@created 11 Oct 2023
*/
package com.app.phonebook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.phonebook.Model.Contact;
import com.app.phonebook.repository.PhoneBookRepository;

@Service
public class PhoneBookServicesImpl implements PhoneBookServices {

	@Autowired
	PhoneBookRepository repository;

	@Override
	public List<Contact> getAllContacts() {
		return repository.findAll();
	}

	@Override
	public void saveContact(Contact contact) {

		repository.save(contact);

	}

	@Override
	public void deleteContact(Contact contact) {

		repository.delete(contact);

	}

	@Override
	public Optional<Contact> findContactById(Long id) {

		Optional<Contact> contactFound = repository.findById(id);

		return contactFound;
	}

	

}
