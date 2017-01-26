package com.anudeesh.springapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anudeesh.springapi.exception.BadRequestException;
import com.anudeesh.springapi.exception.EntityNotFoundException;
import com.anudeesh.springapi.entity.Movie;
import com.anudeesh.springapi.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Movie> findAll() {
		return repository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Movie findOne(String id) {
		Movie mov = repository.findOne(id);
		if(mov == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return mov;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movie> findByType(String type) {
		return repository.findByType(type);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movie> findByYear(String year) {
		return repository.findByYear(year);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movie> findByGenre(String genre) {
		return repository.findByGenre(genre);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movie> findTopRated(String val) {
		return repository.findTopRated(val);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movie> findSorted(String val) {
		return repository.findSorted(val);
	}

	@Override
	@Transactional
	public Movie create(Movie movie) {
		Movie existing = repository.findByTitle(movie.getTitle());
		if(existing != null) {
			throw new BadRequestException("Movie with this title already exists");
		}
		return repository.create(movie);
	}

	@Override
	@Transactional
	public Movie update(String mID, Movie movie) {
		Movie mov = repository.findOne(mID);
		if(mov == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return repository.update(movie);
	}

	@Override
	@Transactional
	public void delete(String mID) {
		Movie mov = repository.findOne(mID);
		if(mov == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		repository.delete(mov);
	}


}
