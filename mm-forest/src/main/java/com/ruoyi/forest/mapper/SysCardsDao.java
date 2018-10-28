package com.ruoyi.forest.mapper;


import com.ruoyi.forest.domian.SysCardsDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author lzy
 * @email 1992lcg@163.com
 * @date 2018-09-12 10:43:25
 */
@Mapper
public interface SysCardsDao {

	SysCardsDO get(Integer id);
	
	List<SysCardsDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);
	
	int save(SysCardsDO sysCards);
	
	int update(SysCardsDO sysCards);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
