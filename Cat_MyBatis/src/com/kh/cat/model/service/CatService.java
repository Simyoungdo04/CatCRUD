package com.kh.cat.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.cat.common.Template;
import com.kh.cat.model.dao.CatDao;
import com.kh.cat.model.dto.Cat;

public class CatService {
	private CatDao catDao = new CatDao();
	
	public int saveCat(Cat cat) {
		SqlSession session = Template.getSqlSession();
		int result = catDao.saveCat(session, cat);
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}
	
	public List<Cat> findAll() {
		 SqlSession session = Template.getSqlSession();
		 List<Cat> cats = catDao.findAll(session);
		 session.close();
		 return cats;
	}
	
	public Cat findById(String catId) {
		SqlSession session = Template.getSqlSession();
		Cat cat = catDao.findById(session, catId);
		session.close();
		return cat;
	}
	
	public List<Cat> findByKeyword(String keyword) {
		SqlSession session = Template.getSqlSession();
		List<Cat> cats = catDao.findByKeyword(session, keyword);
		session.close();
		return cats;
	}
	
	public int updateCat(Cat cat) {
		SqlSession session = Template.getSqlSession();
		int result = catDao.updateCat(session, cat);
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}

	public int deleteCat(String id) {
		SqlSession session = Template.getSqlSession();
		int result = catDao.deleteCat(session, id);
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}

	public int setCatkeeper(Cat cat) {
		SqlSession session = Template.getSqlSession();
		Cat findCat = catDao.findById(session, String.valueOf(cat.getCatId()));
		int result = 0;
		if(findCat.getCatKeeperId() != 0) {
			session.close();
			result = -1;
			return result;
		}
		result = catDao.setCatKeeper(session, cat);
		if(result > 0) {
			session.commit();
		} 
		session.close();
		return result;
	}
	
}
