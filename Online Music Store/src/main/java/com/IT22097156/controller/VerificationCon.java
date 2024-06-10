package com.IT22097156.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import com.IT22097156.db.DatabaseServlet;
import com.IT22097156.model.VerificationModel;
import com.IT22097156.model.VerificationModelFact;

public class VerificationCon {
	private DatabaseServlet db;
	
	public VerificationCon() {
		this.db = new DatabaseServlet();
	}
    
    public boolean createApplication(VerificationModel vApp) {
    	boolean rowUpdated = false;
		try (Connection connection = db.getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO VerifyApplications(Applicant_FullName, Applicant_NIC, Applicant_Mobile, Applicant_Email, Applicant_Address, user_ID, status) values(?, ?, ?, ?, ?, ?, ?)")) {
		    statement.setString(1, vApp.getFullname());
		    statement.setString(2, vApp.getNic());
		    statement.setString(3, vApp.getMobile());
		    statement.setString(4, vApp.getEmail());
		    statement.setString(5, vApp.getAddress());
		    statement.setString(6, vApp.getUserID());
		    statement.setString(7, vApp.getStatus());

		    rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowUpdated;
    	
    }
    
    public boolean checkIfExists(String email, String userID, String nic) throws SQLException {
	    try (Connection connection = db.getConnection();
	         PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM VerifyApplications WHERE (Applicant_Email = ? OR user_ID = ? OR Applicant_NIC = ?) AND user_ID <> ?")) {
	        statement.setString(1, email);
	        statement.setString(2, userID);
	        statement.setString(3, nic);
	        statement.setString(4, userID);

	        try (ResultSet resultSet = statement.executeQuery()) {
	            if (resultSet.next()) {
	                int count = resultSet.getInt(1);
	                return count > 0;
	            }
	        }
	    } catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return false;
	}
    
    public List<VerificationModel> readApplications(int userid) {
        List<VerificationModel> applicationList = new ArrayList<>();

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM VerifyApplications WHERE user_ID = ?")) {
            preparedStatement.setInt(1, userid);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Application_ID");
                String fullName = rs.getString("Applicant_FullName");
                String nic = rs.getString("Applicant_NIC");
                String mobile = rs.getString("Applicant_Mobile");
                String email = rs.getString("Applicant_Email");
                String address = rs.getString("Applicant_Address");
                String userID = rs.getString("user_ID");
                String status = rs.getString("status");

                VerificationModel application = VerificationModelFact.createVerificationModel(id, fullName, nic, mobile, email, address, userID, status);
                applicationList.add(application);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        if (applicationList.isEmpty()) {
            int id = 0;
            String fullName = "";
            String nic = "";
            String mobile = "";
            String email = "";
            String address = "";
            String status = "";
            VerificationModel application = VerificationModelFact.createVerificationModel(id, fullName, nic, mobile, email, address, String.valueOf(userid), status);
            applicationList.add(application);
        }

        return applicationList;
    }

    
    public boolean updateApplication(VerificationModel vApp) {
    	boolean rowUpdated = false;
    	try (Connection connection = db.getConnection();
   	         PreparedStatement statement = connection.prepareStatement("UPDATE VerifyApplications SET Applicant_FullName = ?, Applicant_NIC = ?, Applicant_Mobile = ?, Applicant_Email = ?, Applicant_Address = ?, status = ? WHERE user_ID = ?")) {
   	        statement.setString(1, vApp.getFullname());
   	        statement.setString(2, vApp.getNic());
   	        statement.setString(3, vApp.getMobile());
   	        statement.setString(4, vApp.getEmail());
   	        statement.setString(5, vApp.getAddress());
   	        statement.setString(6, vApp.getStatus());
   	        statement.setString(7, vApp.getUserID());

   	        rowUpdated = statement.executeUpdate() > 0;
   	    } catch (SQLException e) {
   	        e.printStackTrace();
   	    } catch (ServletException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	return rowUpdated;
    }
    
    public boolean deleteApplication(int id) {
    	boolean rowDeleted = false;
    	try (Connection connection = db.getConnection();
    			PreparedStatement statement = connection.prepareStatement("delete from VerifyApplications where Application_ID = ?");) {
    			statement.setInt(1, id);
    			rowDeleted = statement.executeUpdate() > 0;		
    		} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		return rowDeleted;	
    }
}
