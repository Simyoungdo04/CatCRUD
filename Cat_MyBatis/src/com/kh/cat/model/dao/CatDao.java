package com.kh.cat.model.dao;

import java.util.List;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;

import com.kh.cat.model.dto.Cat;

public class CatDao {
	
	public int saveCat(SqlSession session, Cat cat) {
		return session.insert("catMapper.saveCat", cat);
	}
	
	public List<Cat> findAll(SqlSession session) {
		return session.selectList("catMapper.findAll");
	}

	public Cat findById(SqlSession session, String catId) {
		return session.selectOne("catMapper.findById", catId);
	}
	
	public List<Cat> findByKeyword(SqlSession session, String keyword) {
		return session.selectList("catMapper.findByKeyword", keyword);
	}
	
	public int updateCat(SqlSession session, Cat cat) {
		return session.update("catMapper.updateCat", cat);
	}
	
	public int deleteCat(SqlSession session, String id) {
		return session.delete("catMapper.deleteCat", id);
	}

	public int setCatKeeper(SqlSession session, Cat cat) {
		return session.update("catMapper.setCatKeeper", cat);
	}
	
}
