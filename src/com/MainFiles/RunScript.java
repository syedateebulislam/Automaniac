package com.MainFiles;

import com.UploadedFiles.*;

public class RunScript {
	public static void main(String[] args) throws InterruptedException {
		String keyword=null;
		runScriptMethod(keyword);
		}
	
	public static void runScriptMethod(String keyword) throws InterruptedException {
		
		GoogleSearch.Test(keyword);//Dynamically take that specific corresponding method using if DB mapping and checks
		
//		Second approach code(left if required in future)
/*		
		String fileToCompile = "/Users/Dell/Desktop/Office Stuff/DemoApp/src/com/DemoApp/UploadedFiles/launchbrowser.java";
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		System.out.println("path4 at - "+fileToCompile);
		int compilationResult =	compiler.run(null, null, null, fileToCompile);
		
		if(compilationResult==0) {
			System.out.println("compile Success");
			launchbrowser.Test();//taking method name at runtime
		}
		else {
			System.out.println("try again");
		}
*/		
	}
}