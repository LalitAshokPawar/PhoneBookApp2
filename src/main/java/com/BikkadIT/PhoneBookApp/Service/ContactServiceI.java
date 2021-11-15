package com.BikkadIT.PhoneBookApp.Service;

import java.util.List;

import com.BikkadIT.PhoneBookApp.Entity.Contact;

public interface ContactServiceI 
{
	boolean saveContact(Contact contact);
	List<Contact> getAllContacts();
	Contact getContactById(Integer cid);
	boolean deleteContactById(Integer cid);

}
