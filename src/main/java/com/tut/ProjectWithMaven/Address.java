package com.tut.ProjectWithMaven;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
@Table(name="student_address")
public class Address {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int adressId;
	
	@Column(length = 50, name = "STREET")
	private String street;
	
	@Column(length = 100)
	private String city;
	
	@Transient
	private double x;
	
	@Column(name = "is_open")
	private boolean isOpen;
	
//	@Lob
//	private byte[] img;
	
	@Column(name = "added_date")
	@Temporal(TemporalType.DATE)
	private Date addedDate;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int adressId, String street, String city, double x, boolean isOpen, byte[] img, Date addedDate) {
		super();
		this.adressId = adressId;
		this.street = street;
		this.city = city;
		this.x = x;
		this.isOpen = isOpen;
		//this.img = img;
		this.addedDate = addedDate;
	}
	public int getAdressId() {
		return adressId;
	}
	public void setAdressId(int adressId) {
		this.adressId = adressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
//	public byte[] getImg() {
//		return img;
//	}
//	public void setImg(byte[] img) {
//		this.img = img;
//	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	
	
	
}
