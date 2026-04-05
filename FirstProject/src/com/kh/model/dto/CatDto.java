package com.kh.model.dto;

public class CatDto {
	private int catId;
	private String name;
	private String color;
	private double weight;
	private String personality;
	private String birth;
	
	public CatDto(String name, String color, double weight, String personality) {
		this.name = name;
		this.color = color;
		this.weight = weight;
		this.personality = personality;
	}
	
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getPersonality() {
		return personality;
	}
	public void setPersonality(String personality) {
		this.personality = personality;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
}
