package com.oop.service;

import java.util.ArrayList;



import java.util.logging.Logger;

import com.oop.model.*;

public interface IStaffService {
	public static final Logger log = Logger.getLogger(IStaffService.class.getName());


	public void AddStaff(Staff s1);

	
	public Staff getStaffByID(String StaffID);
	
	
	public ArrayList<Staff> getStaffs();
	
	
	public Staff UpdateStaff(String StaffID, Staff s1);

	
	public void RemoveStaff(String StaffID);

}
