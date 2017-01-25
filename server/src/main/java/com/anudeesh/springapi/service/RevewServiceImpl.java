package com.anudeesh.springapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anudeesh.springapi.entity.Movie;
import com.anudeesh.springapi.entity.Review;
import com.anudeesh.springapi.exception.EntityNotFoundException;
import com.anudeesh.springapi.repository.MovieRepository;
import com.anudeesh.springapi.repository.ReveiwRepository;

@Service
public class RevewServiceImpl implements ReviewService {
	
	@Autowired
	private ReveiwRepository repository;
	
	@Autowired
	private MovieRepository rep;

	@Override
	@Transactional(readOnly = true)
	public List<Review> findAll(String mID) {
		Movie mov = rep.findOne(mID);
		if(mov == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return repository.findAll(mov);
	}

	@Override
	@Transactional(readOnly = true)
	public String findAvgRating(String mID) {
		Movie mov = rep.findOne(mID);
		if(mov == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return repository.findAvgRating(mov);
	}

	@Override
	@Transactional
	public Review create(Review review) {
		return repository.create(review);
	}

}
