package com.mzw.vo;

import java.util.List;

import com.mzw.entity.Cinema;


public class VMenuInfo {
	private Integer tid; //以及分类的id
	private String typeName;  //一级分类的名称
	private List<Cinema> goodsList; //以及分类下列表
	public VMenuInfo() {
		// TODO Auto-generated constructor stub
	}
	public VMenuInfo(Integer tid, String typeName, List<Cinema> goodsList) {
		super();
		this.tid = tid;
		this.typeName = typeName;
		this.goodsList = goodsList;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public List<Cinema> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<Cinema> goodsList) {
		this.goodsList = goodsList;
	}

}
