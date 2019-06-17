package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.impl.SessionImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.Doctorregister;
import com.pojo.Patientregister;

import com.pojo.Role;

@WebServlet("/Updateservlet")
public class Updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BLManager bl = new BLManager();
	Patientregister reg = new Patientregister();
	Doctorregister doc = new Doctorregister();
	Role r1 = new Role();
    public Updateservlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
	
		String id= request.getParameter("id");
		int id1=Integer.parseInt(id);
		
		String rname = request.getParameter("rname");
		String fname = request.getParameter("fname");
		String lname=request.getParameter("lname");
		

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		String gender =request.getParameter("gender");
		String addr =request.getParameter("address");
		String phoneno = request.getParameter("phoneno");
    
        r1=bl.serachbyname(rname);
        
		reg=bl.searchById(id1);
		
		
		reg.setRole(r1);
		reg.setPid(id1);
    	reg.setFname(fname);
		reg.setLname(lname);
		
        reg.setGender(gender);
        reg.setPassword(pass);
		reg.setEmail(email);
		
        reg.setPhoneno(phoneno);

		bl.updateUserData(reg);
		
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Update Done..!');");
		out.println("location='all_profile.jsp';");
		out.println("</script>");


	}

}
