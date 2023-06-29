package dev.project.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Medication {
	
	@Id
	@GeneratedValue(generator = "medi_seq")
	@SequenceGenerator(name="medi_seq",initialValue = 1,allocationSize = 1)
	private int medi_id;
	
	private String name;
	private boolean status;
	private String frequency;
	private String startDate;
	public int getMedi_id() {
		return medi_id;
	}
	public void setMedi_id(int medi_id) {
		this.medi_id = medi_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
}
