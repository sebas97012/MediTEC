package org.tec.ce.MediTEC;

import org.glassfish.jersey.server.ResourceConfig;
import org.tec.ce.MediTEC.resources.Doctors;

public class AppManager extends ResourceConfig {
	//hola
	public AppManager(){
		register(Doctors.class);
		System.out.print("hola");
	}

}
