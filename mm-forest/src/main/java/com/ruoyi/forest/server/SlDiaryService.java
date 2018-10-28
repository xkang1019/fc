package com.ruoyi.forest.server;



import com.ruoyi.forest.domian.SlDiaryDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author kang
 * @email 1992lcg@163.com
 * @date 2018-09-05 17:35:11
 */
public interface SlDiaryService {
	
	SlDiaryDO get(Integer id);
	
	List<SlDiaryDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SlDiaryDO slDiary);
	
	int update(SlDiaryDO slDiary);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
