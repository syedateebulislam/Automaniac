package com.MainFiles;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

/*
 *Tasks to be done here-
 *1- Uploading validations of correct file(syntax,required format,etc).
 *2- Any other future validations required.
 *
 * */


@WebServlet("/FileUpload")
@MultipartConfig
public class FileUpload extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		System.out.println("entered into servlet.");
		
		String ip1 = request.getParameter("input1");
		String ip2 = request.getParameter("input2");
		String sv1 = request.getParameter("sampleValue1");
		String sv2 = request.getParameter("sampleValue2");
		System.out.println(ip1+sv1+ip2+sv2);
		
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		try {
			List<FileItem> uploadedFiles = sf.parseRequest(request);
			
			for(FileItem item: uploadedFiles) {
				item.write(new File("/Users/Dell/Desktop/Office Stuff/Automaniac/src/com/UploadedFiles/"+item.getName()));
			}			
			System.out.println("File Uploaded Successfully...");//add js here for success notification
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("editpage_html.html");
	}
}