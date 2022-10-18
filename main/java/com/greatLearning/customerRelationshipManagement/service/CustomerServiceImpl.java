package com.greatLearning.customerRelationshipManagement.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatLearning.customerRelationshipManagement.entity.Customer;


//@Repository
public class CustomerServiceImpl {
private SessionFactory sessionFactory;
	
	//create session
	private Session session ;

	@Autowired
	public CustomerServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		try {
			session=sessionFactory.getCurrentSession();
		}catch(HibernateException e) {
			session=sessionFactory.openSession();
		}
		
	}

	@Transactional
	public List<Customer> findAll() {
		Transaction tx=session.beginTransaction();
		
		//find all the records from db
		
		List<Customer>customers=session.createQuery("from customer").list();
		tx.commit();
		
		return customers;
	}

	@Transactional
	public Customer findById(int theId) {
		Customer customer= new Customer();
		
		Transaction tx= session.beginTransaction();
		
		//find record with id from db table
		customer=session.get(Customer.class,theId);
		 tx.commit();
		
		return customer;
	}

	@Transactional
	public void save(Customer theCustomer) {
		Transaction tx= session.beginTransaction();
		session.save(theCustomer);
		tx.commit();
		
	}

	@Transactional
	public void deleteById(int theId) {
		
		Transaction tx=session.beginTransaction();
	Customer customer=session.get(Customer.class, theId);
		session.delete(customer);
		tx.commit();
		
	}
}
