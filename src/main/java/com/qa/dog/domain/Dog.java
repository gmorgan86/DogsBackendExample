package com.qa.dog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity //flags class as a table to Spring data

public class Dog {

	@Id  //need to state the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //makes auto increment
	private Integer id;
	
	private String name;
	
	@Column(nullable = false) //makes 'not null'
	private String diet;
	
	@Column(unique = true) //has to have a unique value
	private Integer numTeeth;
	
	private String type;
	
	private Integer weight;
	
	
	public Dog() {
		super();
	}


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public Integer getNumTeeth() {
		return numTeeth;
	}

	public void setNumTeeth(Integer numTeeth) {
		this.numTeeth = numTeeth;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}



	@Override
	public String toString() {
		return "Dog [diet=" + diet + ", numTeeth=" + numTeeth + ", type=" + type + ", weight=" + weight + "]";
	}
	
	
	
}
