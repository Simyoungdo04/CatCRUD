package com.kh.cat.controller;

import java.util.List;

import com.kh.cat.model.dto.Cat;
import com.kh.cat.model.service.CatService;

public class CatController {
	private CatService catService = new CatService();
	
	public int saveCat(Cat cat) {
		return catService.saveCat(cat);
	}
	
	public List<Cat> findAll(){
		return catService.findAll();
	}
	
	public Cat findById(String catId) {
		return catService.findById(catId);
	}
	
	public List<Cat> findByKeyword(String keyword){
		return catService.findByKeyword(keyword);
	}
	
	public int updateCat(Cat cat) {
		return catService.updateCat(cat);
	}
	
	public int setCatKeeper(Cat cat) {
		return catService.setCatkeeper(cat);
	}
	
	public int deleteCat(String id) {
		return catService.deleteCat(id);
	}
	
}
