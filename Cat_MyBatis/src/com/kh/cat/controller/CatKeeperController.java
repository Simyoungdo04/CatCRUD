package com.kh.cat.controller;

import java.util.List;
import java.util.Map;

import com.kh.cat.model.dto.CatKeeper;
import com.kh.cat.model.service.CatKeeperService;

public class CatKeeperController {
	private CatKeeperService catKeeperService = new CatKeeperService();	
	
	public int saveCatKeeper(String name) {
		return catKeeperService.saveCatKeeper(name);
	}
	
	public List<CatKeeper> findAllCatKeeper() {
		return catKeeperService.findAllCatKeeper();
	}
	
	public List<CatKeeper> findCatAndCatKeeper(Map<String, String> args){
		return catKeeperService.findCatAndCatKeeper(args);
	}
	
}
