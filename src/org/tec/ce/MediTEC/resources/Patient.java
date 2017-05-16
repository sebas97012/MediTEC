package org.tec.ce.MediTEC.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.tec.ce.MediTEC.dto.Appointment;
import org.tec.ce.MediTEC.dto.PatientDTO;

public class Patient {
	private PatientDTO patient;
	
	public Patient(PatientDTO patient){
		this.patient = patient;
	}
	
	/**
	 * Metodo para obtener la instancia del doctor
	 * @return La instancia del doctor en formato Json
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatient(){
		return Response.ok().entity(this.patient).build();
	}
	
	/**
	 * Metodo para agregar una cita
	 * @param appointment Cita a agregar
	 * @return 200 si se realizo, en caso contrario error 400
	 */
	@PUT
	@Path("/add-appointment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addAppointment(Appointment appointment){
		if(appointment != null){
			this.patient.addAppointment(appointment);
			Patients.updatePatientsTree();
			return Response.ok().build();
		} else{
			return Response.status(400).build();
		}
	}
	
	/**
	 * Metodo para eliminar una cita de la lista del paciente
	 * @param appointment Cita a eliminar
	 * @return 200 si se realizo, en caso contrario error 400
	 */
	@DELETE
	@Path("/remove-appointment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteAppointment(Appointment appointment){
		if(appointment != null){
			this.patient.removeAppointment(appointment);
			Patients.updatePatientsTree();
			return Response.ok().build(); //Ok
		} else{
			return Response.status(400).build(); //NotFound
		}
	}
	
	@PUT
	@Path("/add-tocasefile")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addToCaseFile(Appointment appointment){
		if(appointment != null){
			this.patient.addToCaseFile(appointment);
			Patients.updatePatientsTree();
			return Response.ok().build();
		} else{
			return Response.status(400).build();
		}
	}
	
	@DELETE
	@Path("/remove-fromcasefile")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteFromCaseFile(Appointment appointment){
		if(appointment != null && this.patient.getCaseFile().getSize() > 0){
			this.patient.removeFromCaseFile(appointment);
			Patients.updatePatientsTree();
			return Response.ok().build(); //Ok
		} else{
			return Response.status(400).build(); //NotFound
		}
	}
	
}
