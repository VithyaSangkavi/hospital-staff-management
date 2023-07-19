package com.oop.model;

public class Staff {
	
	//declaring variables
	private String StaffID ;
	private String FirstName ;
	private String LastName ;
	private String Address ;
	private String Age ;
	private String Email ;
	private String Role ;
	private double Salary ;
	public String getStaffID() {
		return StaffID;
	}
	
	//getters and setters
	
	public void setStaffID(String staffID2) {
		StaffID = staffID2;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	
	public String toString() {
		
		return "Staff ID = " + StaffID + "\n" + "First Name = " + FirstName + "\n"+ 
				"Last Name = " + LastName + "\n"  + "Address = " + Address + "\n" + 
				"Age = " + Age + "\n" + "Email = " + Email + "\n" + 
				"Role = " + Role + "\n" + "Salary = " + Salary ;
	}
}
