package com.Suresh.DAO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.Suresh.DTO.User;

@Service
public class Database {

	public List<User> getAllUsers() {
		return Stream.of(new User(1,"suresh","sureshy@hcl.com","good"),
				  new User(1,"naresh","sushy@hcl.com","hda"),
				  new User(1,"nsresh","ureshy@hcl.com","sdf"),
				  new User(1,"uwuresh","reshy@hcl.com","rte"),
				  new User(1,"woresh","asdsureshy@hcl.com","yyu"))
		.collect(Collectors.toList());
	}
	
	public long getUserStatusCountByStatus(String status){
	       return getAllUsers().stream().filter(user -> user.getStatus().equals(status)).count();
	    }
}
