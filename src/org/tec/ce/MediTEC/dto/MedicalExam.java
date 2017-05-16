package org.tec.ce.MediTEC.dto;

public class MedicalExam implements Comparable<MedicalExam>{
	private String name;
	private int cost;
	private int id;
	
	public MedicalExam(){
		
	}
	
	public MedicalExam(String name, int cost, int id){
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

	public int compareTo(MedicalExam medicalExam) {
		if(this.id > medicalExam.getId()){
			return 1;
		} else if(this.id < medicalExam.getId()){
			return -1;
		} else{
			return 0;
		}
	}
}
