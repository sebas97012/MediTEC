package org.tec.ce.MediTEC.dto;

 
public class MessageDTO implements Comparable<MessageDTO> {
	  
	private String message;
	private int id;

	
	public MessageDTO (String message, int id){
		this.message = message;
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(MessageDTO arg0) {
		if(this.id > arg0.getId()){
			return 1;
		} else if(this.id < arg0.getId()){
			return -1;
		} else{
			return 0;
		}
	}
}
