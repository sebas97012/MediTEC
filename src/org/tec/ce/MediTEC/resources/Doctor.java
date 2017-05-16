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
import org.tec.ce.MediTEC.dto.Commentary;
import org.tec.ce.MediTEC.dto.DoctorDTO;
import org.tec.ce.MediTEC.dto.PatientDTO;

public class Doctor {
	private DoctorDTO doctor;
	
	public Doctor(DoctorDTO doctor){
		this.doctor = doctor;
	}
	
	/**
	 * Metodo para obtener la instancia del doctor
	 * @return La instancia del doctor en formato Json
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctor(){
		return Response.ok().entity(this.doctor).build();
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
			this.doctor.addAppointment(appointment);
			Doctors.updateDoctorsTree();
			return Response.ok().build();
		} else{
			return Response.status(400).build();
		}
	}
	
	/**
	 * Metodo para eliminar una cita de la lista del doctor
	 * @param appointment Cita a eliminar
	 * @return 200 si se realizo, en caso contrario error 400
	 */
	@DELETE
	@Path("/remove-appointment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteAppointment(Appointment appointment){
		if(appointment != null){
			this.doctor.removeAppointment(appointment);
			Doctors.updateDoctorsTree();
			return Response.ok().build(); //Ok
		} else{
			return Response.status(400).build(); //NotFound
		}
	}
	
	/**
	 * Metodo para agregar un nuevo paciente a la lista
	 * @param patient Paciente a agregar
	 * @return 200 si se realizo, en caso contrario error 400
	 */
	@PUT
	@Path("/add-patient")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPatient(PatientDTO patient){
		if(patient != null){
			this.doctor.addPatient(patient);
			Doctors.updateDoctorsTree();
			return Response.ok().build();
		} else{
			return Response.status(400).build();
		}
	}
	
	/**
	 * Metodo para eliminar un paciente de la lista
	 * @param patient Paciente a eliminar
	 * @return 200 si se realizo, en caso contrario error 400
	 */
	@DELETE
	@Path("/remove-patient")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletePatient(PatientDTO patient){
		if(patient != null){
			this.doctor.removePatient(patient);
			Doctors.updateDoctorsTree();
			return Response.ok().build();
		} else{
			return Response.status(400).build();
		}
	}
	
	/**
	 * Metodo para a�adir un nuevo comentario
	 * @param commentary Comentario a a�adir
	 * @return 200 si se realizo, en caso contrario error 400
	 */
	@PUT
	@Path("/add-commentary")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCommentary(Commentary commentary){
		if(commentary != null){
			this.doctor.addCommentary(commentary);
			Doctors.updateDoctorsTree();
			return Response.ok().build();
		} else{
			return Response.status(400).build();
		}
	}
}
