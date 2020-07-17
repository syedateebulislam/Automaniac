package com.MainFiles;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Submitted_Script {

	@Id
	private int scriptId;
	private String name;
	private int inpReq;
	private String input1;
	private String sampleValue1;
	private String input2;
	private String sampleVaue2;
	private String aboutScript;
	
	public int getScriptId() {
		return scriptId;
	}
	public void setScriptId(int scriptId) {
		this.scriptId = scriptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getInpReq() {
		return inpReq;
	}
	public void setInpReq(int inpReq) {
		this.inpReq = inpReq;
	}
	public String getInput1() {
		return input1;
	}
	public void setInput1(String input1) {
		this.input1 = input1;
	}
	public String getSampleValue1() {
		return sampleValue1;
	}
	public void setSampleValue1(String sampleValue1) {
		this.sampleValue1 = sampleValue1;
	}
	public String getInput2() {
		return input2;
	}
	public void setInput2(String input2) {
		this.input2 = input2;
	}
	public String getSampleVaue2() {
		return sampleVaue2;
	}
	public void setSampleVaue2(String sampleVaue2) {
		this.sampleVaue2 = sampleVaue2;
	}
	public String getAboutScript() {
		return aboutScript;
	}
	public void setAboutScript(String aboutScript) {
		this.aboutScript = aboutScript;
	}	
}
