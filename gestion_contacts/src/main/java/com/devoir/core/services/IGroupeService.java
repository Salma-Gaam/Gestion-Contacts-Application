package com.devoir.core.services;

import java.util.List;

import com.devoir.core.bo.Contact;
import com.devoir.core.bo.Groupe;


public interface IGroupeService {
	
	public void createGroupe(Groupe groupe);
    public void deleteGroupe(Long id);
    public Groupe getGroupeById(Long id);
    public List<Groupe> getAllGrp();
    public List<Groupe> getGroupByNom(String nom);
    public Groupe addContact(Groupe groupe, List<Contact> contacts);
//    public List<Contact> getGpContacts(Groupe groupe);
    public Groupe updateGrp(Groupe groupe);
}