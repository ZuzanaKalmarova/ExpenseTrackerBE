package com.zuzana.expensetrackerbe.models;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Expense {
	
	@Id
	@GeneratedValue
	private int id;
	private String description;
	@ManyToOne
	private Category category;
	private double amount;
	
	private LocalDate date;
	
	public Expense() {
		super();
	}

	public Expense(int id, String description, Category category, double amount, LocalDate date) {
		super();
		this.id = id;
		this.description = description;
		this.category = category;
		this.amount = amount;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", description=" + description + ", category=" + category + ", amount=" + amount
				+ ", date=" + date + "]";
	}
	
	
	
	

}
