package com.devoir.core.services;

import java.util.List;

import com.devoir.core.bo.Groupe;


public interface IGroupeService {
	
	public void createGroupe(Groupe groupe);
    public void deleteGroupe(Long id);
    public List<Groupe> findGroupByNom(String nomGroup);
    public Groupe getGroupeById(Long id);

}