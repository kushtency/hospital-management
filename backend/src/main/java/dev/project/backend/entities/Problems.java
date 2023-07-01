package dev.project.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name="problems")
public class Problems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "problem_id")
	private int problemID;
	
	private String name;
	private String status;
	private String startDate;

	// mapping
	@ManyToOne
	@JoinColumn(name = "record_id")
	PatientRecord problemRecord;
	
	public int getProblemID() {
		return problemID;
	}
	public void setProblem_id(int problemID) {
		this.problemID = problemID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	
}
