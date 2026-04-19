package com.kh.cat.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.cat.model.dto.CatKeeper;

public class CatKeeperDao {
	
	public int saveCatKeeper(SqlSession session, String name) {
		return session.insert("catKeeperMapper.saveCatKeeper", name);
	}

	public List<CatKeeper> findAllCatKeeper(SqlSession session) {
		return session.selectList("catKeeperMapper.findAllCatKeeper");
	}
	
	public List<CatKeeper> findCatAndCatKeeper(SqlSession session, Map<String, String> args){
		return session.selectList("catKeeperMapper.findCatAndCatKeeper", args);
	}
	
	public int updateCatKeeper(SqlSession session, CatKeeper catKeeper) {
		return session.update("catKeeperMapper.updateCatKeeper", catKeeper);
	}
	
	public int deleteCatKeeper(SqlSession session, String id) {
		return session.delete("catKeeperMapper.deleteCatKeeper", id);
	}
	
}
