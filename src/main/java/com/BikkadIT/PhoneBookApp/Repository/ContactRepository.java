package com.BikkadIT.PhoneBookApp.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.PhoneBookApp.Entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Serializable> 
{
	
}
