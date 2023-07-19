package com.oop.service;

import java.io.IOException;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.oop.connection.CommonConstants;
import com.oop.connection.CommonUtil;
import com.oop.connection.DBConnectionUtil;
import com.oop.connection.QueryUtil;
import com.oop.model.Staff;



public class StaffService implements IStaffService{
	
	public static final Logger log = Logger.getLogger(StaffService.class.getName());

	private static Connection connection;

	private static Statement statement;

	/*
	static{
		//create table or drop if exist
		createStaffTable();
	}
	*/
	

	private PreparedStatement preparedStatement;

	
	public static void createStaffTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
	}

	
	@Override
	public void AddStaff(Staff s1) {

		String StaffID = CommonUtil.generateIDs(getStaffIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_STAFFS));
			connection.setAutoCommit(false);
			
			//Generate staff IDs
			s1.setStaffID(StaffID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, s1.getStaffID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, s1.getFirstName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, s1.getLastName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, s1.getAddress());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, s1.getAge());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, s1.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, s1.getRole());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_EIGHT, s1.getSalary());
			
			// Add staff
			preparedStatement.execute();
			
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		} finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	
	@Override
	public Staff getStaffByID(String StaffID) {

		return actionOnStaff(StaffID).get(0);
	}
	
	
	@Override
	public ArrayList<Staff> getStaffs() {
		
		return actionOnStaff(null);
	}

	
	@Override
	public void RemoveStaff(String StaffID) {

	
		if (StaffID != null && !StaffID.isEmpty()) {
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_STAFF));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, StaffID);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	
	private ArrayList<Staff> actionOnStaff(String StaffID) {

		ArrayList<Staff> StaffList = new ArrayList<Staff>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			if (StaffID != null && !StaffID.isEmpty()) {
				
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_STAFF));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, StaffID);
			}
			
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_STAFFS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Staff s1 = new Staff();
				
				s1.setStaffID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				s1.setFirstName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				s1.setLastName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				s1.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				s1.setAge(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				s1.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				s1.setRole(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				s1.setSalary(resultSet.getDouble(CommonConstants.COLUMN_INDEX_EIGHT));
				StaffList.add(s1);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return StaffList;
	}

	
	@Override
	public Staff UpdateStaff(String StaffID, Staff s1) {

		if (StaffID != null && !StaffID.isEmpty()) {
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_STAFF));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, s1.getFirstName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, s1.getLastName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, s1.getAddress());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, s1.getAge());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, s1.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, s1.getRole());
				preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_SEVEN, s1.getSalary());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, s1.getStaffID());
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated employee
		return getStaffByID(StaffID);
	}
	
	
	private ArrayList<String> getStaffIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_STAFF_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}

}
