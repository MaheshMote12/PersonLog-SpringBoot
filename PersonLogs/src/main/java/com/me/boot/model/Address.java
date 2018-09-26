package com.me.boot.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Address")
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String city;
	
	private String country;
	
	private String state;
	
	private int pinCode;

//	Dates for auditing
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date lastModifiedDate;


	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="person_fkid")
	private Person person;
	

	public Address() {
		super();
	}

	public Address(String city, String country, String state, int pinCode, Person person) {
		super();
		this.city = city;
		this.country = country;
		this.state = state;
		this.pinCode = pinCode;
		this.person = person;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", country=" + country + ", state=" + state + ", pinCode="
				+ pinCode + ", createdDate=" + createdDate + ", lastModifiedDate=" + lastModifiedDate + "]";
	}

	 
	
	
	
	
	
	
	

}
