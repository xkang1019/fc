package com.ruoyi.forest.server.impl;


import com.ruoyi.forest.domian.SysCardsDO;
import com.ruoyi.forest.mapper.SysCardsDao;
import com.ruoyi.forest.server.SysCardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class SysCardsServiceImpl implements SysCardsService {
	@Autowired
	private SysCardsDao sysCardsDao;
	
	@Override
	public SysCardsDO get(Integer id){
		return sysCardsDao.get(id);
	}
	
	@Override
	public List<SysCardsDO> list(Map<String, Object> map){
		return sysCardsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysCardsDao.count(map);
	}
	
	@Override
	public int save(SysCardsDO sysCards){
		return sysCardsDao.save(sysCards);
	}
	
	@Override
	public int update(SysCardsDO sysCards){
		return sysCardsDao.update(sysCards);
	}
	
	@Override
	public int remove(Integer id){
		return sysCardsDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return sysCardsDao.batchRemove(ids);
	}
	
}
