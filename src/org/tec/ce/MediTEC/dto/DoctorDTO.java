package org.tec.ce.MediTEC.dto;

import org.tec.ce.DataStructures.AVLTree.AVLTree;
import org.tec.ce.DataStructures.BinaryTree.BinaryTree;
import org.tec.ce.DataStructures.LinkedList.LinkedList;
import org.tec.ce.DataStructures.SplayTree.SplayTree;

public class DoctorDTO implements Comparable<DoctorDTO> {
	private int id;
	private AVLTree<Appointment> appointmentsList;
	private SplayTree<PatientDTO> patientsList;
	private LinkedList<Commentary> commentaries;
	private BinaryTree<ClinicalCase> clinicalCaseList;
	private LinkedList<Diary> schedule;

	public DoctorDTO(){
	
	}
	
	public DoctorDTO(int id){
		this.id = id;
		this.appointmentsList = new AVLTree<Appointment>();
		this.patientsList = new SplayTree<PatientDTO>();
		this.commentaries = new LinkedList<Commentary>();
		this.clinicalCaseList = new BinaryTree<ClinicalCase>();
		this.schedule = new LinkedList<Diary>();
	}

	public int getId() {
		return id;
	}

	public AVLTree<Appointment> getAppointmentsList() {
		return appointmentsList;
	}
	
	public void addAppointment(Appointment appointment){
		this.appointmentsList.insert(appointment);
		this.schedule.insertAtFirst(new Diary(appointment));
	}
	
	public void removeAppointment(Appointment appointment){
		this.appointmentsList.remove(appointment);
		this.schedule.deleteInDiary(appointment.getId()) ;
	}
	
	public LinkedList<Diary> getSchedule(){
		return schedule;
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
	
	public void addClinicalCase(ClinicalCase clinicalCase){
		this.clinicalCaseList.insert(clinicalCase);
	}
	
	public void removeClinicalCase(ClinicalCase clinicalCase){
		this.clinicalCaseList.remove(clinicalCase);
	}
	
	public BinaryTree<ClinicalCase> getClinicalCaseList(){
		return this.clinicalCaseList;
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
