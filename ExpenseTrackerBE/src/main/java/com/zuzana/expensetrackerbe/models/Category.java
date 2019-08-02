package com.zuzana.expensetrackerbe.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	private double budget;
	
	public Category() {
		super();
	}

	public Category(int id, String name, String description, double budget) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.budget = budget;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", budget=" + budget + "]";
	}
	
	

}
