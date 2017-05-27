package org.tec.ce.MediTEC.dto;

import org.tec.ce.DataStructures.AVLTree.AVLTree;
import org.tec.ce.DataStructures.LinkedList.LinkedList;

public class PatientDTO implements Comparable<PatientDTO>{
	private String name;
	private int age;
	private int identificationNumber;
	private int phoneNumber;
	private AVLTree<Appointment> appointmentList;
	private LinkedList<Appointment> caseFile;
	private String email;
	
	public PatientDTO(){
		
	}
	
	public PatientDTO(int identificationNumber){
		this.identificationNumber = identificationNumber;
	}
	
	public PatientDTO(String name, int age, int identificationNumber, int phoneNumber){
		this.name = name;
		this.age = age;
		this.identificationNumber = identificationNumber;
		this.phoneNumber = phoneNumber;
		this.appointmentList = new AVLTree<Appointment>();
		this.caseFile = new LinkedList<Appointment>();
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getIdentificationNumber() {
		return identificationNumber;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public AVLTree<Appointment> getAppointmentList() {
		return appointmentList;
	}
	
	public void addAppointment(Appointment appointment){
		this.appointmentList.insert(appointment);
	}
	
	public void removeAppointment(Appointment appointment){
		this.appointmentList.remove(appointment);
	}

	public LinkedList<Appointment> getCaseFile() {
		return caseFile;
	}
	
	public void addToCaseFile(Appointment appointment){
		this.caseFile.insertAtEnd(appointment);
	}
	
	public void removeFromCaseFile(Appointment appointment){
		this.caseFile.deleteElement(appointment);
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int compareTo(PatientDTO patient) {
		if(this.identificationNumber > patient.getIdentificationNumber()){
			return 1;
		} else if(this.identificationNumber < patient.getIdentificationNumber()){
			return -1;
		} else{
			return 0;
		}
	}
}
