package org.sample.controller.pojos;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class TeamForm {

	private Long id;
	@NotNull
	private String team;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	private Date date;
	
}