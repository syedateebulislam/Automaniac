package com.Dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.MainFiles.Submitted_Script;
import com.MainFiles.UserDetails;

public class ScriptDao {

	Configuration con = new Configuration().configure().addAnnotatedClass(Submitted_Script.class);	
	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	SessionFactory sf = con.buildSessionFactory(reg);

	public void SubmitScript(String username,int scriptId,String scriptName,String uploadedFileName,String GeneratedScriptFileName,String ip1ActualFullName,String ip1DefinedVarNameInCode,String ip2ActualFullName,String ip2DefinedVarNameInCode,String aboutScript) {
		
    	Submitted_Script script = new Submitted_Script();
    	
    	script.setUsername(username);
	    script.setScriptId(scriptId);
	    script.setScriptName(scriptName);
	    script.setUploadedFileName(uploadedFileName);
	    script.setGeneratedScriptFileName(GeneratedScriptFileName);
	    script.setIp1ActualFullName(ip1ActualFullName);
	    script.setIp1DefinedVarNameInCode(ip1DefinedVarNameInCode);
	    script.setIp2ActualFullName(ip2ActualFullName);
	    script.setIp2DefinedVarNameInCode(ip2DefinedVarNameInCode);
	    script.setAboutScript(aboutScript);
	    
	    Session session = sf.openSession();
    	Transaction tx = session.beginTransaction(); 
    	
    	session.save(script); //save data
    	
    	tx.commit();	
	}	
}
