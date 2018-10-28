package com.ruoyi.forest.mapper;

import com.ruoyi.forest.domian.SlDiaryDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author kang
 * @email 1992lcg@163.com
 * @date 2018-09-05 17:35:11
 */
@Mapper
public interface SlDiaryDao {

	SlDiaryDO get(Integer id);
	
	List<SlDiaryDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SlDiaryDO slDiary);
	
	int update(SlDiaryDO slDiary);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
