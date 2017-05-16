package org.tec.ce.MediTEC.dto;

import org.tec.ce.DataStructures.AVLTree.AVLTree;
import org.tec.ce.DataStructures.BinaryTree.BinaryTree;
import org.tec.ce.DataStructures.LinkedList.LinkedList;

public class ClinicalCase implements Comparable<ClinicalCase>{
	private String name;
	private PatientDTO patient;
	private AVLTree<MedicalExam> medicalExams;
	private LinkedList<String> symptoms;
	private BinaryTree<Drug> drugs;
	private int id;
	
	public ClinicalCase(){
		
	}
	
	public ClinicalCase(String name, PatientDTO patient, int id){
		this.name = name;
		this.patient = patient;
		this.id = id;
		this.medicalExams = new AVLTree<MedicalExam>();
		this.drugs = new BinaryTree<Drug>();
	}

	public String getName() {
		return name;
	}

	public PatientDTO getPatient() {
		return patient;
	}

	public AVLTree<MedicalExam> getMedicalExams() {
		return medicalExams;
	}
	
	public void addMedicalExam(MedicalExam medicalExam){
		this.medicalExams.insert(medicalExam);
	}

	public LinkedList<String> getSymptoms() {
		return symptoms;
	}
	
	public void addSymptom(String symptom){
		this.symptoms.insertAtEnd(symptom);
	}

	public BinaryTree<Drug> getDrugs() {
		return drugs;
	}
	
	public void addDrug(Drug drug){
		this.drugs.insert(drug);
	}

	public int getId() {
		return id;
	}

	public int compareTo(ClinicalCase clinicalCase) {
		if(this.id > clinicalCase.getId()){
			return 1;
		} else if(this.id < clinicalCase.getId()){
			return -1;
		} else{
			return 0;
		}
	}
	
	
}
