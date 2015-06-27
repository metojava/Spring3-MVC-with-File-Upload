package com.mycompany.dao;

import java.util.List;

import com.mycompany.domain.Contact;

public interface ContactDao {

	public void save(Contact contact);
	List<Contact> getAll();
	public Contact findbyId(int Id);
	public void delete(int contactId);
	public void update(Contact contact);
}
