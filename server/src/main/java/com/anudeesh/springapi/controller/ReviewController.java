package com.anudeesh.springapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anudeesh.springapi.entity.Review;
import com.anudeesh.springapi.service.ReviewService;

@RestController
@RequestMapping(value="/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public List<Review> findAll(@PathVariable("id") String mID) {
		return service.findAll(mID);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/avg/{id}")
	public String findAvgRating(@PathVariable("id") String mID) {
		 return service.findAvgRating(mID);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Review create(Review review) {
		return service.create(review);
	}

}
