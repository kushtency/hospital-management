package dev.project.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name="vital")
public class Vital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vitalID;
	private String dob;
	private int bp;
	private int hr;
	private int rr;
	private int temperature;
	private int spo2;
	private int height;
	private int weight;
	private double BMI;

	// mappings
	@ManyToOne
	@JoinColumn(name = "record_id")
	PatientRecord vitalRecord;

	public int getVitalID() {
		return vitalID;
	}

	public void setVitalID(int vitalID) {
		this.vitalID = vitalID;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getBp() {
		return bp;
	}

	public void setBp(int bp) {
		this.bp = bp;
	}

	public int getHr() {
		return hr;
	}

	public void setHr(int hr) {
		this.hr = hr;
	}

	public int getRr() {
		return rr;
	}

	public void setRr(int rr) {
		this.rr = rr;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getSpo2() {
		return spo2;
	}

	public void setSpo2(int spo2) {
		this.spo2 = spo2;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public double getBMI() {
		return BMI;
	}

	public void setBMI(double bMI) {
		BMI = bMI;
	}

}
