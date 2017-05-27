package org.tec.ce.MediTEC.dto;


import org.tec.ce.DataStructures.LinkedList.LinkedList;

public class Appointment implements Comparable<Appointment>{
	private int assignedDoctor;
	private int patient;
	private String date;
	private String hour;
	private ClinicalCase clinicalCase;
	private int cost;
	private int id;
	
	public Appointment(){
		
	}
	
	public Appointment(int doctorID, int patientID, String date, String hour, int cost, int id, LinkedList<String> symptoms){
		this.assignedDoctor = doctorID;
		this.patient = patientID;
		this.date = date;
		this.hour = hour;
		this.cost = cost;
		this.id = id;
		this.clinicalCase = new ClinicalCase(patientID, id, symptoms);
	}

	public int getAssignedDoctor() {
		return assignedDoctor;
	}

	public void setAssignedDoctor(int assignedDoctorID) {
		this.assignedDoctor = assignedDoctorID;
	}

	public int getPatient() {
		return patient;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public ClinicalCase getClinicalCase() {
		return clinicalCase;
	}

	public int getCost() {
		return cost;
	}

	public int getId() {
		return id;
	}

	public int compareTo(Appointment appointment) {
		if(this.id > appointment.getId()){
			return 1;
		} else if(this.id < appointment.getId()){
			return -1;
		} else{
			return 0;
		}
	}
}