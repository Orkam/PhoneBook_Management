/**
@project PhoneBook-SpringBoot-Thymeleaf
@author Gustavo Guevara
@created 11 Oct 2023
*/
package com.app.phonebook.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name= "name")
	private String name;
	@Column(name="surname")
	private String surname;
	@Column(name="phone")
	private String phone;
	@Column(name="bithday")
	private LocalDate birthday;
	@Column(name="registerDate")
	private LocalDateTime registerDate;
	
			
	public Contact() {
		super();
	}
	public Contact(Integer id, String name, String surname, String phone, LocalDate birthday,
			LocalDateTime registerDate) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.birthday = birthday;
		this.registerDate = registerDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public LocalDateTime getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}
	
	

}
