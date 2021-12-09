package com.qa.dog.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dog.domain.Dog;
import com.qa.dog.service.DogService;

// tells Spring this is a controller
@RestController // REST compliant
public class DogController {

	private DogService service;

	// tells Spring to fetch the DinoService from the context
	// Dependency Injection

	@Autowired
	public DogController(DogService service) {
		super();
		this.service = service;
	}

	@GetMapping("/helloWorld") // end point
	public String hello() {
		return "Hello to the World!";
	}

	@PostMapping("/create") // 201
	public ResponseEntity<Dog> createDog(@RequestBody Dog dog) {
		Dog created = this.service.createDog(dog);
		ResponseEntity<Dog> response = new ResponseEntity<Dog>(created, HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/getALL") // 200 //works
	public ResponseEntity<List<Dog>> getAllDogs() {
		return ResponseEntity.ok(this.service.getAllDogs());
	}

	@GetMapping("/getByID/{id}") // works
	public Dog getDog(@PathVariable Integer id) {
		return this.service.getDog(id);
	}

//	@GetMapping("/getByName/{id}")
//	public Dog getDogName(@PathVariable String  name) {
//		System.out.println("Name: " + name);
//		for (Dog doggo : dogs) {
//			if(doggo.getName() == name) {
//				System.out.println("Dog: " + doggo.toString());
//				return doggo;
//			}
//		}
//		return null;
//	}

//	@GetMapping("/getByName/{id}")
//	public Dog getDogName(@PathVariable Integer  id) {
////		System.out.println("ID:" + id);
//		return this.service.getDog(id);
//		
//	}
//	

	@PutMapping("/replace/{id}") // 202 - Accepted
	public ResponseEntity<Dog> replaceDog(@PathVariable Integer id, @RequestBody Dog newDog) {
		Dog body = this.service.replaceDog(id, newDog);

		ResponseEntity<Dog> response = new ResponseEntity<Dog>(body, HttpStatus.ACCEPTED);
		return response;
	}

//	@PutMapping("/replace/{id}") //202
//	public Dog replaceDog(@PathVariable Integer id, @RequestBody Dog newDog) {
//		System.out.println("ID: " + id);
//		System.out.println("Dog: " + newDog);
//		dogs.remove(id.intValue());
//		this.dogs.add(id, newDog);
//		return this.dogs.get(id);
//	}

//	@PutMapping("/replace1/{id}") //202
//	public ResponseEntity<Dog> replaceDog1(@PathVariable Integer id, @RequestBody Dog newDog) {
//		Dog body = this.dogs.set(index: id, element: newDog)
//		
//		ResponseEntity<Dog> response =new ResponseEntity<Dog>(body, HttpStatus.ACCEPTED);
//
//		return response;
//	}
	@DeleteMapping("/remove/{id}") // 204 
	public ResponseEntity<?> removeDog(@PathVariable Integer id) {
		this.service.removeDog(id.intValue());

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

//	@DeleteMapping("/remove/{id}") //204  //works
//	public ResponseEntity<Dog> removeDog(@PathVariable Integer id) {
//		System.out.println("ID: " + id);
//		ResponseEntity<Dog> response = new ResponseEntity<Dog>(HttpStatus.NO_CONTENT);
//		dogs.remove(id.intValue());
//		return response;
//	}
//	
//	@DeleteMapping("/remove1/{id}") //204  //works ???
//	public ResponseEntity<Dog> removeDog1(@PathVariable Integer id) {
//		
//		this.dogs.remove(id.intValue());
//		return new ResponseEntity<Dog>(HttpStatus.NO_CONTENT);
//	}
//	
}
