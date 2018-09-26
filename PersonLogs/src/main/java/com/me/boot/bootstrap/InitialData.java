package com.me.boot.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.me.boot.model.Address;
import com.me.boot.model.Person;
import com.me.boot.service.IPersonService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InitialData implements CommandLineRunner{

	private IPersonService personService;
	
	public InitialData(IPersonService personService) {
		super();
		this.personService = personService;
	}


	@Override
	public void run(String... args) throws Exception {

		log.info("Saving Person from CommandlineRunner..");
		
		
		Address adr1 = new Address();
		adr1.setCity("LA");
		adr1.setCountry("USA");
		adr1.setPinCode(412544);
		adr1.setState("Miamo");
		
		Address adr2 = new Address();
		adr2.setCity("LA");
		adr2.setCountry("USA");
		adr2.setPinCode(412544);
		adr2.setState("Miamo");
		
		Person person = new Person();
		person.setEmail("mahesh.mote44@gmail.com");
		person.setFirstName("Mahesh");
		person.setLastName("Mote");
		person.setMobile(7709575441l);
		person.setOrgName("Fludiqs India Pvt. Ltd.");
		person.addAddress(adr1);
		person.addAddress(adr2);
		
		personService.savePerson(person);
		
		log.info("Person saved..");
		
	}

}
