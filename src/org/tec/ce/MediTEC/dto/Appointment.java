package org.tec.ce.MediTEC.dto;

import org.tec.ce.DataStructures.BinaryTree.BinaryTree;

public class Appointment implements Comparable<Appointment>{
	private DoctorDTO assignedDoctor;
	private PatientDTO patient;
	private String date;
	private String hour;
	private BinaryTree<ClinicalCase> clinicalCase;
	private int cost;
	private int id;
	
	public Appointment(){
		
	}
	
	public Appointment(DoctorDTO doctor, PatientDTO patient, String date, String hour, int cost, int id){
		this.assignedDoctor = doctor;
		this.patient = patient;
		this.date = date;
		this.hour = hour;
		this.cost = cost;
		this.id = id;
		this.clinicalCase = new BinaryTree<ClinicalCase>();
	}

	public DoctorDTO getAssignedDoctor() {
		return assignedDoctor;
	}

	public void setAssignedDoctor(DoctorDTO assignedDoctor) {
		this.assignedDoctor = assignedDoctor;
	}

	public PatientDTO getPatient() {
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

	public BinaryTree<ClinicalCase> getClinicalCase() {
		return clinicalCase;
	}

	public int getCost() {
		return cost;
	}

	public int getId() {
		return id;
	}
	
	public void addToClinicalCase(ClinicalCase clinicalCase){
		this.clinicalCase.insert(clinicalCase);
	}
	
	public void deleteFromClinicalCase(ClinicalCase clinicalCase){
		this.clinicalCase.remove(clinicalCase);
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
