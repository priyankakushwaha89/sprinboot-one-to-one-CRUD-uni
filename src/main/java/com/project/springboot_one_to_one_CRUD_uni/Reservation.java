package com.project.springboot_one_to_one_CRUD_uni;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="reservationlist")
public class Reservation 
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String username;
	int formno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getFormno() {
		return formno;
	}
	public void setFormno(int formno) {
		this.formno = formno;
	}
	
	
}

