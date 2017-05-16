package org.tec.ce.MediTEC.dto;

public class Commentary implements Comparable<Commentary>{
	private String comentary;
	private int qualification;
	
	public Commentary(){
		
	}
	
	public Commentary(String comentary, int qualification){
		this.comentary = comentary;
		this.qualification = qualification;
	}

	public String getComentary() {
		return comentary;
	}

	public int getQualification() {
		return qualification;
	}

	public int compareTo(Commentary arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
