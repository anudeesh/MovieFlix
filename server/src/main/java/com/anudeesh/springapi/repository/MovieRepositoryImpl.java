package com.anudeesh.springapi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.anudeesh.springapi.entity.Movie;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll",Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findOne(String id) {
		return em.find(Movie.class, id);
	}

	@Override
	public List<Movie> findByType(String type) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByType",Movie.class);
		query.setParameter("mType", type);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> findByYear(String year) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByYear",Movie.class);
		query.setParameter("mYear", year);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> findByGenre(String genre) {
		genre="%"+genre+"%";
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByGenre",Movie.class);
		query.setParameter("mGenre", genre);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public Movie findByTitle(String title) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByGenre",Movie.class);
		query.setParameter("mTitle", title);
		List<Movie> movies = query.getResultList();
		if(movies!=null && movies.size()==1) {
			return movies.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Movie> findTopRated(String val) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findTopRated",Movie.class);
		query.setParameter("mType", val);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> findSorted(String val) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sort",Movie.class);
		query.setParameter("mVal", val);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public Movie create(Movie movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		return em.merge(movie);
	}

	@Override
	public void delete(Movie movie) {
		em.remove(movie);
	}

}
