package dev.project.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name="medication")
public class Medication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medi_id")
	private int mediID;
	
	private String name;
	private boolean status;
	private String frequency;
	private String startDate;

	// mappings
	@ManyToOne
	@JoinColumn(name = "record_id")
	PatientRecord medicationRecord;

	public int getMediID() {
		return mediID;
	}
	public void setMediID(int mediID) {
		this.mediID = mediID;
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
