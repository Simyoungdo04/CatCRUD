package com.kh.controller;

import java.util.List;

import com.kh.model.dto.CatDto;
import com.kh.model.service.CatService;
import com.kh.model.vo.Cat;

public class CatController {
	private CatService cs = new CatService();
	
	public void createCat(CatDto cat) {
		cs.createCat(cat);
	}
	
	public List<Cat> findAll() {
		return cs.findAll();
	}
	
	public Cat findById(int catNum) {
		return cs.findById(catNum);
	}
	
	public Cat updateCat(int catNum, CatDto cat) {
		return cs.updateCat(catNum, cat);
	}
	
	public int deleteCat(int catNum) {
		return cs.deleteCat(catNum);
	}
}
