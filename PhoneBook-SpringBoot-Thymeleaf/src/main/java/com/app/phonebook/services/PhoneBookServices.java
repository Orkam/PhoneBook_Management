/**
@project PhoneBook-SpringBoot-Thymeleaf
@author Gustavo Guevara
@created 11 Oct 2023
*/
package com.app.phonebook.services;

import java.util.List;
import java.util.Optional;

import com.app.phonebook.Model.Contact;

public interface PhoneBookServices {

	/**
	 * 
	 * @created 11 Oct 2023
	 * @description Method to retrieve all Contacts saved in the database.
	 *
	 */

	List<Contact> getAllContacts();

	/**
	 * 
	 * @created 11 Oct 2023
	 * @description Method to save a new conctact in the phone book
	 *
	 */
	void saveContact(Contact contact);

	/**
	 * 
	 * @created 12 Oct 2023
	 * @description Delete contact
	 *
	 */
	void deleteContact(Contact contact);

	/**
	 * 
	 * @created 12 Oct 2023
	 * @description return a Contact found by id		
	 *
	 */
	Optional<Contact>  findContactById(Long id);

}
