package com.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Adress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   
   private String city;
   
   private String dist;
   
   private int pinCode;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getDist() {
	return dist;
}

public void setDist(String dist) {
	this.dist = dist;
}


public int getPinCode() {
	return pinCode;
}

public void setPinCode(int pinCode) {
	this.pinCode = pinCode;
}

@Override
public String toString() {
	return "Adress [id=" + id + ", city=" + city + ", dist=" + dist + ", pinCode=" + pinCode + "]";
}

}
