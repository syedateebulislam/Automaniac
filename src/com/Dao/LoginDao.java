package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.MainFiles.UserDetails;
//slack try 1
public class LoginDao {

	Configuration con = new Configuration().configure().addAnnotatedClass(UserDetails.class);	
	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	SessionFactory sf = con.buildSessionFactory(reg);

	public boolean SignUp(String fname,String lname,String gender,String country,String email,String password) {		
	
		boolean NullValue=false;
		boolean duplicateUser=false;
		if(fname.isEmpty() || lname.isEmpty() || gender.isEmpty() || country.isEmpty() || email.isEmpty() || password.isEmpty()){
			NullValue = true;
		}
		
		if(NullValue) {
			System.out.println("Null value sent for SignUp.");		
			return false;
		}
		else 
		{	
			Session session1 = sf.openSession();
	    	Transaction tx1 = session1.beginTransaction(); 
	    	    	
	    	Query q = session1.createQuery("select fname from UserDetails where fname=:u");
	    	q.setParameter("u", fname);
	    	String duplicate = (String) q.uniqueResult();

	    	tx1.commit();
	    	
	    	if(fname.equalsIgnoreCase(duplicate)) {
	    		duplicateUser=true;
	    	}else {
	    		duplicateUser= false;
	    	}
			if(duplicateUser) {
				System.out.println("username not available");
			}else {
				UserDetails user = new UserDetails();		
				user.setFname(fname);
				user.setLname(lname);
				user.setGender(gender);
				user.setCountry(country);
				user.setEmailId(email);
				user.setPassword(password);
				
		    	Session session2 = sf.openSession();	    	
		    	Transaction tx2 = session2.beginTransaction(); 
		    	
		    	session2.save(user); //save data
		    	
		    	tx2.commit();	    	
		    	return true;
			}
		}
		return false;
	}

	public boolean Login(String username,String password) {
		Session session = sf.openSession();
    	Transaction tx = session.beginTransaction(); 
    	    	
    	Query q = session.createQuery("select password from UserDetails where fname=:u");
    	q.setParameter("u", username);
    	String pass = (String) q.uniqueResult();

    	if(password.equalsIgnoreCase(pass)) {
    		return true;
    	}
    	tx.commit();    	
		return false;
	}	
}