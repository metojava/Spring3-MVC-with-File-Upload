package com.mycompany.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.domain.Contact;

@Repository("contactDao")
@Transactional
public class ContactDaoImpl implements ContactDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Contact contact) {
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
		
	}

	@Override
	public List<Contact> getAll() {
		List<Contact> contacts = (List<Contact>)sessionFactory.getCurrentSession().createQuery("from Contact").list();
		return contacts;
	}

	@Override
	public Contact findbyId(int Id) {
		
		Contact contact = (Contact)sessionFactory.getCurrentSession().get(Contact.class, Id);
		return contact;
	}

	@Override
	public void delete(int contactId) {
		sessionFactory.getCurrentSession().delete(findbyId(contactId));
		
	}

	@Override
	public void update(Contact contact) {

		sessionFactory.getCurrentSession().merge(contact);
		
	}

	
	
}
