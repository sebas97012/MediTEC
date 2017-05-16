package org.tec.ce.MediTEC.resources;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.tec.ce.DataStructures.SplayTree.SplayTree;
import org.tec.ce.MediTEC.FileXMLManager;
import org.tec.ce.MediTEC.dto.DoctorDTO;
import org.tec.ce.MediTEC.dto.PatientDTO;

@Path("/patients")
public class Patients {
	public static SplayTree<PatientDTO> patientsTree;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Patients(){
		 //Se intenta obtener el arbol splay de los pacientes
		 try {
			if(FileXMLManager.checkExistence("patientsTree.xml") == true){
				 this.patientsTree = (SplayTree) FileXMLManager.getContent("patientsTree.xml");
			 } else{
				 this.patientsTree = new SplayTree<PatientDTO>();
				 FileXMLManager.writeContent(this.patientsTree, "patientsTree.xml");
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	/**
	 * Metodo que actualiza el arbol de pacientes almacenado en el xml
	 */
	public static void updatePatientsTree(){
		FileXMLManager.writeContent(patientsTree, "patientsTree.xml");
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatients(){
			return Response.ok().entity(this.patientsTree).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newPatient(PatientDTO newPatient){
		if(newPatient == null){
			return Response.status(400).build();
		} else{
			this.patientsTree.insert(newPatient);
			this.updatePatientsTree();
			return Response.ok().build();
		}
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteDoctor(PatientDTO patient){
		if(patient != null){
			this.patientsTree.remove(patient);
			this.updatePatientsTree();
			return Response.ok().build();
		} else{
			return Response.status(404).build();
		}
	}
	
	@Path("{id}")
	public Patient getPatient(@PathParam("id") int id){
		PatientDTO patient = new PatientDTO(id);
		
		if(this.patientsTree.contains(patient) == true){
			PatientDTO patient1 = (PatientDTO) this.patientsTree.search(patient).getData();
			return new Patient(patient1);
		} else{
			throw new NotFoundException(Response.status(404).build());
		}
	}

}
