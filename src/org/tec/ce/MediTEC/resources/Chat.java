package org.tec.ce.MediTEC.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.tec.ce.DataStructures.LinkedList.LinkedList;
import org.tec.ce.MediTEC.dto.MessageDTO;
 
@Path("/chat")
public class Chat {
	private static LinkedList<MessageDTO> chat = new LinkedList<MessageDTO>();
	 
	public Chat(){
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getChat(){
		return Response.ok().entity(getChat()).build();
	}
	
	@PUT 
	@Consumes (MediaType.APPLICATION_JSON)
	public Response insertMessage(MessageDTO message){
		chat.insertAtEnd(message);
		return Response.ok().build();
	}
}
