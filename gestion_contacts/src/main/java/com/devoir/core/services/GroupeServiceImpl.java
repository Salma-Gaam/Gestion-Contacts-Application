package com.devoir.core.services;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devoir.core.bo.Contact;
import com.devoir.core.bo.Groupe;
import com.devoir.core.dao.IGroupeDao;

@Service
public class GroupeServiceImpl implements IGroupeService {
	
	@Autowired
    private IGroupeDao groupeDao;
    
	@PersistenceContext
    private EntityManager entityManager;
	
    public void createGroupe(Groupe groupe) {
    	groupeDao.save(groupe);
    }
    
    public void deleteGroupe(String nomGroup) {
    	List<Groupe> grp = getGroupByNom(nomGroup);
    	if(grp!=null) {
    		groupeDao.delete((Groupe) getGroupByNom(nomGroup));
    	}    	
    	
    }

    
    public List<Groupe> getGroupByNom(String nom){
    	return groupeDao.getGroupByNom(nom);
    }
    
    public Groupe getGroupeById(Long id) {
    	return groupeDao.findById(id).get();
    }
    
    public List<Groupe> getAllGrp(){
    	List<Groupe> groupes = groupeDao.findAll();
    	return groupes;
    }


	public void deleteGroupe(Long id) {
		Groupe groupe = groupeDao.findById(id).get();
		groupeDao.delete(groupe);
	}
	
	public Groupe addContact(Groupe groupe, List<Contact> contacts) {
		
		
		List<Contact> oldContacts = groupe.getContacts();				
	
//		for(Contact it: contacts) {
//			//TEST 
//			System.out.println("Nom: "+it.getNom());
//			String fullName = (it.getNom()+" "+it.getPrenom()).toLowerCase();
//			//Test
//			System.out.println("fullName: "+fullName);
//			
//			String mbrs = groupe.getMembers().toLowerCase();
//			if(mbrs.contains(fullName)) {
//				contacts.remove(contacts.indexOf(it));
//			}
//		}
		contacts.addAll(oldContacts);
		
		groupe.setContacts(contacts);
		
		// we add the group's contacts to the members attribute so that we can display it
		List<String> ct = new ArrayList<String>();
		for(Contact it: contacts) {
			String nom = it.getNom();
			String prenom = it.getPrenom();
			String nomCt = nom+" "+prenom;
			ct.add(nomCt);
		}
		
		if(ct.size()>0) {
		groupe.setMembers(String.join(", ", ct));
		
		}
		return groupe;
	}
	
	public Groupe updateGrp(Groupe groupe) {
		return groupeDao.save(groupe);
	}

}

