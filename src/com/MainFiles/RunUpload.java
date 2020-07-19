package com.MainFiles;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MainFiles.RunScript;

/*
 *Tasks to be done here-
 *1- Take button corresponding value to map script required to be run, from DB-mapping tables.
 *2- Taking user element from form fields.
 *3- Make it possible to take any number of fields with required script to be called.
 *4- if possible,add js notification to say "Hang on!! we are launching your browser..."
 *5- Think also from mobile device perspective.
 *6- where to put chromeDriver.exe to launch when deployed(maybe war)
 *
 * */

@WebServlet("/RunUpload")
@MultipartConfig
public class RunUpload extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("Servlet Called to Run Script...");
		String ip1 = request.getParameter("ScriptInput1");
//		String ip2 = request.getParameter("ScriptInput2"); working for FB
		//add required code here to take user keyword(task-2)
		try {
			RunScript.runScriptMethod(ip1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("editpage_html.html");//have to think about this future flow
	}
}
