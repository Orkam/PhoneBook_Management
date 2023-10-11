/**
@project PhoneBook-SpringBoot-Thymeleaf
@author Gustavo Guevara
@created 11 Oct 2023
*/
package com.app.phonebook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.phonebook.repository.PhoneBookRepository;

@Service
public class PhoneBookServicesImpl implements PhoneBookServices{
	
	@Autowired
	PhoneBookRepository repository;

}
