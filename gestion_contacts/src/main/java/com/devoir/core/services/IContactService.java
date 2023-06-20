package com.devoir.core.services;
import com.devoir.core.bo.Contact;
import com.devoir.core.bo.Groupe;

import java.util.*;

import org.springframework.data.domain.Sort;

public interface IContactService {

	public void addContact(Contact contact);

	void updateContact(Contact contact);
	
	List<Contact> findAllByOrderByNom();
		
	void deleteContact(Long id);
	
	// Get contact by name
	List<Contact> getContactByNom(String nom);
	
	// Get contact by phone  number
	public List<Contact> getContactByNumeroPro(String phone);
	
	// Get contact by phone number2
	public List<Contact> getContactByNumeroPer(String phone);
	
	public Contact getContactById(Long id);
	
//	public List<Groupe> getCtGroups(Contact contact);

}
