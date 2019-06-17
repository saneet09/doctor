package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.*;

@WebServlet("/RegistrationServlet")
public class AdminregisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BLManager bl = new BLManager();
	Adminregister adm = new Adminregister();
	Role r1 = new Role();

	public AdminregisterServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		PrintWriter out = response.getWriter();

		String fname = request.getParameter("fname");
		String lname=request.getParameter("lname");
		
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String degree = request.getParameter("degree");
		
		String phoneno = request.getParameter("phoneno");
        Integer phoneno1 = Integer.parseInt(phoneno);
		
		
		String role_id = request.getParameter("role_id");
		Integer role_id1 = Integer.parseInt(role_id);

		r1 = bl.searchrolId(role_id1);

		adm.setRole(r1);

		adm.setFname(fname);
		adm.setLname(lname);
		//reg.setAge(age1);
	
		adm.setEmail(email);
		adm.setPassword(password);
        
		
		adm.setPhoneno(phoneno1);

		bl.saveAdm(adm);

		out.println("<script type=\"text/javascript\">");
		out.println("alert('Registration Done..!');");
		out.println("location='page-login.jsp';");
		out.println("</script>");

	}


}
