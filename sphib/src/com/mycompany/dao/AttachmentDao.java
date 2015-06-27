/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.domain.Attachments;

/**
 * 
 * @author americano
 */
@Repository
@Transactional
public class AttachmentDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Attachments attachment) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(attachment);
	}

	public Attachments load(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Attachments attachment = (Attachments) session.get(Attachments.class,
				id);
		return attachment;
	}

	public void remove(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Attachments attachment = (Attachments) session.get(Attachments.class,
				id);
		session.delete(attachment);
	}

	public List<String> findAllNames() {
		
		List<String> names = null;
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("select id , name from attachments");
		
		//SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("select * attachments");
		//query.addEntity(Attachments.class);
		
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		names = query.list();
		return names;
		
		
	}
	public List<Attachments> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Attachments> attachments = (List<Attachments>) session
				.createQuery("from Attachments").list();
		return attachments;
	}

}
