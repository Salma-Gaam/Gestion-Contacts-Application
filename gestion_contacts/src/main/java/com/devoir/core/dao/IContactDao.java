package com.devoir.core.dao;

import java.util.List;

// Review this imported lib cause we're not sure of the Sort object library (JPQL)
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devoir.core.bo.Contact;
import com.devoir.core.bo.Groupe;

public interface IContactDao extends JpaRepository<Contact, Long>  {

	@Query("FROM Contact WHERE nom = ?1")
	public List<Contact> getContactByNom(String nom);
	
	
	@Query("FROM Contact")
    public List<Contact> findAllByOrderByNom(Sort sort);
	
	@Query("FROM Contact WHERE numero_pro = ?1")
	public List<Contact> getContactByNumeroPro(String phone);
	
	@Query("FROM Contact WHERE numero_per = ?1")
	public List<Contact> getContactByNumeroPer(String phone);
	
//	@Query("FROM Groupe JOIN contacts_groups cg  WHERE cg.idContact = ?1")
//	public List<Groupe> getCtGroups(Long idCt);

}
