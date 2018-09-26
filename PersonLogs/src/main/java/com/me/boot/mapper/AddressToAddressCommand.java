package com.me.boot.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.me.boot.command.AddressCommand;
import com.me.boot.model.Address;

@Component
public class AddressToAddressCommand implements Converter<Address, AddressCommand> {

	@Override
	public AddressCommand convert(Address address) {

		  if ( address == null ) {
	            return null;
	        }

	        AddressCommand addressCommand = new AddressCommand();

	        addressCommand.setId( address.getId() );
	        addressCommand.setCity( address.getCity() );
	        addressCommand.setCountry( address.getCountry() );
	        addressCommand.setState( address.getState() );
	        addressCommand.setPinCode( address.getPinCode() );
	        addressCommand.setPid(address.getPerson().getPid());

	        return addressCommand;
		
	}

}
