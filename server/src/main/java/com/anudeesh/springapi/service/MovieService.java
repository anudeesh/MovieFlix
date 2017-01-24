package com.anudeesh.springapi.service;

import java.util.List;

import com.anudeesh.springapi.entity.Movie;

public interface MovieService {

	public List<Movie> findAll();
	
	public List<Movie> findByType(String type);
	
	public Movie findOne(String id);
	
	public List<Movie> findByYear(String year);
	
	public List<Movie> findByGenre(String genre);
	
	public List<Movie> findTopRated(String val);
	
	public List<Movie> findSorted(String val);
	
	public Movie create(Movie movie);
	
	public Movie update(String mID, Movie movie);
	
	public void delete(String mID);
}
