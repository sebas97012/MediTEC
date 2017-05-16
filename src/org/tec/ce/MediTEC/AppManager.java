package org.tec.ce.MediTEC;

import org.glassfish.jersey.server.ResourceConfig;
import org.tec.ce.MediTEC.resources.Doctors;
import org.tec.ce.MediTEC.resources.Patients;

public class AppManager extends ResourceConfig {
	public AppManager(){
		register(Doctors.class);
		register(Patients.class);
	}
}
