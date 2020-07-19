package com.MainFiles;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import com.Dao.ScriptDao;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;

/*
 *Tasks to be done here-
 *1- Uploading validations of correct file(syntax,required format,etc). -- Achieved (will add size validation later)
 *2- Any other future validations required.
 *
 * */
//slack try 5

@WebServlet("/FileUpload")
@MultipartConfig
public class FileUpload extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entered into upload servlet...");
				
		String scriptName = request.getParameter("scriptName");
		String ip1ActualFullName = request.getParameter("input1");
		String ip1DefinedVarNameInCode = request.getParameter("definedVar1");
		String ip2ActualFullName = request.getParameter("input2");
		String ip2DefinedVarNameInCode = request.getParameter("definedVar2");
		String aboutScript = request.getParameter("aboutScript");
		System.out.println(scriptName+","+ip1ActualFullName+","+ip1DefinedVarNameInCode+","+ip2ActualFullName+","+ip2DefinedVarNameInCode+","+aboutScript);
		
		Random r = new Random();
		String username="Ateeb_Run";//take this from session value
		int scriptId=r.nextInt(10000);
		String GeneratedScriptFileName=username+"_"+scriptId;
		
		Part filePart = request.getPart("file");
	    String uploadedFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
	    InputStream fileContent = filePart.getInputStream();
	    File targetFile = new File("/Users/Dell/Desktop/Office Stuff/Automaniac/src/com/UploadedFiles/"+uploadedFileName);
	    FileUtils.copyInputStreamToFile(fileContent, targetFile);
	    	    
	    System.out.println("fileName in servlet - "+uploadedFileName);
	    String[] fname = {uploadedFileName,GeneratedScriptFileName};
	    
	    // Sending for File Handling
	    FileHandling.main(fname);
	    
	    // Sending for Hibernate Integration
	    ScriptDao dao = new ScriptDao();
	    dao.SubmitScript(username, scriptId, scriptName, uploadedFileName, GeneratedScriptFileName, ip1ActualFullName, ip1DefinedVarNameInCode, ip2ActualFullName, ip2DefinedVarNameInCode, aboutScript);
	    
	    response.sendRedirect("editpage_html.html");
	}
}