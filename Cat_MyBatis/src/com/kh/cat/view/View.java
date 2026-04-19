package com.kh.cat.view;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.kh.cat.controller.CatController;
import com.kh.cat.controller.CatKeeperController;
import com.kh.cat.model.dto.Cat;
import com.kh.cat.model.dto.CatKeeper;

public class View {
	private Scanner sc = new Scanner(System.in);
	private CatController catController = new CatController();
	private CatKeeperController catKeeperController = new CatKeeperController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("메인 메뉴");
			System.out.println("1. 고양이 생성하기");
			System.out.println("2. 고양이 전체조회");
			System.out.println("3. 고양이 단일조회하기");
			System.out.println("4. 고양이 이름 키워드 하기");
			System.out.println("5. 고양이 정보 수정하기");
			System.out.println("6. 집사 고르기");
			System.out.println("7. 고양이 삭제하기");
			System.out.println("8. 집사 관리 메뉴");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 선택 > ");
			String menu = sc.nextLine();
			
			switch(menu) {
			case "1" : saveCat(); break;
			case "2" : findAll(); break;
			case "3" : findById(); break;
			case "4" : findByKeyword(); break;
			case "5" : updateCat(); break;
			case "6" : setCatKeeper(); break;
			case "7" : deleteCat(); break;
			case "8" : catKeeperMenu(); break;
			case "0" : System.out.println("프로그램 종료"); sc.close(); return;
			default : System.out.println("없는 메뉴입니다.");
			}
		}
	}
	
	public void catKeeperMenu() {
		while(true) {
			System.out.println("집사 관리 메뉴");
			System.out.println("1. 집사 생성하기");
			System.out.println("2. 집사 전체조회");
			System.out.println("3. 집사 & 고양이 조회하기");
			System.out.println("4. 집사 수정하기");
			System.out.println("5. 집사 삭제하기");
			System.out.println("0. 메인 메뉴로 돌아가기");
			System.out.print("메뉴 선택 > ");
			String menu = sc.nextLine();
			
			switch(menu) {
			case "1" : saveCatKeeper(); break;
			case "2" : findAllCatKeeper(); break;
			case "3" : findCatAndCatKeeper(); break;
			case "4" : break;
			case "5" : break;
			case "0" : return;
			default : System.out.println("없는 메뉴입니다.");
			}
		}
	}
	
	private void saveCat() {
		System.out.println("고양이 생성");
		System.out.print("고양이 이름 입력 > ");
		String name = sc.nextLine();
		
		System.out.print("고양이 성별 입력(M / F) > ");
		String gender = sc.nextLine();
		
		System.out.print("고양이 몸무계 입력 > ");
		double weight = 0;
		try {
			weight = sc.nextDouble();
		} catch(InputMismatchException e) {
			System.out.println("몸무계는 정수 또는 실수만 입력 가능합니다.");
		} finally {
			sc.nextLine();
		}
		
		int result = catController.saveCat(new Cat(name, gender, weight));
		
		if(result > 0) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}
	
	private void findAll() {
		List<Cat> cats = catController.findAll();
		
		if(cats.isEmpty()) {
			System.out.println("고양이가 없습니다.");
		} else {
			System.out.println("고양이 전체 조회 결과\n");
			for(Cat cat : cats) {
				System.out.println("=====================================");
				System.out.println("ID : " + cat.getCatId()
								 + "\n이름 : " + cat.getCatName());
			}
			System.out.println("=====================================\n");
		}
	}
	
	private void findById() {
		System.out.println("고양이 ID로 검색하기");
		findAll();
		System.out.print("고양이 ID > ");
		String catId = sc.nextLine();
		
		Cat cat = catController.findById(catId);
		
		if(cat != null) {
			System.out.println("=====================================");
			System.out.println("ID : " + cat.getCatId()
			 				 + "\n이름 : " + cat.getCatName() + "\t성별 : " + cat.getCatGender()
			 				 + "\n몸무게 : " + cat.getCatWeight() + "\t생일 : " + cat.getCatBirth()
			 				 + "\n집사 이름 : " + cat.getCatKeeperName());
			System.out.println("=====================================");
		} else {
			System.out.println("조회 결과가 없습니다.");
		}
	}
	
	private void findByKeyword() {
		System.out.println("고양이 이름 검색하기");
		System.out.print("고양이 이름 키워드 입력 > ");
		String keyword = sc.nextLine();
		
		List<Cat> cats = catController.findByKeyword(keyword);
		
		
		if(cats.isEmpty()) {
			System.out.println("고양이가 없습니다.");
		} else {
			System.out.println("고양이 전체 조회 결과\n");
			for(Cat cat : cats) {
				System.out.println("=====================================");
				System.out.println("ID : " + cat.getCatId()
				 			     + "\n이름 : " + cat.getCatName() + "\t성별 : " + cat.getCatGender()
				 			     + "\n몸무게 : " + cat.getCatWeight() + "\t생일 : " + cat.getCatBirth()
				 			     + "\n집사 이름 : " + cat.getCatKeeperName());
			}
		System.out.println("=====================================\n");
		}
	}
	
	private void updateCat() {
		System.out.println("고양이 수정하기");
		findAll();
		System.out.print("수정할 고양이 ID 입력 > ");
		int id = 0;
		try {
			id = sc.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("ID는 정수만 입력 가능합니다.");
		} finally {
			sc.nextLine();
		}
		System.out.print("고양이 이름 입력 > ");
		String name = sc.nextLine();
		System.out.print("고양이 몸무게 입력 > ");
		double weight = 0;
		try {
			weight = sc.nextDouble();
		} catch(InputMismatchException e) {
			System.out.println("몸무계는 정수 또는 실수만 입력 가능합니다.");
		} finally {
			sc.nextLine();
		}

		Cat cat = new Cat();
		cat.setCatId(id);
		cat.setCatName(name);
		cat.setCatWeight(weight);
		
		int result = catController.updateCat(cat);
		
		if(result > 0) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
	}
	
	private void setCatKeeper() {
		System.out.println("집사 선택 하기");
		findAll();
		System.out.print("집사를 배정할 고양이 ID 입력 > ");
		int catId = 0;
		try{
			catId = sc.nextInt();
		} catch(InputMismatchException e) {
			e.printStackTrace();
		} finally {
			sc.nextLine();
		}
		findAllCatKeeper();
		System.out.print("집사 ID 입력 > ");
		int catKeeperId = 0;
		try{
			catKeeperId = sc.nextInt();
		} catch(InputMismatchException e) {
			e.printStackTrace();
		} finally {
			sc.nextLine();
		}
		
		Cat cat = new Cat();
		cat.setCatId(catId);
		cat.setCatKeeperId(catKeeperId);
		
		int result = catController.setCatKeeper(cat);
		
		if(result == -1) {
			System.out.println("집사가 이미 배정 되어있습니다.");
		}
		if(result > 0) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}
	
	private void deleteCat() {
		System.out.println("고양이 삭제 하기");
		findAll();
		System.out.print("삭제할 고양이 ID 입력 > ");
		String id = sc.nextLine();
		
		int result = catController.deleteCat(id);
		
		if(result > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}
	
	private void saveCatKeeper() {
		System.out.println("집사 생성");
		System.out.print("집사 이름 입력 > ");
		String name = sc.nextLine();
		
		int result = catKeeperController.saveCatKeeper(name);
		
		if(result > 0) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}
	
	private void findAllCatKeeper() {
		List<CatKeeper> catKeepers = catKeeperController.findAllCatKeeper();
		
		if(catKeepers.isEmpty()) {
			System.out.println("집사가 없습니다.");
		} else {
			System.out.println("집사 전체 조회 결과");
			for(CatKeeper catKeeper : catKeepers) {
				System.out.println("=============================");
				System.out.println("집사 ID : " + catKeeper.getCatKeeperId()
								 + "\n집사 이름 : " + catKeeper.getCatKeeperName());
			}
			System.out.println("=============================\n");
		}
	}
	
	private void findCatAndCatKeeper() {
		System.out.println("집사로 고양이 검색하기");
		System.out.println("1. 집사 ID\n2. 집사 이름");
		System.out.print("검색 조건 입력 > ");
		String condition = sc.nextLine();
		findAllCatKeeper();
		System.out.print("키워드 입력 > ");
		String keyword = sc.nextLine();
		
		Map<String, String> args = new HashMap<String, String>();
		args.put("condition", condition);
		args.put("keyword", keyword);
		
		List<CatKeeper> catKeepers = catKeeperController.findCatAndCatKeeper(args);
		
		if(catKeepers.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			for(CatKeeper catKeeper : catKeepers) {
			    System.out.println("=============================");
			    System.out.println("집사 ID: " + catKeeper.getCatKeeperId());
			    System.out.println("집사 이름: " + catKeeper.getCatKeeperName());
			    System.out.print("담당 고양이: ");
			    if(catKeeper.getCats() == null || catKeeper.getCats().isEmpty()) {
			        System.out.println("없음");
			    } else {
			        for(Cat cat : catKeeper.getCats()) {
			            System.out.println("\n  - " + cat.getCatName());
			        }
			    }
			}
			System.out.println("=============================\n");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
