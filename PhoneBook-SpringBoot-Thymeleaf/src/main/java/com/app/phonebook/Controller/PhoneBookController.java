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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.phonebook.Model.Contact;
import com.app.phonebook.services.PhoneBookServices;

import jakarta.validation.Valid;

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
	public String saveContact(@ModelAttribute("objContact") @Validated Contact newContact, BindingResult bindingResult,
			RedirectAttributes redirect, Model model) {

		if (bindingResult.hasErrors()) {

			model.addAttribute("objContact", newContact);
			return "newContact";
		}

		newContact.setRegisterDate(LocalDateTime.now());

		phoneBookServices.saveContact(newContact);

		redirect.addFlashAttribute("msgSuccess", "Contact added successfully");

		return "redirect:/";
	}

	@GetMapping("/deleteContact/{id}")
	public String deleteContact(@PathVariable Long id, RedirectAttributes redirect) {

		Optional<Contact> contactFound = phoneBookServices.findContactById(id);

		phoneBookServices.deleteContact(contactFound.get());

		redirect.addFlashAttribute("msgSuccess", "Contact deleted successfully");

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

	@PostMapping("/updateContact/{id}")
	public String updateContact(@ModelAttribute("contact") @Validated Contact contact, BindingResult bindingResult,
			Model model, RedirectAttributes redirect, @PathVariable Long id) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("contact", contact);

			return "editContact";
		}
		Optional<Contact> contactFound = phoneBookServices.findContactById(id);

		contactFound.get().setRegisterDate(LocalDateTime.now());
		contactFound.get().setBirthday(contact.getBirthday());
		contactFound.get().setName(contact.getName());
		contactFound.get().setSurname(contact.getSurname());
		contactFound.get().setPhone(contact.getPhone());

		phoneBookServices.saveContact(contactFound.get());

		redirect.addFlashAttribute("msgSuccess", "Contact updated successfully");

		return "redirect:/";
	}

}
