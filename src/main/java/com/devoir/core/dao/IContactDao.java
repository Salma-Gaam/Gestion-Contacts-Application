package com.devoir.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devoir.core.bo.Contact;

public interface IContactDao extends JpaRepository<Contact, Long>  {

	
}
