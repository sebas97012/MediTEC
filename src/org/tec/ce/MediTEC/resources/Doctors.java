package org.tec.ce.MediTEC.resources;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;

@Path("/docs")
public class Doctors {
	
 private List<String> doctors = new ArrayList<>();
 
 public Doctors(){
	 this.doctors.add("Sebastián");
	 this.doctors.add("Paz");
	 this.doctors.add("Arturo");
	 this.doctors.add("Nayib");
	 this.doctors.add("Adrian");
 }
 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctors(){
		if (this.doctors.isEmpty()){
			return Response.noContent().build();
			}else{
				return Response.ok().entity(doctors).build();
			}
		}
		
}
