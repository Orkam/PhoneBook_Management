/**
@project PhoneBook-SpringBoot-Thymeleaf
@author Gustavo Guevara
@created 11 Oct 2023
*/
package com.app.phonebook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.app.phonebook.services.PhoneBookServices;

@Controller
public class PhoneBookController {
	
	@Autowired
	PhoneBookServices phoneBookServices;

}
