package com.devoir.core.web;

import java.util.ArrayList;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.devoir.core.bo.Contact;
import com.devoir.core.bo.Groupe;
import com.devoir.core.services.IContactService;
import com.devoir.core.services.IGroupeService;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.validation.Valid;

@Controller
public class ContactController {

	@Autowired
	private IContactService contactService; // Injection du service metier ici

	
	
    @Autowired
    private ServletContext appContext;

	//private Map<String, String> countryList = new HashMap<String, String>(); // Contient les pays à afficher dans la vue

	public ContactController() {
		

	}

	@PostConstruct
	public void init() {
	
	}

	@RequestMapping("/showForm")
	public String showForm(Model model) {

		model.addAttribute("contactModel", new Contact()); // Ajouter un objet Contact vide comme attribut du modèle
		model.addAttribute("contactList", contactService.findAllByOrderByNom());// Ajouter la liste des personnes comme attribut
																		// du modèle

		return "form"; // On retourne le nom de la vue
	}
	
	

	@RequestMapping(value = "/updateContactForm/{id}", method = RequestMethod.GET)
	public String updateContactForm(@PathVariable int id, Model model) {

		model.addAttribute("contactModel", contactService.getContactById(Long.valueOf(id)));
		

		return "updateForm";
	}

	// l'annotation @Valid est nécessaire pour faire la validation avec Hibernate
	// Validator
	// On obtient les données envoyées de la vue dans l'attribut du modèle
	// personModel
	// ces données sont copiées vers l'argument person
	// l'argument bindingResult permet de savoir si il y a des erreurs de validation
	@RequestMapping("/updateContact")
	public String updateContact(@Valid @ModelAttribute("contactModel") Contact contact, BindingResult bindingResult,
			Model model) {

		// Si il y a des erreurs de validation
		if (bindingResult.hasErrors()) {
			return "updateForm";
		}

		// Si il y a pas des erreurs
		contactService.updateContact(contact);
		model.addAttribute("contactList", contactService.findAllByOrderByNom());

		// rediriger vers un autre handler
		return "redirect:/manageContacts";
	}

	@RequestMapping("/addContact")
	public String process(@Valid @ModelAttribute("contactModel") Contact contact, BindingResult bindingResult,
			ModelMap model) {
		

		if (bindingResult.hasErrors()) {
			model.addAttribute("errorMsg", "Les données sont invalides.");
		} else {
			contactService.addContact(contact);
			model.addAttribute("infoMsg", "Personne ajouté avec succès");

		}
		model.addAttribute("personList", contactService.findAllByOrderByNom()); // Mettre la liste des personnes dans le modèle

		return "form";

	}

	@RequestMapping("/manageContacts")
	public String manageContacts(Model model) {

		model.addAttribute("contactList", contactService.findAllByOrderByNom()); // Mettre la liste des personnes dans le modèle

		return "listContacts";
	}
	

	@RequestMapping(value = "/deleteContact/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		contactService.deleteContact(Long.valueOf(id));

		// Behind the scenes, RedirectView will trigger a
		// HttpServletResponse.sendRedirect() – which will perform the actual redirect.
//		return new RedirectView(appContext.getContextPath() + "/manageContacts");
		return "manageContacts";
		// return "redirect:/manageContacts";
	}

	@PostMapping(value = "searchContact")
	public String searchContact(@RequestParam String nid, Model model) {

		List<Contact> ct = contactService.getContactByNom(nid);
		
		if (ct != null) {
			
			
			// Initialiser le modele
			model.addAttribute("contactList",ct);

		}

		return "listContacts";
	}
	
	@PostMapping(value = "searchContactPer")
	public String searchContactPhonePer(@RequestParam String phone1, Model model) {

		List<Contact> contacts = contactService.getContactByNumeroPer(phone1);
		
		if (contacts != null) {

			// Initialiser le modele
			model.addAttribute("contactList", contacts);
		}
		return "listContacts";
	}
	
	@PostMapping(value = "searchContactPro")
	public String searchContactPhonePro(@RequestParam String phone2, Model model) {

		List<Contact> contacts = contactService.getContactByNumeroPro(phone2);
		
		if (contacts != null) {

			// Initialiser le modele
			model.addAttribute("contactList",contacts);
			
		}
		return "listContacts";
	}
	
}