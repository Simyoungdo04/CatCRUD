package com.kh.cat.model.dto;

import java.util.List;

public class CatKeeper {
	private int catKeeperId;
	private String catKeeperName;
	private String catName;
	
	private List<Cat> cats;
	
	public CatKeeper() {}
	public CatKeeper(String catKeeperName) {
		this.catKeeperName = catKeeperName;
	}
	public CatKeeper(String catKeeperName, String catName) {
		this.catKeeperName = catKeeperName;
		this.catName = catName;
	}
	public CatKeeper(int catKeeperId, String catKeeperName) {
		this.catKeeperId = catKeeperId;
		this.catKeeperName = catKeeperName;
	}
	
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
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
	public List<Cat> getCats() {
		return cats;
	}
	public void setCats(List<Cat> cats) {
		this.cats = cats;
	}
	@Override
	public String toString() {
		return "CatKeeper [catKeeperId=" + catKeeperId + ", catKeeperName=" + catKeeperName + ", catName=" + catName
				+ ", cats=" + cats + "]";
	}
	
}
