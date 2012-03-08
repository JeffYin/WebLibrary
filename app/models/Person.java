package models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Person extends BusinessModel {
	/* This column is the internal key column. */
	@Column(length=128,name="uid")
    public String personId;
    
	@Column(length=64)
	public String name; 
	
	@Column(length=64)
	public String email;
	
	@Column(length=128)
	public String phoneNumber; 
	
	public String address;
	
	
	public Person() {
		personId = UUID.randomUUID().toString();
	}


	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", address="
				+ address + "]";
	}
	
	
}
