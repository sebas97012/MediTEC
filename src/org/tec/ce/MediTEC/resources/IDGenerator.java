package org.tec.ce.MediTEC.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.tec.ce.DataStructures.LinkedList.LinkedList;
import org.tec.ce.DataStructures.SplayTree.SplayTree;
import org.tec.ce.MediTEC.FileXMLManager;
import org.tec.ce.MediTEC.Random;
import org.tec.ce.MediTEC.dto.ID;

@Path("/idgenerator")
public class IDGenerator {
	private static LinkedList<ID> doctorsid;
	private static LinkedList<ID> patientsid;
	private static LinkedList<ID> appointmentsid;
	private static LinkedList<ID> clinicalCaseid;
	private static LinkedList<ID> medicalExamid;
	
	public IDGenerator(){
		 try {
			if(FileXMLManager.checkExistence("idgenerator.xml") == true){
				 List<LinkedList<ID>> ids = (ArrayList) FileXMLManager.getContent("idgenerator.xml");
				 doctorsid = (LinkedList<ID>) ids.get(0);
				 patientsid = (LinkedList<ID>) ids.get(1);
				 appointmentsid = (LinkedList<ID>) ids.get(2);
				 clinicalCaseid = (LinkedList<ID>) ids.get(3);
				 medicalExamid = (LinkedList<ID>) ids.get(4);
				 
			 } else{
				 List<LinkedList<ID>> ids = new ArrayList<>();
				 
				 doctorsid = new LinkedList<ID>();
				 patientsid = new LinkedList<ID>();
				 appointmentsid = new LinkedList<ID>();
				 clinicalCaseid = new LinkedList<ID>();
				 medicalExamid = new LinkedList<ID>();
				 
				 ids.add(0, doctorsid);
				 ids.add(1, patientsid);
				 ids.add(2, appointmentsid);
				 ids.add(3, clinicalCaseid);
				 ids.add(4, medicalExamid); 
				 
				 FileXMLManager.writeContent(ids, "idgenerator.xml");
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo para actualizar las lista almacenadas en el xml
	 */
	private void updateXML(){
		List<LinkedList<ID>> ids = new ArrayList<>();
		ids.add(0, doctorsid);
		ids.add(1, patientsid);
		ids.add(2, appointmentsid);
		ids.add(3, clinicalCaseid);
		ids.add(4, medicalExamid);
		FileXMLManager.writeContent(ids, "idgenerator.xml");
	}
	
	/**
	 * Metodo que verifica que el nuevo id no este ocupado
	 * @param newID El nuevo id que se desea utilizar
	 * @param list Lista en la que se debe verificar
	 * @return True si ya esta usado, false en caso contrario
	 */
	private boolean verifyNonUse(ID newID, LinkedList<ID> list){
		boolean contains = false;
		//Se recorre la lista en busca del elemento
		for(int i = 0; i < list.getSize(); i++){
			if(list.getElement(i).getDataT().compareTo(newID) == 0){
				contains = true;
			}
		}
		return contains;
	}
	
	@GET
	@Path("/doctor")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorID(){
		//Se obtiene el nuevo id
		int id = Random.getRamdomNumber(1000, 9999);
		ID newID = new ID(id);
		
		//Se verifica que no este en uso
		if(verifyNonUse(newID, doctorsid) == false){
			doctorsid.insertAtEnd(newID);
			this.updateXML();
			return Response.ok().entity(newID).build();
		} else{ //Si esta en uso se vuelve a repetir el proceso
			return this.getAppointmentID();
		}
	}
	
	@GET
	@Path("/patient")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatientID(){
		//Se obtiene el nuevo id
		int id = Random.getRamdomNumber(100000, 900000);
		ID newID = new ID(id);
		
		//Se verifica que no este en uso
		if(verifyNonUse(newID, patientsid) == false){
			patientsid.insertAtEnd(newID);
			this.updateXML();
			return Response.ok().entity(newID).build();
		} else{ //Si esta en uso se vuelve a repetir el proceso
			return this.getAppointmentID();
		}
	}
	
	@GET
	@Path("/appointment")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAppointmentID(){
		//Se obtiene el nuevo id
		int id = Random.getRamdomNumber(100000, 900000);
		ID newID = new ID(id);
		
		//Se verifica que no este en uso
		if(verifyNonUse(newID, appointmentsid) == false){
			appointmentsid.insertAtEnd(newID);
			this.updateXML();
			return Response.ok().entity(newID).build();
		} else{ //Si esta en uso se vuelve a repetir el proceso
			return this.getAppointmentID();
		}
	}
	
	@GET
	@Path("/clinicalcase")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClinicalCaseID(){
		//Se obtiene el nuevo id
		int id = Random.getRamdomNumber(100000, 900000);
		ID newID = new ID(id);
		
		//Se verifica que no este en uso
		if(verifyNonUse(newID, clinicalCaseid) == false){
			clinicalCaseid.insertAtEnd(newID);
			this.updateXML();
			return Response.ok().entity(newID).build();
		} else{ //Si esta en uso se vuelve a repetir el proceso
			return this.getAppointmentID();
		}
	}
	
	@GET
	@Path("/medicalexam")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedicalExamID(){
		//Se obtiene el nuevo id
		int id = Random.getRamdomNumber(100000, 900000);
		ID newID = new ID(id);
		
		//Se verifica que no este en uso
		if(verifyNonUse(newID, this.medicalExamid) == false){
			medicalExamid.insertAtEnd(newID);
			this.updateXML();
			return Response.ok().entity(newID).build();
		} else{ //Si esta en uso se vuelve a repetir el proceso
			return this.getAppointmentID();
		}
	}
	

}
