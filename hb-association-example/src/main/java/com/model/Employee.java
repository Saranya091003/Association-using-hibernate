
package com.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="EMP121")
public class Employee {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@PrimaryKeyJoinColumn(name="ID")
int empId;
String name,email;
@OneToOne(targetEntity =Address.class,cascade=CascadeType.ALL)
Address address;
public Employee(int empId, String name, String email, Address address) {
	super();
	this.empId = empId;
	this.name = name;
	this.email = email;
	this.address = address;
}
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public Employee() {
	super();
}

}