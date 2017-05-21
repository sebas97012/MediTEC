package org.tec.ce.MediTEC;

import org.glassfish.jersey.server.ResourceConfig;
import org.tec.ce.MediTEC.resources.Doctors;
import org.tec.ce.MediTEC.resources.IDGenerator;
import org.tec.ce.MediTEC.resources.Patients;
import org.tec.ce.MediTEC.resources.SearchCoincidence;

public class AppManager extends ResourceConfig {
	public AppManager(){
		register(Doctors.class);
		register(Patients.class);
		register(IDGenerator.class);
		register(SearchCoincidence.class);
	}
}
