package com.mzw.dao.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mzw.dao.CinemaDao;
import com.mzw.entity.Cinema;
import com.mzw.utils.JdbcUtils;
import com.mzw.vo.VCinemaInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class CinemaDaoImpl implements CinemaDao{
	
	@Override
	public void add(Cinema c) {
		// TODO Auto-generated method stub
		String sql = "insert into c_info values(null,?,?,?,?,?)";
		QueryRunner qRunner = JdbcUtils.getQueryRunner();
		Object[] params = {
				c.getMovieName(),
				c.getMovieType(),
				c.getActor(),
				c.getDirector(),
				c.getPrice()
		};
		try {
			qRunner.update(sql,params);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCinemaById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from c_info where id =?";
		QueryRunner qRunner = JdbcUtils.getQueryRunner();
		
		try {
			qRunner.update(sql,id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public Cinema update(Cinema c) {
		// TODO Auto-generated method stub
		String sql = "update c_info set movieName =?, movieType = ?, actor = ?,director=?,price=? where id =?";
		QueryRunner qRunner = JdbcUtils.getQueryRunner();
		Object[] params = new Object[] {
				c.getMovieName(),
				c.getMovieType(),
				c.getActor(),
				c.getDirector(),
				c.getPrice()
		};
		try {
			qRunner.update(sql,params);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return c;
	}

	@Override
	public List<VCinemaInfo> findByConditation(Map<String, String[]>map) {
		// TODO Auto-generated method stub
		String sql = "select c.id,c.movieName,t.type,c.price,c.actor,c.director"
				+ "from c_info c inner join c_type t on c.type = t.id where i =1";
		List<String> param = new ArrayList<String>();
		Set<String> keySet = map.keySet();
		for (String string : keySet) {
			
			if (string.equals("pricePre") && map.get(string) != null && !map.get(string)[0].equals("")){
				sql += "and price > ?";
				param.add(map.get(string)[0]);
				continue;
			}
			if (string.equals("priceEnd") && map.get(string) != null && !map.get(string)[0].equals("")){
				sql += "and price < ?";
				param.add(map.get(string)[0]);
				continue;
			}
			if (map.get(string) != null && !map.get(string)[0].equals("")) {
				sql += "and " + string +" like ? ";
				param.add("%" + map.get(string)[0] + "%");
			}
				
			
		}
		Object[] params = param.toArray();
		
		QueryRunner qRunner = JdbcUtils.getQueryRunner();
		List<VCinemaInfo> list = null;
		try {
			list = qRunner.query(sql, new BeanListHandler<>(VCinemaInfo.class),params);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
		
	}

}
