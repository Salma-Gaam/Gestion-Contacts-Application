package com.devoir.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devoir.core.bo.Contact;
import com.devoir.core.bo.Groupe;

public interface IGroupeDao extends JpaRepository<Groupe, Long> {

	@Query("FROM Groupe WHERE nomGroup = ?1")
	public List<Groupe> getGroupByNom(String nom);

	
//	@Query("FROM Contact c JOIN contacts_groups cg  WHERE cg.idGroup = ?1")
//	public List<Contact> getGpContacts(Long idGrp);

}
