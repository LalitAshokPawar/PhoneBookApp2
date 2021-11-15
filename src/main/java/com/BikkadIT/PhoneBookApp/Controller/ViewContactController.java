package com.BikkadIT.PhoneBookApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BikkadIT.PhoneBookApp.Entity.Contact;
import com.BikkadIT.PhoneBookApp.Service.ContactServiceI;

@Controller
public class ViewContactController
{
	@Autowired
	private ContactServiceI contactServiceI;
	
	@GetMapping("/edit")
	public String editContact(@RequestParam("cid") Integer contactID, Model model)
	{
		Contact contact =contactServiceI.getContactById(contactID);
		
		model.addAttribute("contact", contact);
		return "contactInfo";
		
	}

	@GetMapping("/delete")
	public String deleteById(@RequestParam("cid") Integer contactID, Model model) 
	{
		boolean isDelete=contactServiceI.deleteContactById(contactID);
		
		if(isDelete)
		{
			model.addAttribute("deleteSuccess","Contact Deleted Successfully ");
		}
		return "redirect:/ViewContact";
		
		
	}
}
