package com.me.boot.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.me.boot.command.AddressCommand;
import com.me.boot.mapper.AddressMapper;
import com.me.boot.mapper.AddressToAddressCommand;
import com.me.boot.model.Address;
import com.me.boot.model.Person;
import com.me.boot.repository.AddressRepository;
import com.me.boot.repository.PersonRepository;
import com.me.boot.service.IAddressService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class IAddressServiceImpl implements IAddressService {

	private AddressRepository addrRepo;
	
	private PersonRepository personRepo;

	private AddressToAddressCommand toAdrCommand;
 
	private AddressMapper adrMapper;
	
 
	public IAddressServiceImpl(AddressRepository addrRepo, PersonRepository personRepo,
			AddressToAddressCommand toAdrCommand, AddressMapper adrMapper) {
		super();
		this.addrRepo = addrRepo;
		this.personRepo = personRepo;
		this.toAdrCommand = toAdrCommand;
		this.adrMapper = adrMapper;
	}

	@Override
	public List<Address> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAddress(Long personId, AddressCommand addressCommand) {

		Person person = personRepo.findOne(addressCommand.getPid());
		
		person.addAddress(adrMapper.addressCommandToAddress(addressCommand) );
		
		Person savedPerson = personRepo.save(person);
		
		if(savedPerson == null) {
			log.error("Person not saved");
		}
		
	}

	@Override
	public void removeAddress(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Person update(Address person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Address> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address fingOneById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
