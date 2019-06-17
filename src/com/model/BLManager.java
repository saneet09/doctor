package com.model;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;



import com.mysql.jdbc.Connection;
import com.pojo.*;

public class BLManager {
	static SessionFactory con = new Configuration().configure().buildSessionFactory();

	public void saveReg(Patientregister reg) {
		Session s = con.openSession();
		Transaction t = s.beginTransaction();
		s.save(reg);
		t.commit();
		s.close();

	}

	
	
	public void savepat(Applydoctor pat) {
		Session s = con.openSession();
		Transaction t = s.beginTransaction();
		s.save(pat);
		t.commit();
		s.close();
	}


	

	public Patientregister searchemail(String email) {
		Patientregister r;
		Session s = con.openSession();
		Criteria cr = s.createCriteria(Patientregister.class);
		cr.add(Restrictions.eq("email", email));
		r = (Patientregister) cr.uniqueResult();

		return r;
	}
	public Role searchrolId(Integer role_id) {
		Session s = con.openSession();
		Criteria cr = s.createCriteria(Role.class);
		cr.add(Restrictions.eq("id", role_id));
		Role r = (Role) cr.uniqueResult();

		return r;
	}

	public Doctorregister searchemail1(String email) {
		Doctorregister r;
		Session s = con.openSession();
		Criteria cr = s.createCriteria(Patientregister.class);
		cr.add(Restrictions.eq("email", email));
		r = (Doctorregister) cr.uniqueResult();

		return r;
	}

	public Role serachrole_id(String role_id) {

		Session s = con.openSession();
		Criteria cr = s.createCriteria(Role.class);
		cr.add(Restrictions.eq("rid", role_id));
		Role r = (Role) cr.uniqueResult();
		return r;

	}

	public void savedoc(Doctorregister d) {
		Session s = con.openSession();
		Transaction t = s.beginTransaction();
		s.save(d);
		t.commit();
		s.close();

	}
	public Patientregister serachbyid(Integer reg_id1) {
		Session s = con.openSession();
		Criteria cr = s.createCriteria(Patientregister.class);
		cr.add(Restrictions.eq("id", reg_id1));
		Patientregister r = (Patientregister) cr.uniqueResult();

		return r;
	}

	

	public Doctorregister serachdocterid(Integer did) {
		Session s = con.openSession();
		Criteria cr = s.createCriteria(Doctorregister.class);
		cr.add(Restrictions.eq("did", did));
		Doctorregister r = (Doctorregister) cr.uniqueResult();

		return r;
	}

