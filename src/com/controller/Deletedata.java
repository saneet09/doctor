package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Doctorregister;

import com.pojo.Patientregister;


/**
 * Servlet implementation class DeleteDailyProductList
 */
@WebServlet("/DeleteList")
public class Deletedata extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BLManager bl=new BLManager();
	Patientregister reg=new Patientregister();

	
	public Deletedata() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id=request.getParameter("id");
	int id1=Integer.parseInt(id);
	reg=bl.searchAdminStationDataById(id1);
	bl. deleteStationFromAdminPanel(reg);
	response.sendRedirect("admin_patient_table.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		
	}

}
