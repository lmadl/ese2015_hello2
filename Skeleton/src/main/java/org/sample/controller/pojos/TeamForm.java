package org.sample.controller.pojos;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;


public class TeamForm {

    private Long id;
    @NotNull
    private String teamName;
    private String date;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getDate() {
    	setDate( getCurrentTimestamp() );
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    private String getCurrentTimestamp(){
    	Date date = new Date();
   	 	return new Timestamp(date.getTime()).toString();
    }
}