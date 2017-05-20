package org.tec.ce.MediTEC.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;

import org.tec.ce.DataStructures.SplayTree.SplayTree;
import org.tec.ce.MediTEC.FileXMLManager;
import org.tec.ce.MediTEC.dto.Appointment;
import org.tec.ce.MediTEC.dto.Commentary;
import org.tec.ce.MediTEC.dto.DoctorDTO;
import org.tec.ce.MediTEC.dto.PatientDTO;

@Path("/doctors")
public class Doctors {
	private static SplayTree<DoctorDTO> doctorsTree;
	 
	public Doctors(){
		 //Se intenta obtener el arbol splay de los doctores
		 try {
			if(FileXMLManager.checkExistence("doctorsTree.xml") == true){
				 this.doctorsTree = (SplayTree) FileXMLManager.getContent("doctorsTree.xml");
			 } else{
				 this.doctorsTree = new SplayTree();
				 FileXMLManager.writeContent(this.doctorsTree, "doctorsTree.xml");
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	@GET
	@Path("/cc")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCC(){
		DoctorDTO app = new DoctorDTO(3030);
		return Response.ok().entity(app).build();
	}
	 
	public static void updateDoctorsTree(){
		FileXMLManager.writeContent(doctorsTree, "doctorsTree.xml");
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctors(){
			return Response.ok().entity(this.doctorsTree).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newDoctor(DoctorDTO newDoctor){
		if(newDoctor == null){
			return Response.status(400).build();
		} else{
			this.doctorsTree.insert(newDoctor);
			this.updateDoctorsTree();
			return Response.ok().build();
		}
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteDoctor(DoctorDTO doctor){
		if(doctor != null){
			this.doctorsTree.remove(doctor);
			this.updateDoctorsTree();
			return Response.ok().build();
		} else{
			return Response.status(400).build(); //Bad request
		}
	}
	
	@Path("{id}")
	public Doctor getDoctor(@PathParam("id") int id){
		DoctorDTO doctor = new DoctorDTO(id);
		
		if(this.doctorsTree.contains(doctor) == true){
			DoctorDTO doctor1 = (DoctorDTO) this.doctorsTree.search(doctor).getData();
			return new Doctor(doctor1);
		} else{
			throw new NotFoundException(Response.status(404).build());
		}
	}
}
