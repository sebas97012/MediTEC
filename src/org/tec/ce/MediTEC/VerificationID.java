package org.tec.ce.MediTEC;

public class VerificationID implements Comparable<VerificationID>{
	private int id;
	private int idPatientDTO;

	public VerificationID(int id, int idPatientDTO) {
		this.id = id;
		this.idPatientDTO = idPatientDTO;
	}

	public void setId(int iD) {
		id = iD;
	}

	public void setIdPatientDTO(int idPatientDTO) {
		this.idPatientDTO = idPatientDTO;
	}

	public int getId() {
		return id;
	}

	public int getIdPatientDTO() {
		return idPatientDTO;
	}

	@Override
	public int compareTo(VerificationID arg0) {
		if(this.idPatientDTO > arg0.getIdPatientDTO()){
			return 1;
		} else if(this.idPatientDTO < arg0.getIdPatientDTO()){
			return -1;
		} else{
			return 0;
		}
	}
}
