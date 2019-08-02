package com.zuzana.expensetrackerbe.models;

public class Summary {
	
	private String title;
	private double value;
	private String type;
	
	public Summary() {
		super();
	}

	public Summary(String title, double value, String type) {
		super();
		this.title = title;
		this.value = value;
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Summary [title=" + title + ", value=" + value + ", type=" + type + "]";
	}
	
	
	
}
