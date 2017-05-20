package org.tec.ce.MediTEC.dto;

public class ID implements Comparable<ID>{
	private int id;
	
	public ID(){
	}
	
	public ID(int id){
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int compareTo(ID arg0) {
		if(this.id == arg0.getId()){
			return 0;
		} else{
			return -1;
		}
	}
	
	

}
