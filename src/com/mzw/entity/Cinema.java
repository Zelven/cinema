package com.mzw.entity;

public class Cinema {
	private Integer id;
	private String movieName;
	private String movieType;
	private String actor;
	private String director;
	private Double price;
	public Cinema() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Cinema(String movieName, String movieType, String actor, String director, Double price) {
		super();
		this.movieName = movieName;
		this.movieType = movieType;
		this.actor = actor;
		this.director = director;
		this.price = price;
	}
	
	
}
