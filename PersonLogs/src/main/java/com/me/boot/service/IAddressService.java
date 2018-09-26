package com.me.boot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.me.boot.command.AddressCommand;
import com.me.boot.model.Address;
import com.me.boot.model.Person;

public interface IAddressService {
	
	Address fingOneById(Long id);
	
	List<Address> findById(Long id);
	
	List<Address> findAll();
	
	void saveAddress(Long personId, AddressCommand addressCommand);
	
	void removeAddress(Long id);
	
	Person update(Address person);
	
	Page<Address> findAll(Pageable pageable);
	

}
