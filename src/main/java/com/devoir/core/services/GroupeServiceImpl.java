package com.devoir.core.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devoir.core.bo.Groupe;
import com.devoir.core.dao.IGroupeDao;

@Service
@Transactional
public class GroupeServiceImpl {
	
	@Autowired
    private IGroupeDao groupeDao;
    
    public void createGroupe(Groupe groupe) {
    	groupeDao.save(groupe);
    }
    
    public void deleteGroupe(String nomGroup) {
    	List<Groupe> grp = findGroupByNom(nomGroup);
    	if(grp!=null) {
    		groupeDao.delete((Groupe) findGroupByNom(nomGroup));
    	}    	
    	
    }
    public List<Groupe> findGroupByNom(String nomGroup){
    	List<Groupe> allGroups = groupeDao.findAll();
    	if(allGroups!=null) {
    		for(Groupe g : allGroups) {
    			if(g.getNomGroup()==nomGroup) {
    				return (List<Groupe>) g;
    			}
    			else {
    				return null;
    			}
    		}
    	}
		return null;
    	
    }
    
    public Groupe getGroupeById(Long id) {
    	return groupeDao.findById(id).get();
    }
}
