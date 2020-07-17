package com.MainFiles;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

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
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

/*
 *Tasks to be done here-
 *1- Uploading validations of correct file(syntax,required format,etc).
 *2- Any other future validations required.
 *
 * */
//slack try 2

@WebServlet("/FileUpload")
@MultipartConfig
public class FileUpload extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entered into upload servlet...");
		String ip1 = request.getParameter("input1");
		String sv1 = request.getParameter("sampleValue1");
		String ip2 = request.getParameter("input2");
		String sv2 = request.getParameter("sampleValue2");
		String abtScr = request.getParameter("aboutScript");
		System.out.println(ip1+","+sv1+","+ip2+","+sv2+","+abtScr);
		
		Part filePart = request.getPart("file");
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    InputStream fileContent = filePart.getInputStream();
	    File targetFile = new File("/Users/Dell/Desktop/Office Stuff/Automaniac/src/com/UploadedFiles/"+fileName);
	    FileUtils.copyInputStreamToFile(fileContent, targetFile);
	    
	    response.sendRedirect("editpage_html.html");
	}
}