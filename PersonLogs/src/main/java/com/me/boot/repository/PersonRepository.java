package com.me.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.me.boot.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
