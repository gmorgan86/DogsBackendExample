package com.qa.dog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.dog.domain.Dog;

@Repository
public interface DogRepo extends JpaRepository<Dog, Integer>  {

	//Spring will auto-generate all of the basic CRUD functionality
}
