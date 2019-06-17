package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.Doctorregister;
import com.pojo.Patientregister;

import com.pojo.Role;


@WebServlet("/passwordupdateservlet")
public class passwordupdateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BLManager bl = new BLManager();
	Patientregister reg = new Patientregister();
	Doctorregister doc=new Doctorregister();
	Role r1 = new Role();
	Boolean check=false;
  
    public passwordupdateservlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String id= request.getParameter("id");
		Integer id1=Integer.parseInt(id);
		
		String rname = request.getParameter("rname");
		String fname = request.getParameter("fname");
		String lname=request.getParameter("lname");
		

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String gender =request.getParameter("gender");
		String addr =request.getParameter("address");
		String mobileno = request.getParameter("mobileno");
        Integer mobileno1 = Integer.parseInt(mobileno);
        String oldpass=request.getParameter("oldpass");
        String newpass=request.getParameter("newpass");
        String confirmpass=request.getParameter("confirmpass");
        check=bl.matchUserPasswordToChange(id1,oldpass);

		if(check==false)
		{
			

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Old password is wrong');");
			out.println("location='changepassword.jsp';");
			out.println("</script>");

			
			
		}
		else if(check==true)
		{
			if(newpass.equals(confirmpass))
			{	
				Patientregister u=bl.searchDataByUserId(id1); 
				
				 r1=bl.serachbyname(rname);
			        
					reg=bl.searchById(id1);
					
					
					reg.setRole(r1);
					reg.setPid(id1);
			    	reg.setFname(u.getFname());
					reg.setLname(u.getLname());
					
			        reg.setGender(u.getGender());
			        reg.setPassword(newpass);
					reg.setEmail(u.getEmail());
					
			        reg.setPhoneno(u.getPhoneno());

					bl.updateUserData(reg);
				
			}
			else
			{
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('New password doesnt match');");
				out.println("location='changepassword.jsp';");
				out.println("</script>");
			}
			
		}//elseif
       
       
		
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Update Done..!');");
		out.println("location='all_profile.jsp';");
		out.println("</script>");


	}


	
	}

