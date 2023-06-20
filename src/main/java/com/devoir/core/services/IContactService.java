package com.devoir.core.services;
import com.devoir.core.bo.Contact;
import java.util.*;

public interface IContactService {

	public void addContact(Contact contact);

	void updateContact(Contact contact);

	public void deletePerson(Long id);
	
	List<Contact> findAllByOrderByName();
		
	void deleteContact(Contact contact);
	
	// Get contact by name
	List<Contact> getContactByNom(String nom);
	
	// Get contact by phone number1
	List<Contact> getContactByTelephone1();
	
	// Get contact by phone number2
	List<Contact> getContactByTelephone2();
	
}
