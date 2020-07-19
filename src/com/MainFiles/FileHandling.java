package com.MainFiles;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileHandling {

	public static void main(String[] args) throws IOException {

		
		boolean isJavaFile = false;
		String uploadFile=null;
		String FileName=null;
		int i=0;
		for(String s:args) {
			if(i==0) {
				uploadFile=s; //Upload file name set
			}
			if(i==1) {
				FileName=s;//Generated File Name
			}
			i++;
		}
		
		// Write this Validation code in servlet filter to show error msg in 'not java' case
		//1- ************************ File Validations Starts Here ******************
		File srcFile1=new File("C://Users//Dell//Desktop//Office Stuff//Automaniac//src//com//UploadedFiles//"+uploadFile);
		FileReader fileReader1=new FileReader(srcFile1);
		BufferedReader BufferReader1=new BufferedReader(fileReader1);
		int valid=0;
		String sFile1 = BufferReader1.readLine();
		    while(sFile1!=null)
		    {
		        if(sFile1.contains("package")) {
		        	valid++;
		        }
		        if(sFile1.contains("import")) {
		        	valid++;
		        }
		        if(sFile1.contains("main")) {
		        	valid++;
		        }
		        sFile1=BufferReader1.readLine();
		        
		    }
		    if(valid>=3) {
		    	System.out.println("JAVA file");
		    	isJavaFile=true;
		    	
		    }else {
		    	System.out.println("Not Java file");
		    }
		    System.out.println("File Validations Done...");	
		
		// ************************ File Validations Ends Here  ***************************

		//2- ********************** File generation Starts Here ****************************    
		if(isJavaFile) {
//		Random r = new Random();
//		String username="Ateeb_Run";//take this from session value
//		int scriptId=r.nextInt(1000);
//		String FileName=username+"_"+scriptId;
	    try {
	      File myObj = new File("C://Users//Dell//Desktop//Office Stuff//Automaniac//src//com//RunFiles//"+FileName+".java");
	      if (myObj.createNewFile()) {
	        System.out.println("File created: " + myObj.getName());
	      }
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		System.out.println("File generation Done...");

		// ********************** File generation Ends Here ****************************

		//3- ******************** File Read and Write Starts Here **********************
		
		File srcFile2=new File("C://Users//Dell//Desktop//Office Stuff//Automaniac//src//com//UploadedFiles//"+uploadFile);//source file
		FileReader fileReader2=new FileReader(srcFile2);
		BufferedReader BufferReader2=new BufferedReader(fileReader2);
		String strSrcFile2 = BufferReader2.readLine();
		
		File dstnFile1=new File("C://Users//Dell//Desktop//Office Stuff//Automaniac//src//com//RunFiles//"+FileName+".java");//destination file
		FileWriter dstnFile1Wrtr=new FileWriter(dstnFile1);
		BufferedWriter dstnFile1BfrdWrtr=new BufferedWriter(dstnFile1Wrtr);
		while(strSrcFile2!=null)
		    {
				if(strSrcFile2.contains("package")) {
					strSrcFile2="package com.RunFiles;";
				}
				if(strSrcFile2.contains("public class")) {
					strSrcFile2="public class "+FileName+"{";
				}
				dstnFile1BfrdWrtr.write(strSrcFile2);
		        dstnFile1BfrdWrtr.newLine();
		        strSrcFile2=BufferReader2.readLine();

		    }
		dstnFile1BfrdWrtr.flush();
		dstnFile1BfrdWrtr.close();
		System.out.println("File "+FileName+".java" +" Read-Write Done...");
		
		// ********************** File Read and Write Ends Here ****************************

		// ********************** fixing original uploaded file starts ************************

		File srcFileOrg=new File("C://Users//Dell//Desktop//Office Stuff//Automaniac//src//com//UploadedFiles//"+uploadFile);//source file
		FileReader fileReaderOrg1=new FileReader(srcFileOrg);
		BufferedReader BufferReaderOrg1=new BufferedReader(fileReaderOrg1);
		String strSrcFileOrg = BufferReaderOrg1.readLine();
		
		File dstnFileOrg=new File("C://Users//Dell//Desktop//Office Stuff//Automaniac//src//com//UploadedFiles//"+uploadFile);//destination file
		FileWriter dstnFileOrgWrtr=new FileWriter(dstnFileOrg);
		BufferedWriter dstnFile1BfrdWrtrOrg=new BufferedWriter(dstnFileOrgWrtr);
		while(strSrcFileOrg!=null)
		    {
				if(strSrcFileOrg.contains("package")) {
					strSrcFileOrg="package com.UploadedFiles;";
				}
				dstnFile1BfrdWrtrOrg.write(strSrcFileOrg);
		        dstnFile1BfrdWrtrOrg.newLine();
		        strSrcFileOrg=BufferReaderOrg1.readLine();

		    }
		dstnFile1BfrdWrtrOrg.flush();
		dstnFile1BfrdWrtrOrg.close();
		System.out.println("Fixed Uploaded file package name.");
		// ******************** fixing original uploaded file ends **********************
	}
	else
	{
		System.out.println("Not Java File");
	} 
  }
}
