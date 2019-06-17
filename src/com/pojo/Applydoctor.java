package com.pojo;

// Generated Jun 12, 2018 3:28:23 PM by Hibernate Tools 3.4.0.CR1

/**
 * Applydoctor generated by hbm2java
 */
public class Applydoctor implements java.io.Serializable {

	private Integer applicationId;
	private Doctorregister doctorregister;
	private Patientregister patientregister;
	private String typeofproblem;
	private String symptoms;
	private Integer doctor_id;
	private Integer patien_id;

	public Applydoctor() {
	}

	public Applydoctor(Doctorregister doctorregister, Patientregister patientregister, String typeofproblem,
			String symptoms,Integer doctor_id,Integer patient_id) {
		this.doctorregister = doctorregister;
		this.patientregister = patientregister;
		this.typeofproblem = typeofproblem;
		this.symptoms = symptoms;
		this.doctor_id=doctor_id;
		this.patien_id=patient_id;
	}

	public Integer getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(Integer doctor_id) {
		this.doctor_id = doctor_id;
	}

	public Integer getPatien_id() {
		return patien_id;
	}

	public void setPatien_id(Integer patien_id) {
		this.patien_id = patien_id;
	}

	public Integer getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public Doctorregister getDoctorregister() {
		return this.doctorregister;
	}

	public void setDoctorregister(Doctorregister doctorregister) {
		this.doctorregister = doctorregister;
	}

	public Patientregister getPatientregister() {
		return this.patientregister;
	}

	public void setPatientregister(Patientregister patientregister) {
		this.patientregister = patientregister;
	}

	public String getTypeofproblem() {
		return this.typeofproblem;
	}

	public void setTypeofproblem(String typeofproblem) {
		this.typeofproblem = typeofproblem;
	}

	public String getSymptoms() {
		return this.symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

}