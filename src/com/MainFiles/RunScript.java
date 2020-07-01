package com.MainFiles;

import com.UploadedFiles.*;


public class RunScript {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("trying first jenkins build");
		System.out.println("RunScript.main started");
		runScriptMethod();
		System.out.println("RunScript.main finished");
		}
	
	public static void runScriptMethod() throws InterruptedException {

		System.out.println("RunScript.runScriptMethod started");

		launchbrowser.Test();//Dynamically take that specific corresponding method
							
//		String fileToCompile = "/Users/Dell/Desktop/Office Stuff/DemoApp/src/com/DemoApp/UploadedFiles/launchbrowser.java";
//		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//		System.out.println("path4 at - "+fileToCompile);
//		int compilationResult =	compiler.run(null, null, null, fileToCompile);
//		
//		if(compilationResult==0) {
//			System.out.println("compile Success");
//			launchbrowser.Test();//taking method name at runtime
//		}
//		else {
//			System.out.println("try again");
//		}
//		
		System.out.println("RunScript.runScriptMethod finished");
	}
}