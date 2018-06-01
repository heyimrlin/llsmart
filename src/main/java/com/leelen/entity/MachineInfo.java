package com.leelen.entity;


public class MachineInfo {

	private String machineid;
	
	private String machinename;
	
	private String machinecode;
	
	private String machinenote;
	
	private int isactivate;

	public String getMachineid() {
		return machineid;
	}

	public void setMachineid(String machineid) {
		this.machineid = machineid;
	}

	public String getMachinename() {
		return machinename;
	}

	public void setMachinename(String machinename) {
		this.machinename = machinename;
	}

	public String getMachinecode() {
		return machinecode;
	}

	public void setMachinecode(String machinecode) {
		this.machinecode = machinecode;
	}

	public String getMachinenote() {
		return machinenote;
	}

	public void setMachinenote(String machinenote) {
		this.machinenote = machinenote;
	}

	public int getIsactivate() {
		return isactivate;
	}

	public void setIsactivate(int isactivate) {
		this.isactivate = isactivate;
	}

	@Override
	public String toString() {
		return "MachineInfo [machineid=" + machineid + ", machinename=" + machinename + ", machinecode=" + machinecode
				+ ", machinenote=" + machinenote + ", isactivate=" + isactivate + "]";
	}
	
	
}
