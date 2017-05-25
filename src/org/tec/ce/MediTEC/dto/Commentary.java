package org.tec.ce.MediTEC.dto;

public class Commentary implements Comparable<Commentary>{
	private String comentary;
	private int qualification;
	private int id;
	
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

	public void setComentary(String comentary) {
		this.comentary = comentary;
	}

	public void setQualification(int qualification) {
		this.qualification = qualification;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public int compareTo(Commentary arg0) {
		if(this.id > arg0.getId()){
			return 1;
		} else if(this.id < arg0.getId()){
			return -1;
		} else{
			return 0;
		}
	}
}
