package com.anudeesh.springapi.repository;

import java.util.List;

import com.anudeesh.springapi.entity.Movie;

public interface MovieRepository {
	
	public List<Movie> findAll();
	public Movie findOne(String id);
	public List<Movie> findByType(String type);
	public List<Movie> findByYear(String year);
	public List<Movie> findByGenre(String genre);
	public Movie findByTitle(String title);
	public List<Movie> findTopRated(String val);
	public List<Movie> findSorted(String val);
	public Movie create(Movie movie);
	public Movie update(Movie movie);
	public void delete(Movie movie);

}
