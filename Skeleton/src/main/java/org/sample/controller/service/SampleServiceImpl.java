package org.sample.controller.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.sample.controller.exceptions.InvalidTeamException;
import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.pojos.TeamForm;
import org.sample.model.Address;
import org.sample.model.Team;
import org.sample.model.User;
import org.sample.model.dao.AddressDao;
import org.sample.model.dao.TeamDao;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service
public class SampleServiceImpl implements SampleService {

    @Autowired    UserDao userDao;
    @Autowired    AddressDao addDao;
    @Autowired	  TeamDao teamDao;
    
    @Transactional
    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException{

        String firstName = signupForm.getFirstName();

        if(!StringUtils.isEmpty(firstName) && "ESE".equalsIgnoreCase(firstName)) {
            throw new InvalidUserException("Sorry, ESE is not a valid name");   // throw exception
        }


        Address address = new Address();
        address.setStreet("TestStreet-foo");
        
        User user = new User();
        user.setFirstName(signupForm.getFirstName());
        user.setEmail(signupForm.getEmail());
        user.setLastName(signupForm.getLastName());
        user.setAddress(address);
        
        user = userDao.save(user);   // save object to DB
        
        
        // Iterable<Address> addresses = addDao.findAll();  // find all 
        // Address anAddress = addDao.findOne((long)3); // find by ID
        
        
        signupForm.setId(user.getId());

        return signupForm;

    }

    @Transactional
	public TeamForm saveFrom(TeamForm teamForm) throws InvalidTeamException {
    	String teamName = teamForm.getTeamName();

        if(!StringUtils.isEmpty(teamName) && "ESE".equalsIgnoreCase(teamName)) {
            throw new InvalidUserException("Sorry, ESE is not a valid team name");
        }
        Team team = new Team();
        team.setTeamName(teamForm.getTeamName());
        team.setDate(teamForm.getDate());
        
        team = teamDao.save(team);
        
        teamForm.setId(team.getId());
        
		return teamForm;
		
	}

	public User getUserById(long id) {
		return userDao.findOne(id);
	}

	public ArrayList<Team> getTeamList() {
		Iterator<Team> count = teamDao.findAll().iterator();
		ArrayList<Team> listOfTeams = new ArrayList<Team>();
		while(count.hasNext()){
			listOfTeams.add(count.next());
		}
		return listOfTeams;
	}
}
