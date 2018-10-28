package com.ruoyi.forest.server.impl;



import com.ruoyi.forest.server.SlDiaryService;
import com.ruoyi.forest.domian.SlDiaryDO;
import com.ruoyi.forest.mapper.SlDiaryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class SlDiaryServiceImpl implements SlDiaryService {
	@Autowired
	private SlDiaryDao slDiaryDao;
	
	@Override
	public SlDiaryDO get(Integer id){
		return slDiaryDao.get(id);
	}
	
	@Override
	public List<SlDiaryDO> list(Map<String, Object> map){
		return slDiaryDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return slDiaryDao.count(map);
	}
	
	@Override
	public int save(SlDiaryDO slDiary){
		return slDiaryDao.save(slDiary);
	}
	
	@Override
	public int update(SlDiaryDO slDiary){
		return slDiaryDao.update(slDiary);
	}
	
	@Override
	public int remove(Integer id){
		return slDiaryDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return slDiaryDao.batchRemove(ids);
	}
	
}
