package com.me.boot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.me.boot.model.Person;
import com.me.boot.repository.AddressRepository;
import com.me.boot.repository.PersonRepository;
import com.me.boot.service.IPersonService;

@Service
public class IPersonServiceImpl implements IPersonService {

	private PersonRepository personRepo;

	private AddressRepository addressRepo;

	public IPersonServiceImpl(PersonRepository personRepo, AddressRepository addressRepo) {
		super();
		this.personRepo = personRepo;
		this.addressRepo = addressRepo;
	}

	@Override
	public Person fingOneById(Long id) {
		
		return null;
	}

	@Override
	public List<Person> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void savePerson(Person person) {

		Person savedPerson = personRepo.save(person);
		if(savedPerson == null) {
//			todo throw exception
		}
		
	}

	@Override
	public void removePerson(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Person update(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

}
