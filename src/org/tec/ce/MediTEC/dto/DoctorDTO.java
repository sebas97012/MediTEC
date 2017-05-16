package org.tec.ce.MediTEC.dto;

import org.tec.ce.DataStructures.AVLTree.AVLTree;
import org.tec.ce.DataStructures.LinkedList.LinkedList;
import org.tec.ce.DataStructures.SplayTree.SplayTree;

public class DoctorDTO implements Comparable<DoctorDTO> {
	private int id;
	private AVLTree<Appointment> appointmentsList;
	private SplayTree<PatientDTO> patientsList;
	private LinkedList<Commentary> commentaries;
	
	public DoctorDTO(){
	
	}
	
	public DoctorDTO(int id){
		this.id = id;
		this.appointmentsList = new AVLTree<Appointment>();
		this.patientsList = new SplayTree<PatientDTO>();
		this.commentaries = new LinkedList<Commentary>();
	}

	public int getId() {
		return id;
	}

	public AVLTree<Appointment> getAppointmentsList() {
		return appointmentsList;
	}
	
	public void addAppointment(Appointment appointment){
		this.appointmentsList.insert(appointment);
	}
	
	public void removeAppointment(Appointment appointment){
		this.appointmentsList.remove(appointment);
	}

	public SplayTree<PatientDTO> getPatientsList() {
		return patientsList;
	}
	
	public void addPatient(PatientDTO patient){
		this.patientsList.insert(patient);
	}
	
	public void removePatient(PatientDTO patient){
		this.patientsList.remove(patient);
	}

	public LinkedList<Commentary> getCommentaries() {
		return commentaries;
	}
	
	public void addCommentary(Commentary commentary){
		this.commentaries.insertAtEnd(commentary);
	}

	public int compareTo(DoctorDTO arg0) {
		if(this.id > arg0.getId()){
			return 1;
		} else if(this.id < arg0.getId()){
			return -1;
		} else{
			return 0;
		}
	}
}
