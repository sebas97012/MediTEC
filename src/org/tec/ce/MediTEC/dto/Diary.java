package org.tec.ce.MediTEC.dto;


import java.util.StringTokenizer;

public class Diary implements Comparable<Diary> {
	
	private int id;
	private Appointment appointment;
	private String date;
	private String hour;
	
	public Diary(){
		
	}
	
	public Diary(Appointment appointment){
		this.id = appointment.getId();
		this.appointment = appointment;
		this.date = appointment.getDate();
		this.hour = appointment.getHour();
	}
	
	public int getDay(){
		StringTokenizer st = new StringTokenizer(this.date,"/");		 
		int day = Integer.parseInt(st.nextToken());
		return day;
	}
	
	public int getMonth(){
		StringTokenizer st = new StringTokenizer(this.date,"/");
		st.nextToken();
		int month = Integer.parseInt(st.nextToken());
		return month;
	}
	
	public int getYear(){
		StringTokenizer st = new StringTokenizer(this.date,"/");
		st.nextToken();
		st.nextToken();
		int year = Integer.parseInt(st.nextToken());
		return year;
	}
	
	public String getHour() {
		return hour;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public int getId() {
		return id;
	}

	public int compareTo(Diary arg0) {
		if(this.id > arg0.getId()){
			return 1;
		} else if(this.id < arg0.getId()){
			return -1;
		} else{
			return 0;
		}
	}



}
