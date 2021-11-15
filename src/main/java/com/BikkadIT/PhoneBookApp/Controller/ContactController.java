package com.BikkadIT.PhoneBookApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.BikkadIT.PhoneBookApp.Entity.Contact;
import com.BikkadIT.PhoneBookApp.Service.ContactServiceI;


@Controller
public class ContactController
{
	@Autowired
	private ContactServiceI contactServiceI;
	
	@GetMapping("/contact")
	private String loadContactForm(Model model) {
		
		Contact contacto=new Contact();
		model.addAttribute("contact",contacto);
		
		return "contactInfo";	
	}
	
	@PostMapping("/saveContact")
	public String saveContact(@ModelAttribute Contact contact,Model model)
	{
		boolean issave= contactServiceI.saveContact(contact);
		if(issave)
		{
			model.addAttribute("success","Contact save successfully");
		}
		else
		{
			model.addAttribute("error","Failed to save Contact");
		}
		return "contactInfo";
		
	}
	@GetMapping("/ViewContact")
	public String viewAllContact(Model model) 
	{
	  	List<Contact> allcontact= contactServiceI.getAllContacts();
		model.addAttribute("contacts",allcontact);
		return "contacts";
		
	}
	
	
	
	
}
