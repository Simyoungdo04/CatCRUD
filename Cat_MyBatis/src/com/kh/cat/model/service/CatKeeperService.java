package com.kh.cat.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.cat.common.Template;
import com.kh.cat.model.dao.CatKeeperDao;
import com.kh.cat.model.dto.CatKeeper;

public class CatKeeperService {
	private CatKeeperDao catKeeperDao = new CatKeeperDao();
	
	public int saveCatKeeper(String name) {
		SqlSession session = Template.getSqlSession();
		int result = catKeeperDao.saveCatKeeper(session, name);
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}

	public List<CatKeeper> findAllCatKeeper() {
		SqlSession session = Template.getSqlSession();
		List<CatKeeper> catKeepers = catKeeperDao.findAllCatKeeper(session);
		session.close();
		return catKeepers;
	}
	
	public List<CatKeeper> findCatAndCatKeeper(Map<String, String> args) {
		SqlSession session = Template.getSqlSession();
		List<CatKeeper> catKeepers = catKeeperDao.findCatAndCatKeeper(session, args);
		session.close();
		return catKeepers;
	}
	
	public int updateCatKeeper(CatKeeper catKeeper) {
		SqlSession session = Template.getSqlSession();
		int result = catKeeperDao.updateCatKeeper(session, catKeeper);
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}

	public int deleteCatKeeper(String id) {
		SqlSession session = Template.getSqlSession();
		int result = catKeeperDao.deleteCatKeeper(session, id);
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}
	
}
