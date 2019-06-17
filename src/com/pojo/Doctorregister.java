package com.pojo;

// Generated Jun 12, 2018 3:28:23 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Doctorregister generated by hbm2java
 */
public class Doctorregister implements java.io.Serializable {

	private Integer did;
	private Role role;
	private String fname;
	private String lname;
	private String specilization;
	private String email;
	private String password;
	private String degree;
	private String gender;
	private String address;
	private String phoneno;
	private Set applydoctors = new HashSet(0);

	public Doctorregister() {
	}

	public Doctorregister(Role role, String fname, String lname, String specilization, String email, String password,
			String degree, String gender, String address, String phoneno, Set applydoctors) {
		this.role = role;
		this.fname = fname;
		this.lname = lname;
		this.specilization = specilization;
		this.email = email;
		this.password = password;
		this.degree = degree;
		this.gender = gender;
		this.address = address;
		this.phoneno = phoneno;
		this.applydoctors = applydoctors;
	}

	public Integer getDid() {
		return this.did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getSpecilization() {
		return this.specilization;
	}

	public void setSpecilization(String specilization) {
		this.specilization = specilization;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneno() {
		return this.phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public Set getApplydoctors() {
		return this.applydoctors;
	}

	public void setApplydoctors(Set applydoctors) {
		this.applydoctors = applydoctors;
	}

}