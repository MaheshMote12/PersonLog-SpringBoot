package com.me.boot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.me.boot.command.AddressCommand;
import com.me.boot.model.Address;

@Mapper(componentModel="Spring")
public interface AddressMapper {
	
//	public AddressCommand addressToAddressCommand(Address address);
	
	public Address addressCommandToAddress(AddressCommand addressCommand);
	
	
}
