package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.*;

@WebServlet("/Login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final Register Null = null;
	BLManager bl = new BLManager();
	Patientregister reg = new Patientregister();
	Doctorregister doc = new Doctorregister();
	Adminregister adm = new Adminregister();

	Role r1 = new Role();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		reg = bl.searchemail(email);
		if(reg==null){
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Email or password incorrect');");
			out.println("location='page-login.jsp';");
			out.println("</script>");
		}
			

		else if (reg.getRole().getRoleName().equals("admin")) 
		{
			boolean b = bl.searchadminemailpass(email, password);
			if (b == true) 
			{ int id = adm.getId(); 
			
			String fname=adm.getFname();
			String lname=adm.getLname();
			String email1=adm.getEmail();
			int phoneno=adm.getPhoneno();
			
		    
			HttpSession session=request.getSession();
			session.setAttribute("fname", fname);
			
			session.setAttribute("lname", lname);
	
			session.setAttribute("email", email1);
			session.setAttribute("phoneno", phoneno);
			
			session.setAttribute("id", id);
			
			
				
				response.sendRedirect("admindashboard.jsp");
			} else 
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Email or password incorrect');");
				out.println("location='page-login.jsp';");
				out.println("</script>");
			}
			
		} 
		else if (doc.getRole().getRoleName().equals("doctor"))
	   {
			boolean b = bl.searchdoctoremailpass(email, password);
			if (b == true)
			{
				
				String fname=doc.getFname();
				String lname=doc.getLname();
				String email1=doc.getEmail();
				String phoneno=doc.getPhoneno();
				String address=doc.getAddress();
			    int did=doc.getDid();
			    String rname=reg.getRole().getRoleName();
				HttpSession session=request.getSession();
				session.setAttribute("fname", fname);
				
				session.setAttribute("lname", lname);
		
				session.setAttribute("email", email1);
				session.setAttribute("phoneno", phoneno);
				session.setAttribute("address", address);
				session.setAttribute("did", did);
				session.setAttribute("rname", rname);
				response.sendRedirect("doctordashboard.jsp");
			} 
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Email or password incorrect');");
				out.println("location='page-login.jsp';");
				out.println("</script>");

			}
		} 
		else if (reg.getRole().getRoleName().equals("patient"))
		{
			boolean b = bl.searchpatientemailpass(email, password);
			if (b == true) {
				
				Integer id=reg.getPid();
				
			String fname=reg.getFname();
				String lname=reg.getLname();
				String email1=reg.getEmail();
				String phoneno=reg.getPhoneno();
				
				 String rname=reg.getRole().getRoleName();
				HttpSession session=request.getSession();
				session.setAttribute("id", id);
				
				session.setAttribute("fname", fname);
				
				session.setAttribute("lname", lname);
		
				session.setAttribute("email", email1);
				session.setAttribute("phoneno", phoneno);
				
				session.setAttribute("rname", rname);
				response.sendRedirect("patientdashboard.jsp");
				
			} 
			else
			{
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Email or password incorrect');");
				out.println("location='page-login.jsp';");
				out.println("</script>");
				
		

			}
		} 
		else 
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Email or password incorrect');");
			out.println("location='page-login.jsp';");
			out.println("</script>");
		}
	}
}
