package org.tec.ce.MediTEC.resources;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;

@Path("/docs")
public class Doctors {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getDoctors(){
		return Response.ok().entity("Sebas").build();
	}
}
