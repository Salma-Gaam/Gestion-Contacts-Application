package com.devoir.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devoir.core.bo.Groupe;

public interface IGroupeDao extends JpaRepository<Groupe, Long> {

	
	
}
