package com.baidu.game.wanbagame.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.baidu.game.utils.JdbcQuery;

@Transactional
public class WanbaGameService {

//	public static final String PLAT_A_DATA_URL = "jdbc:mysql://10.26.221.51:4901/game?useUnicode=true&characterEncoding=UTF-8";
//	public static final String PLAT_A_DATA_USER = "newyouxi_w";
//	public static final String PLAT_A_DATA_PASSWORD = "a998jiK9a2XbwSD805MT98CjQ";
//	public static final String PLAT_B_DATA_URL = "jdbc:mysql://10.26.221.55:4901/game?useUnicode=true&characterEncoding=UTF-8";
//	public static final String PLAT_B_DATA_USER = "bplat_w";
//	public static final String PLAT_B_DATA_PASSWORD = "ejoiKUPE29845jaijfLw";
	public static final String PLAT_A_DATA_URL = "jdbc:mysql://10.32.32.69:3306/game?useUnicode=true&characterEncoding=UTF-8";
	public static final String PLAT_A_DATA_USER = "game";
	public static final String PLAT_A_DATA_PASSWORD = "game";
	public static final String PLAT_B_DATA_URL = "jdbc:mysql://10.32.32.69:3306/game?useUnicode=true&characterEncoding=UTF-8";
	public static final String PLAT_B_DATA_USER = "game";
	public static final String PLAT_B_DATA_PASSWORD = "game";
	
	public Map<Long, String> findGameOfPlat(String platForm){
		Map<Long, String> mapGame=new HashMap<Long, String>();
		String sql="select id, name from wanba_game where status in (40, 50)";
		JdbcQuery query=null;
		long idTag=0l;
		if("A".equals(platForm)){
			query=new JdbcQuery(PLAT_A_DATA_URL, PLAT_A_DATA_USER, PLAT_A_DATA_PASSWORD);
			idTag=10000l;
		} else if("B".equals(platForm)){
			query=new JdbcQuery(PLAT_B_DATA_URL, PLAT_B_DATA_USER, PLAT_B_DATA_PASSWORD);
			idTag=20000l;
		}
		List<Map<String, Object>> listR=query.find(sql);
		if(null!=listR&&listR.size()>0){
			for(Map<String, Object> m : listR){
				Long id=(Long) m.get("id")+idTag;
				String name=(String) m.get("name");
				mapGame.put(id, name);
			}
		}
		return mapGame;
	}
}
