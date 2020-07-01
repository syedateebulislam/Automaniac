package com.MainFiles;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		try {
			System.out.println("entered into servlet.");
			List<FileItem> uploadedFiles = sf.parseRequest(request);
			
			for(FileItem item: uploadedFiles) {
				System.out.println("Inside for loop.");//DemoApp\src\com\DemoApp
				item.write(new File("/Users/Dell/Desktop/Office Stuff/Automaniac/src/com/UploadedFiles/"+item.getName()));
			}			
			System.out.println("Uploaded");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("editpage_html.html");
	}
}