package com.BikkadIT.PhoneBookApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.PhoneBookApp.Entity.Contact;
import com.BikkadIT.PhoneBookApp.Repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactServiceI 
{
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public boolean saveContact(Contact contact)
	{
		contact.setActiveSw('Y');
		Contact save=contactRepository.save(contact);
		if(save!=null && save.getContactID()!=null)
		{
			return true;
		}
	
		return false;
	}

	@Override
	public List<Contact> getAllContacts() 
	{
		List<Contact> findall=contactRepository.findAll();
		
		
		return findall;
	}

	@Override
	public Contact getContactById(Integer cid)
	{
		Optional<Contact> findById = contactRepository.findById(cid);
		if(findById.isPresent()) 
		{
			Contact contact=(Contact)findById.get();
			return contact;
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Integer cid)
	{
		boolean existById= contactRepository.existsById(cid);
		if(existById) {
			contactRepository.deleteById(cid);
			return true;
		}
		
		return false;
	}

}
