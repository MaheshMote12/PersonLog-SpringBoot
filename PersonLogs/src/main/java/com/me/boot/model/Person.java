package com.me.boot.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Person")
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long pid;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String orgName;
	
	private int mobile;

	
//	Dates for auditing
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date lastModifiedDate;
	
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="person")
/*	@JoinTable(name="person_address", joinColumns=@JoinColumn(name="personId"),
				inverseJoinColumns=@JoinColumn(name="addressId"))
*/	private List<Address> addr = new ArrayList<>();
	
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
//	Handy Utility methods
	public void addAddress(Address address) {
		this.addr.add(address);
		address.setPerson(this);
	}
	
	public void removeAddress(Address address) {
		
		this.addr.remove(address);
		address.setPerson(null);
	}


	public Person(String firstName, String lastName, String email, String orgName, int mobile, List<Address> addr) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.orgName = orgName;
		this.mobile = mobile;
		this.addr = addr;
	}


	@Override
	public String toString() {
		return "Person [pid=" + pid + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", orgName=" + orgName + ", mobile=" + mobile + ", createdDate=" + createdDate + ", lastModifiedDate="
				+ lastModifiedDate + "]";
	}


	
	
		
	
	
}
