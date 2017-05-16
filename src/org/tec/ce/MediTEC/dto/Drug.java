package org.tec.ce.MediTEC.dto;

public class Drug implements Comparable<Drug>{
	private String name;
	private int cost;
	private int id;
	
	public Drug(){
		
	}
	
	public Drug(String name, int cost, int id){
		this.name = name;
		this.cost = cost;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}

	public int getId() {
		return id;
	}

	public int compareTo(Drug drug) {
		if(this.id > drug.getId()){
			return 1;
		} else if(this.id < drug.getId()){
			return -1;
		} else{
			return 0;
		}
	}
}
