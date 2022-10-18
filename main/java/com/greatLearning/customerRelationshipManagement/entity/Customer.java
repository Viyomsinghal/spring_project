package com.greatLearning.customerRelationshipManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

	public Customer() {
		super();
	}

	public Customer( String firstName, String lastName, String eMail) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
	}

	@Column(name = "first_Name")
	private String firstName;
	@Column(name = "last_Name")
	private String lastName;
	@Column(name = "E-Mail")
	private String eMail;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", eMail=" + eMail + "]";
	}
}
