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
public class DoctorregisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BLManager bl = new BLManager();
	Doctorregister doc = new Doctorregister();
	Role r1 = new Role();

	public DoctorregisterServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		PrintWriter out = response.getWriter();

		String fname = request.getParameter("fname");
		String lname=request.getParameter("lname");
		String specilization = request.getParameter("specilization");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String degree = request.getParameter("degree");
		String gender=request.getParameter("gender");
		String address = request.getParameter("address");
		String phoneno = request.getParameter("phoneno");
     
		
		
		String role_id = request.getParameter("role_id");
		Integer role_id1=Integer.parseInt(role_id);
		r1 = bl.searchrolId(role_id1);

		doc.setRole(r1);

		doc.setFname(fname);
		doc.setLname(lname);
		//reg.setAge(age1);
		//doc.setspecilization(specilization);
		doc.setEmail(email);
		doc.setPassword(password);
        
        doc.setGender(gender);
        doc.setPhoneno(phoneno);

		bl.savedoc(doc);

		out.println("<script type=\"text/javascript\">");
		out.println("alert('Registration Done..!');");
		out.println("location='page-login.jsp';");
		out.println("</script>");

	}

}
