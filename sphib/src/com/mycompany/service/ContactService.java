package com.mycompany.service;

import java.util.List;

import com.mycompany.domain.Contact;

public interface ContactService {

	public void save(Contact contact);
	List<Contact> getAll();
	public Contact findbyId(int Id);
	public void delete(int contactId);
	public void update(Contact contact);
}
