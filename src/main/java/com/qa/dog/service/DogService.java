package com.qa.dog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.qa.dog.domain.Dog;

@Service 
public class DogService {

	private List<Dog> dogs = new ArrayList<>();

	public Dog createDog(Dog dogs) {
		this.dogs.add(dogs);
		Dog created = this.dogs.get(this.dogs.size() - 1);
		return created;
	} 

	public List<Dog> getAllDogs() {
		return this.dogs;
	}

	public Dog getDog(Integer id) {
		return this.dogs.get(id);
	}

//	public Dog getDogName(Integer name) {
//		return this.dogs.get(name);
//	}
	
	public Dog replaceDog(Integer id, Dog newDog) {
		Dog found = this.dogs.set(id, newDog);

		return found;
	}
	
	//do we need pathvariable?
	public void removeDog(@PathVariable Integer id) {
		this.dogs.remove(id.intValue());
	}
	
	
}
