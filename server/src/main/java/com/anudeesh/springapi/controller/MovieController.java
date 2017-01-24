package com.anudeesh.springapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anudeesh.springapi.entity.Movie;
import com.anudeesh.springapi.service.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Movie> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Movie findOne(@PathVariable("id") String mID) {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/type/{type}")
	public List<Movie> findByType(@PathVariable("type") String type) {
		return service.findByType(type);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/year/{year}")
	public List<Movie> findByYear(@PathVariable("year") String year) {
		return service.findByYear(year);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/genre/{genre}")
	public List<Movie> findByGenre(@PathVariable("genre") String genre) {
		return service.findByGenre(genre);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/toprated/{val}")
	public List<Movie> findTopRated(@PathVariable("val") String val) {
		return service.findTopRated(val);
	}
	
//	public List<Movie> findTopRatedSeries() {
//		return null;
//	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/sort/{val}")
	public List<Movie> findSorted(@PathVariable("val") String val) {
		return service.findSorted(val);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Movie create(@RequestBody Movie movie) {
		return service.create(movie);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public Movie update(@PathVariable("id") String mID, @RequestBody Movie movie) {
		return service.update(mID, movie);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable("id") String mID) {
		service.delete(mID);
	}

}
