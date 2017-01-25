package com.anudeesh.springapi.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Movie.findAll",query="SELECT m from Movie m"),
	@NamedQuery(name="Movie.findByType",query="SELECT m from Movie m WHERE m.type=:mType"),
	@NamedQuery(name="Movie.findByYear",query="SELECT m from Movie m WHERE m.year=:mYear"),
	@NamedQuery(name="Movie.findByGenre",query="SELECT m from Movie m WHERE m.genre LIKE :mGenre"),
	@NamedQuery(name="Movie.findByTitle",query="SELECT m from Movie m WHERE m.title=:mTitle"),
	@NamedQuery(name="Movie.findTopRated",query="SELECT m from Movie m WHERE m.type=:mType AND m.imdbRating=(SELECT MAX(n.imdbRating) from Movie n)"),
	//@NamedQuery(name="Movie.sortByRatings",query="SELECT m from Movie m ORDER BY m.imdbRating DESC"),
	//@NamedQuery(name="Movie.sortByYear",query="SELECT m from Movie m ORDER BY m.year DESC"),
	@NamedQuery(name="Movie.sort",query="SELECT m from Movie m ORDER BY :mVal DESC")
})
public class Movie {
	
	@Id
	private String id;
	@Column(unique=true)
	private String title;
	private String year;
	private String released;
	private String runtime;
	private String genre;
	@Column(columnDefinition="VARCHAR(1000)")
	private String plot;
	private String language;
	private String awards;
	private String poster;
	private String imdbRating;
	private String imdbVotes;
	private String imdbId;
	private String type;
	private String actors;
	private String directors;
	
	
	public Movie() {
		this.id = UUID.randomUUID().toString();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getReleased() {
		return released;
	}


	public void setReleased(String released) {
		this.released = released;
	}


	public String getRuntime() {
		return runtime;
	}


	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getPlot() {
		return plot;
	}


	public void setPlot(String plot) {
		this.plot = plot;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getAwards() {
		return awards;
	}


	public void setAwards(String awards) {
		this.awards = awards;
	}


	public String getPoster() {
		return poster;
	}


	public void setPoster(String poster) {
		this.poster = poster;
	}


	public String getImdbRating() {
		return imdbRating;
	}


	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}


	public String getImdbVotes() {
		return imdbVotes;
	}


	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}


	public String getImdbId() {
		return imdbId;
	}


	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getActors() {
		return actors;
	}


	public void setActors(String actors) {
		this.actors = actors;
	}


	public String getDirectors() {
		return directors;
	}


	public void setDirectors(String directors) {
		this.directors = directors;
	}


	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", released=" + released + ", runtime="
				+ runtime + ", genre=" + genre + ", plot=" + plot + ", language=" + language + ", awards=" + awards
				+ ", poster=" + poster + ", imdbRating=" + imdbRating + ", imdbVotes=" + imdbVotes + ", imdbId="
				+ imdbId + ", type=" + type + ", actors=" + actors + ", directors=" + directors + "]";
	}
	

}
