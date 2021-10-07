package com.mainteneceapp.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Maintenence {

	@Id
	@GeneratedValue(generator = "project_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "project_gen", sequenceName = "project_seq", allocationSize = 1, initialValue = 1)
	private Integer projectId;
	@Column(length = 30)
	private String projectName;
	@Column(length = 30)
	private String projectOwner;
	private LocalDate projectStartDate;
	private LocalDate projectEndDate;
	@Column(length = 30)
	private Priority projectPriority;
	@Column(length = 30)
	private Status projectStatus;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "maintenence")
	private Set<Task> taskList;
	
	@ManyToOne
	@JoinColumn(name="trip_id")
	private Trip trip;
	
	public Maintenence(String projectName, String projectOwner, LocalDate projectStartDate, LocalDate projectEndDate,
			Priority projectPriority, Status projectStatus) {
		super();
		this.projectName = projectName;
		this.projectOwner = projectOwner;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
		this.projectPriority = projectPriority;
		this.projectStatus = projectStatus;
	}

	@Override
	public String toString() {
		return "Maintenence [projectName=" + projectName + ", projectOwner=" + projectOwner + ", projectStartDate="
				+ projectStartDate + ", projectEndDate=" + projectEndDate + ", projectPriority=" + projectPriority
				+ ", projectStatus=" + projectStatus + "]";
	}
	
	
	
	
}