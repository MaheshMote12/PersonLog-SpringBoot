package com.me.boot.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.me.boot.model.Person;
import com.me.boot.repository.AddressRepository;
import com.me.boot.repository.PersonRepository;
import com.me.boot.service.IPersonService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
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
		
		Person person = personRepo.findOne(id);
		if(person == null) {
			System.out.println("exception");
//			throw exception here
		}

		return person;
	}

	@Override
	public Person findById(Long id) {

		Person person = personRepo.findOne(id);
		if(person == null) {
//			todo address this
			log.error("Person not found");
		}
		return person;
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

	@Override
	public Page<Person> findAll(Pageable pageable) {

		return personRepo.findAll(pageable);
		
	}

}
