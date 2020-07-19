package com.MainFiles;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Submitted_Script {

	@Id
	private int scriptId;
	private String username;
	private String scriptName;
	private String uploadedFileName;
	private String GeneratedScriptFileName;
	private String ip1ActualFullName;
	private String ip1DefinedVarNameInCode;
	private String ip2ActualFullName;
	private String ip2DefinedVarNameInCode;
	private String aboutScript;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getScriptId() {
		return scriptId;
	}
	public void setScriptId(int scriptId) {
		this.scriptId = scriptId;
	}
	public String getScriptName() {
		return scriptName;
	}
	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}
	public String getUploadedFileName() {
		return uploadedFileName;
	}
	public void setUploadedFileName(String uploadedFileName) {
		this.uploadedFileName = uploadedFileName;
	}
	public String getGeneratedScriptFileName() {
		return GeneratedScriptFileName;
	}
	public void setGeneratedScriptFileName(String generatedScriptFileName) {
		GeneratedScriptFileName = generatedScriptFileName;
	}
	public String getIp1ActualFullName() {
		return ip1ActualFullName;
	}
	public void setIp1ActualFullName(String ip1ActualFullName) {
		this.ip1ActualFullName = ip1ActualFullName;
	}
	public String getIp1DefinedVarNameInCode() {
		return ip1DefinedVarNameInCode;
	}
	public void setIp1DefinedVarNameInCode(String ip1DefinedVarNameInCode) {
		this.ip1DefinedVarNameInCode = ip1DefinedVarNameInCode;
	}
	public String getIp2ActualFullName() {
		return ip2ActualFullName;
	}
	public void setIp2ActualFullName(String ip2ActualFullName) {
		this.ip2ActualFullName = ip2ActualFullName;
	}
	public String getIp2DefinedVarNameInCode() {
		return ip2DefinedVarNameInCode;
	}
	public void setIp2DefinedVarNameInCode(String ip2DefinedVarNameInCode) {
		this.ip2DefinedVarNameInCode = ip2DefinedVarNameInCode;
	}
	public String getAboutScript() {
		return aboutScript;
	}
	public void setAboutScript(String aboutScript) {
		this.aboutScript = aboutScript;
	}	
}
