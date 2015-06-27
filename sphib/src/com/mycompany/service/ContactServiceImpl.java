package com.mycompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mycompany.dao.ContactDao;
import com.mycompany.domain.Contact;

@Component
@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDao contactDao;

	@Override
	public void save(Contact contact) {
		contactDao.save(contact);

	}

	@Override
	public List<Contact> getAll() {

		List<Contact> contacts = contactDao.getAll();

		return contacts;
	}

	@Override
	public Contact findbyId(int Id) {
		Contact contact = contactDao.findbyId(Id);
		return contact;
	}

	@Override
	public void delete(int contactId) {

		contactDao.delete(contactId);

	}

	@Override
	public void update(Contact contact) {

		contactDao.update(contact);

	}

}
