package com.anudeesh.springapi.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Review.findReviews",query="SELECT r from Review r WHERE r.movie=:rMovie"),
	@NamedQuery(name="Review.findAvgRating",query="SELECT AVG(r.rating) from Review r WHERE r.movie=:rMovie")
})
public class Review {
	@Id
	private String id;
	private String rating;
	private String comment;
	@ManyToOne
	private User user;
	@ManyToOne
	private Movie movie;
	
	public Review() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", comment=" + comment + ", user=" + user + ", movie="
				+ movie + "]";
	}
	
	
	
}
