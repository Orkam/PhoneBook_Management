/**
@project PhoneBook-SpringBoot-Thymeleaf
@author Gustavo Guevara
@created 11 Oct 2023
*/
package com.app.phonebook.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.app.phonebook.Model.Contact;
import com.app.phonebook.services.PhoneBookServices;

@Controller
public class PhoneBookController {

	@Autowired
	PhoneBookServices phoneBookServices;

	@GetMapping({ "homePage", "/" })
	public ModelAndView viewHomePage() {
		List<Contact> allContactsList = phoneBookServices.getAllContacts();
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("listContacts", allContactsList);
		modelAndView.setViewName("homePage");

		return modelAndView;
	}

	@GetMapping("newContact")
	public String newContact(Model model) {

		Contact objContact = new Contact();

		model.addAttribute("objContact", objContact);

		return "newContact";
	}

	@PostMapping("/saveContact")
	public String saveContact(@ModelAttribute("objContact") Contact newContact) {

		newContact.setRegisterDate(LocalDateTime.now());

		phoneBookServices.saveContact(newContact);

		return "redirect:/";
	}

	@GetMapping("/deleteContact/{id}")
	public String deleteContact(@PathVariable Long id) {

		Optional<Contact> contactFound = phoneBookServices.findContactById(id);

		phoneBookServices.deleteContact(contactFound.get());

		return "redirect:/";

	}

	@GetMapping("/editContact/{id}")
	public ModelAndView editContact(@PathVariable Long id) {

		Optional<Contact> contactFound = phoneBookServices.findContactById(id);

		ModelAndView modelAndView = new ModelAndView();	

		modelAndView.addObject("contact", contactFound.get());
		modelAndView.setViewName("editContact");

		return modelAndView;
	}

}
