package com.controller;

import java.io.File;
import java.io.FilePermission;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.model.BLManager;
import com.pojo.*;


@WebServlet("/patientformservlet")

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 70, // 10MB
maxRequestSize = 1024 * 1024 * 100)

public class patientformservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	private static final String SAV_DIR = "C:/project/Medicare/WebContent/doc";
	FilePermission permission1 = new FilePermission(SAV_DIR, "write");

	BLManager bl = new BLManager();
	
	Role r1 = new Role();
	Patientregister p = new Patientregister();
	Doctorregister d = new Doctorregister();
     Applydoctor a=new Applydoctor();
	public patientformservlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		PrintWriter out = response.getWriter();

	
		String typeofproblem = request.getParameter("typeofproblem");
		//String report = request.getParameter("report");

		Part img1=request.getPart("symptoms");
		try {
			String Image1 = extractFileName(img1);
		    a.setSymptoms(Image1);
		    img1.write(SAV_DIR + File.separator + Image1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
        String doctor_id=request.getParameter("doctor_id");
        int did=Integer.parseInt(doctor_id);
        String reg_id=request.getParameter("reg_id");
        int reg_id1=Integer.parseInt(reg_id);
	
        p=bl.serachbyid(reg_id1);
        a.setPatien_id(reg_id1);

        d=bl.serachdocterid(did);
        a.setDoctor_id(did);
        
		a.setTypeofproblem(typeofproblem);

		

		bl.savepat(a);

		out.println("<script type=\"text/javascript\">");
		out.println("alert('Registration Done..!');");
		out.println("location='patientdashboard.jsp';");
		out.println("</script>");

	}

	private String extractFileName(Part img) {
		String contentDisp = img.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

}
