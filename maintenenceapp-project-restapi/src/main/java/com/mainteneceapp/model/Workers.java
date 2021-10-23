package com.mainteneceapp.model;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ManikantaJV
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
/**
 * 
 * @author ManikantaJV
 *
 */
public class Workers {
	@Id
	@GeneratedValue(generator = "resources_gene", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "resources_gene", sequenceName = "resources_seq", allocationSize = 1, initialValue = 1)
	private Integer resourceId;
	@Column(length = 40)
	private String resourceName;
	@Column(length = 40)
	private String resourceType;
	private LocalDate Resourcesavailablefrom;
	@Enumerated(EnumType.STRING)
	private Available availability;
	@ManyToOne
	@JoinColumn(name = "task_id")
	@JsonIgnore
	private Task task;

	public Workers(String resourceName, String resourceType, LocalDate resourcesavailablefrom) {
		super();
		this.resourceName = resourceName;
		this.resourceType = resourceType;
		Resourcesavailablefrom = resourcesavailablefrom;
	}

	@Override
	public String toString() {
		return "Workers [resourceName=" + resourceName + ", resourceType=" + resourceType + ", Resourcesavailablefrom="
				+ Resourcesavailablefrom + "," + availability +"= availability "+ "]";
	}
	
	
}