package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.Patientregister;
import com.pojo.*;
import com.pojo.Role;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BLManager bl = new BLManager();
	Patientregister reg = new Patientregister();
	Role r1 = new Role();

	public RegistrationServlet() {
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
		
		String gender=request.getParameter("gender");
		String phoneno = request.getParameter("phoneno");
        
		
		
		String role_id = request.getParameter("role_id");
		Integer role_id1=Integer.parseInt(role_id);
		r1 = bl.searchrolId(role_id1);

		reg.setRole(r1);

		reg.setFname(fname);
		reg.setLname(lname);
		//reg.setAge(age1);

		reg.setEmail(email);
		reg.setPassword(password);
        
        reg.setGender(gender);
        reg.setPhoneno(phoneno);

		bl.saveReg(reg);

		out.println("<script type=\"text/javascript\">");
		out.println("alert('Registration Done..!');");
		out.println("location='page-login.jsp';");
		out.println("</script>");

	}

}
