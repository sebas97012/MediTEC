package org.tec.ce.MediTEC.resources;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.tec.ce.DataStructures.BinaryTree.BinaryTree;
import org.tec.ce.DataStructures.LinkedList.LinkedList;
import org.tec.ce.DataStructures.SplayTree.SplayTree;
import org.tec.ce.MediTEC.CreateQRCode;
import org.tec.ce.MediTEC.EmailSenderService;
import org.tec.ce.MediTEC.FileXMLManager;
import org.tec.ce.MediTEC.Random;
import org.tec.ce.MediTEC.dto.ID;
import org.tec.ce.MediTEC.dto.PatientDTO;
import org.tec.ce.MediTEC.VerificationID;

@Path("/registration")
public class RegistrateUser {
	private static SplayTree<VerificationID> listaVerificacion = new SplayTree<VerificationID>();
	
	public RegistrateUser(){
		 try {
			if(FileXMLManager.checkExistence("listaVerificacion.xml") == true){
				 this.listaVerificacion = (SplayTree) FileXMLManager.getContent("listaVerificacion.xml");
			 } else{
				 this.listaVerificacion = new SplayTree<VerificationID>();
				 FileXMLManager.writeContent(this.listaVerificacion, "listaVerificacion.xml");
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	@POST
	@Path("/addToVerificationList")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addToVerificationList(PatientDTO newPatient){
		if(newPatient != null){
			VerificationID verificationID = new VerificationID(0, newPatient.getIdentificationNumber());
			if(listaVerificacion.contains(verificationID) == false){	
				int verificationNumber = Random.getRamdomNumber(1000, 9999);
				listaVerificacion.insert(new VerificationID(verificationNumber, newPatient.getIdentificationNumber()));
				
				CreateQRCode.CreateQRCode(String.valueOf(verificationNumber));
				EmailSenderService.sendEmail(newPatient.getEmail(), "Codigo de verificación MediTEC", "Escanee el QR Code adjunto para completar el proceso de registro de "
						+ "su usuario en MediTEC", "qrcode.png");
			}
		}
	}
	
	@GET
	@Path("{patient}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVerificationCode(@PathParam("patient") PatientDTO patient){
		if(patient != null){
			VerificationID searchID = new VerificationID(0, patient.getIdentificationNumber());
			VerificationID id1 = (VerificationID) listaVerificacion.search(searchID).getData();
			return Response.ok().entity(id1).build();
		} else{
			return Response.status(400).build();
		}
	}
	
	@POST
	@Path("/registrate")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registrateUser(PatientDTO newPatient){
		if(newPatient != null){
			Patients.patientsTree.insert(newPatient);
			Patients.updatePatientsTree();
			return Response.ok().build();
		} else{
			return Response.status(400).build();
		}
	}
}
