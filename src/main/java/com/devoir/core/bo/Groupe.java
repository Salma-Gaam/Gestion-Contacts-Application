package com.devoir.core.bo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.ArrayList;


@Entity
public class Groupe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idGroup")
	private Long idGroup;
	
	private String nomGroup;
	@ManyToMany(mappedBy = "groupes")
	private List<Contact> contacts = new ArrayList<Contact>();
	
	public Groupe() {
		
	}
	public Groupe(Long idGroup, String nomGroup, List<Contact> contacts) {
		this.idGroup = idGroup;
		this.nomGroup = nomGroup;
		this.contacts = contacts;
	}
	

	

	public String getNomGroup() {
		return nomGroup;
	}

	public void setNomGroup(String nomGroup) {
		this.nomGroup = nomGroup;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public Long getIdGroup() {
		return idGroup;
	}
	public void setIdGroup(Long idGroup) {
		this.idGroup = idGroup;
	}

	
	

}