package com.anudeesh.springapi.service;

import java.util.List;

import com.anudeesh.springapi.entity.Review;

public interface ReviewService {
	
	public List<Review> findAll(String mID);
	public String findAvgRating(String mID);
	public Review create(Review review);

}
