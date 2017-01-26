package com.anudeesh.springapi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.anudeesh.springapi.entity.Movie;
import com.anudeesh.springapi.entity.Review;

@Repository
public class ReviewRepositoryImpl implements ReveiwRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Review> findAll(Movie movie) {
		TypedQuery<Review> query = em.createNamedQuery("Review.findReviews",Review.class);
		query.setParameter("rMovie", movie);
		List<Review> reviews = query.getResultList();
		return reviews;
	}

	@Override
	public String findAvgRating(Movie movie) {
		Query query = em.createNamedQuery("Review.findAvgRating");
		query.setParameter("rMovie", movie);
		return (String) query.getSingleResult();
	}

	@Override
	public Review create(Review review) {
		em.persist(review);
		return review;
	}

}
