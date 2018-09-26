package com.me.boot.service;

import java.util.List;

import com.me.boot.model.Person;

public interface IPersonService {
	
	Person fingOneById(Long id);
	
	List<Person> findById(Long id);
	
	List<Person> findAll();
	
	void savePerson(Person person);
	
	void removePerson(Long id);
	
	Person update(Person person);
	
	
	
	
	

}
