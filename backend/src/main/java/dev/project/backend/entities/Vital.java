package dev.project.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="vital")
public class Vital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vital_id;
	private String dob;
	private int bp;
	private int hr;
	private int rr;
	private int temperature;
	private int spo2;
	private int height;
	private int weight;
	private double BMI;

	public int getVital_id() {
		return vital_id;
	}

	public void setVital_id(int vital_id) {
		this.vital_id = vital_id;
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