	public  int delete(Patientregister u) {
		int status = 0;
		try {
			Session s = con.openSession();
			java.sql.PreparedStatement ps = ((Connection) s).prepareStatement("delete from register where id=?");
			ps.setInt(1, u.getPid());
			status = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}
	public void updateUserData(Patientregister r) 
	{
		Session session = con.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(r);
		transaction.commit();
		session.close();

	}

	public Patientregister searchbyrole_id(Integer role_id) {
		Session s = con.openSession();
		Criteria cr = s.createCriteria(Patientregister.class);
		cr.add(Restrictions.eq("rolId", role_id));
		Patientregister r = (Patientregister) cr.uniqueResult();

		return r;
	}

	public Patientregister searchById(int id1) {
		Session session = con.openSession();
		Criteria criteria = session.createCriteria(Patientregister.class);
		criteria.add(Restrictions.eq("id", id1));
		Patientregister r = (Patientregister) criteria.uniqueResult();
		session.close();
		return r;
		
	}

	public Role serachbyname(String rname) 
	{
		Session session = con.openSession();
		Criteria criteria = session.createCriteria(Role.class);
		criteria.add(Restrictions.eq("rname", rname));
		Role r = (Role) criteria.uniqueResult();
		session.close();
		return r;
		
	}
	
	public List<Doctorregister> searchalldoctor(Integer role_id)
	{
		Session session=con.openSession();
		
		Criteria criteria=session.createCriteria(Doctorregister.class,"reg");
		criteria.createAlias("reg.role","ro");
		
		criteria.add(Restrictions.eq("ro.rid",role_id));
		
		List<Doctorregister> f=criteria.list();
		return f;
	}
	
	public List<Patientregister> searchallappoinment(Integer pid)
	{
		Session session=con.openSession();
		
		Criteria criteria=session.createCriteria(Patientregister.class,"reg");
		criteria.createAlias("reg.register","ro");
		
		criteria.add(Restrictions.eq("ro.id",pid));
		
		List<Patientregister> f=criteria.list();
		return f;
	}
	public List<Doctorregister> searchallappoinment1(Integer did)
	{
		Session session=con.openSession();
		
		Criteria criteria=session.createCriteria(Doctorregister.class,"reg");
		criteria.createAlias("reg.register","ro");
		
		criteria.add(Restrictions.eq("ro.id",did));
		
		List<Doctorregister> f=criteria.list();
		return f;
	}
	public String checkpass(String password,String oldpass, String newpass, String confirmpass) {
		 if((password==newpass)&&(newpass!=confirmpass)&&(password!=oldpass) )
	        {
	         return null;	
	        }
		 else{
		return confirmpass;
	}
	}

	public Boolean matchUserPasswordToChange(int id1, String oldpass) {
Patientregister  user=matchUserPassword(id1,oldpass);  
		
		if(user==null)
		   return false;
		else if(id1==(user.getPid()) && oldpass != null && oldpass.equals(user.getPassword()))
			return true;
		else
			return false;
	}

	private Patientregister matchUserPassword(int id1, String oldpass) {

		Session session=con.openSession();
		Criteria criteria=session.createCriteria(Patientregister.class);
		criteria.add(Restrictions.eq("id",id1));
		criteria.add(Restrictions.eq("password", oldpass));
		Patientregister u=(Patientregister) criteria.uniqueResult();
		return u;
	}

	public Patientregister searchDataByUserId(int id1) {
		Session session = con.openSession();
		Criteria criteria = session.createCriteria(Patientregister.class);
		criteria.add(Restrictions.eq("id", id1));
		Patientregister u = (Patientregister)criteria.uniqueResult();
		session.close();
		return u;
	}
	public void deleteObject( Integer id) {    
	    Session session = con.openSession();
	    Object hibernateObject = session.load(Patientregister.class, id);
	    Object hO2=session.createCriteria(Patientregister.class); 
	    ((Criteria) hO2).add(Restrictions.eq("reg_id", id));
	    session.delete(hO2);
	    session.delete(hibernateObject);
	         
	    session.close();
	    return ;
	}
	public Patientregister searchAdminStationDataById(int id1) {
		Session session = con.openSession();
		Criteria criteria = session.createCriteria(Patientregister.class);
		criteria.add(Restrictions.eq("id", id1));
		Patientregister u = (Patientregister)criteria.uniqueResult();
		session.close();
		return u;
		

}
	public void deleteStationFromAdminPanel(Patientregister reg) {
		Session session = con.openSession();
		Transaction transaction=session.beginTransaction();
		
		session.delete(reg);
		transaction.commit();
		session.close();
	}


	public boolean searchadminemailpass(String email, String password) {
		Adminregister a=searchAdminemailpass(email,password);
		if(a!=null && a.getEmail().equals(email) && a.getPassword().equals(password)){
			return true;
			
		}
		else
		{
			return false;
		}
	}


	private Adminregister searchAdminemailpass(String email, String password) {
	 Session s=con.openSession();
	 Criteria cr=s.createCriteria(Adminregister.class);
	 cr.add(Restrictions.eq("email", email));
	 cr.add(Restrictions.eq("password", password));	
	Adminregister r=(Adminregister)cr.uniqueResult();
	return r;
	}


	public boolean searchdoctoremailpass(String email, String password) {
		Doctorregister a=searchDoctoremailpass(email,password);
		if(a!=null && a.getEmail().equals(email) && a.getPassword().equals(password)){
			return true;
			
		}
		else
		{
			return false;
		}
	}


	private Doctorregister searchDoctoremailpass(String email, String password) {
		
		 Session s=con.openSession();
		 Criteria cr=s.createCriteria(Doctorregister.class);
		 cr.add(Restrictions.eq("email", email));
		 cr.add(Restrictions.eq("password", password));	
		Doctorregister r=(Doctorregister)cr.uniqueResult();
		return r;
	}


	public boolean searchpatientemailpass(String email, String password) {
		Patientregister a=searchPatientemailpass(email,password);
		if(a!=null && a.getEmail().equals(email) && a.getPassword().equals(password)){
			return true;
			
		}
		else
		{
			return false;
		}
	}


	private Patientregister searchPatientemailpass(String email, String password) {
		 Session s=con.openSession();
		 Criteria cr=s.createCriteria(Doctorregister.class);
		 cr.add(Restrictions.eq("email", email));
		 cr.add(Restrictions.eq("password", password));	
		Patientregister r=(Patientregister)cr.uniqueResult();
		return r;
	}



	public void saveAdm(Adminregister adm)
	{
		// TODO Auto-generated method stub
		
	}

	

	
	}
		

	
