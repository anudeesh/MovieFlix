package com.anudeesh.springapi.repository;

import java.util.List;

import com.anudeesh.springapi.entity.Movie;
import com.anudeesh.springapi.entity.Review;

public interface ReveiwRepository {

	public List<Review> findAll(Movie movie);
	public String findAvgRating(Movie movie);
	public Review create(Review review);
	
}
