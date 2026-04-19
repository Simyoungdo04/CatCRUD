package com.kh.cat.model.dto;

import java.sql.Date;

public class Cat {
	private int catId;
	private String catName;
	private String catGender;
	private double catWeight;
	private Date catBirth;
	private int catKeeperId;
	private String catKeeperName;
	
	public Cat() {}
	public Cat(String catName, String catGender, double catWeight) {
		this.catName = catName;
		this.catGender = catGender;
		this.catWeight = catWeight;
	}
	public Cat(int catId, String catName, String catGender, double catWeight, Date catBirth, int catKeeperId,
			String catKeeperName) {
		this.catId = catId;
		this.catName = catName;
		this.catGender = catGender;
		this.catWeight = catWeight;
		this.catBirth = catBirth;
		this.catKeeperId = catKeeperId;
		this.catKeeperName = catKeeperName;
	}
	
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getCatGender() {
		return catGender;
	}
	public void setCatGender(String catGender) {
		this.catGender = catGender;
	}
	public double getCatWeight() {
		return catWeight;
	}
	public void setCatWeight(double catWeight) {
		this.catWeight = catWeight;
	}
	public Date getCatBirth() {
		return catBirth;
	}
	public void setCatBirth(Date catBirth) {
		this.catBirth = catBirth;
	}
	public int getCatKeeperId() {
		return catKeeperId;
	}
	public void setCatKeeperId(int catKeeperId) {
		this.catKeeperId = catKeeperId;
	}
	public String getCatKeeperName() {
		return catKeeperName;
	}
	public void setCatKeeperName(String catKeeperName) {
		this.catKeeperName = catKeeperName;
	}
}
