package com.me.boot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.me.boot.model.Person;

public interface IPersonService {
	
	Person fingOneById(Long id);
	
	Person findById(Long id);
	
	List<Person> findAll();
	
	void savePerson(Person person);
	
	void removePerson(Long id);
	
	Person update(Person person);
	
	Page findAll(Pageable pageable);
	
	
	
	

}
