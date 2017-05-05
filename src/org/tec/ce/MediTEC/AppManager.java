package org.tec.ce.MediTEC;

import org.glassfish.jersey.server.ResourceConfig;
import org.tec.ce.MediTEC.resources.Doctors;

public class AppManager extends ResourceConfig {
	public AppManager(){
		register(Doctors.class);
		System.out.print("hola");
	}

}//probando
