package com.IT22097156.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.IT22097156.controller.VerificationCon;
import com.IT22097156.model.VerificationModel;
import com.IT22097156.model.VerificationModelFact;
import com.IT22097156.model.VerificationResponseModel;

/**
 * Servlet implementation class verificationRequest
 */
@WebServlet("/getVerified")
public class VerificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private VerificationCon vCon;
	private PrintWriter out; 
	private VerificationResponseModel res;
	
	public VerificationServlet() {
		this.vCon = new VerificationCon();
		this.res = VerificationResponseModel.getInstance();
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
		
		switch(action) {
		case "/delete" :
			try {
				deleteApplication(request, response);
			} catch (ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/edit" :
			try {
				editApplication(request, response);
			} catch (ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/post" :
			try {
				storeApplication(request, response);
			} catch (ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
			break;	
		default:
			try {
				displayApplications(request, response);
			} catch (ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
		}                 
    }
	
	private void storeApplication(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		String fname = request.getParameter("full-name");
		String nic = request.getParameter("nic");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String userID = request.getParameter("userid");
		String status = "pending";
		
		boolean exists = vCon.checkIfExists(email, userID, nic);
		if (exists) {
			request.setAttribute("errorMessage", "Application with provided email, userID, or NIC already exists.");
			request.setAttribute("id", userID);
			displayApplications(request, response);
	        return;
	    }
		boolean rowUpdated = false;
		VerificationModel vApp = VerificationModelFact.createVerificationModel(fname, nic, mobile, email, address, userID, status);
		rowUpdated = vCon.createApplication(vApp);
		
		out = response.getWriter();
		if (rowUpdated) {
//	        response.sendRedirect(request.getContextPath() + "/index.jsp");
	    	out.println(res.getSuccessResponse() + userID);
	    } else {
	        // Handle update failure, maybe display an error message to the user
//	        response.getWriter().println("Failed to insert application." + userID);
	    	out.println(res.getFailResponse() + userID);
	    }
	}
	
	private void displayApplications(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException, SQLException{
//		String errorMsg = null;
		int check = 0;
		int userid;
		if (request.getAttribute("errorMessage") != null) {
//	        errorMsg = (String) request.getAttribute("errorMessage");
	        check = 1;
	    }
		if (request.getAttribute("id") != null) {
	        userid = Integer.parseInt((String) request.getAttribute("id"));
	    } else {
	    	userid = Integer.parseInt(request.getParameter("id"));
	    }
		
		List<VerificationModel> applicationList = new ArrayList<>();
		
		applicationList = vCon.readApplications(userid);
    	
        request.setAttribute("verificationApplications", applicationList);
        if(request.getAttribute("errorMessage") != null) {
        	request.setAttribute("errorMessage", check);
        }
            
        request.getRequestDispatcher("getVerified.jsp").forward(request, response);
	}
	
	private void editApplication(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		String fname = request.getParameter("full-name");
		String nic = request.getParameter("nic");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String userID = request.getParameter("userid");
		String status = "pending";
		
		boolean exists = vCon.checkIfExists(email, userID, nic);
		if (exists) {
			request.setAttribute("errorMessage", "Application with provided email, userID, or NIC already exists.");
			request.setAttribute("id", userID);
			displayApplications(request, response);
	        return;
	    }

		boolean rowUpdated = false;
	    VerificationModel vApp = VerificationModelFact.createVerificationModel(fname, nic, mobile, email, address, userID, status);
	    rowUpdated = vCon.updateApplication(vApp);

	    out = response.getWriter();
	    if (rowUpdated) {
//	        response.sendRedirect(request.getContextPath() + "/index.jsp");
	    	out.println(res.getSuccessResponse());

	    } else {
//	        response.getWriter().println("Failed to update application." + userID);
	    	out.println(res.getFailResponse());
	    	request.setAttribute("id", userID);
	    	request.getRequestDispatcher("/targetServlet").forward(request, response);
	    }
	}
	
	private void deleteApplication(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
    	int id = Integer.parseInt(request.getParameter("id"));
    	boolean rowDeleted = false; 
		
    	rowDeleted = vCon.deleteApplication(id);
    	out = response.getWriter();
    	
		if(rowDeleted == true) {
//		response.sendRedirect("index.jsp");
	    	out.println(res.getDeletesuccessResponse());
		} else {
			out.println(res.getDeletefailResponse());
		}
	}
}
