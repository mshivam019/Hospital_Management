package com.springboot.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Doctor {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer patient_id;
	  
    public String p_name;

    public String phno;

    public String email;
    
    public String status;

	public Integer getpatientId() {
		return patient_id;
	}

	public void setpatientId(Integer patient_id) {
		this.patient_id = patient_id;
	}

	public String getpName() {
		return p_name;
	}

	public void setpName(String p_name) {
		this.p_name = p_name;
	}

	public String getphno() {
		return phno;
	}

	public void setphno(String phno) {
		this.phno = phno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getstatus() {
		return status;
	}

	public void setstatus(String status) {
		this.status = status;
	}
}
