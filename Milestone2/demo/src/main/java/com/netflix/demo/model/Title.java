package com.netflix.demo.model;

import java.time.Year;
import java.util.Date;

//show_id,type,title,director,cast,country,date_added,release_year,rating,duration,listed_in,description
public class Title {
	
	String show_id;
	String type;
	String title;
	String director;
	String cast;
	String country;
	Date date_added;
	Year release_year;
	String rating;
	String duration;
	String listed_in;
	String Description;
	
	
	public Title(String show_id, String type, String title, String director, String cast, String country,
			Date date_added, Year release_year, String rating, String duration, String listed_in,
			String description) {
		super();
		this.show_id = show_id;
		this.type = type;
		this.title = title;
		this.director = director;
		this.cast = cast;
		this.country = country;
		this.date_added = date_added;
		this.release_year = release_year;
		this.rating = rating;
		this.duration = duration;
		this.listed_in = listed_in;
		Description = description;
	}
	public String getShow_id() {
		return show_id;
	}
	public String getType() {
		return type;
	}
	public String getTitle() {
		return title;
	}
	public String getDirector() {
		return director;
	}
	public String getCast() {
		return cast;
	}
	public String getCountry() {
		return country;
	}
	public Date getDate_added() {
		return date_added;
	}
	public Year getRelease_year() {
		return release_year;
	}
	public String getRating() {
		return rating;
	}
	public String getDuration() {
		return duration;
	}
	public String getListed_in() {
		return listed_in;
	}
	public String getDescription() {
		return Description;
	}
	@Override
	public String toString() {
		return "Title [show_id=" + show_id + ", type=" + type + ", title=" + title + ", director=" + director
				+ ", cast=" + cast + ", country=" + country + ", date_added=" + date_added + ", release_year="
				+ release_year + ", rating=" + rating + ", duration=" + duration + ", listed_in=" + listed_in
				+ ", Description=" + Description + "]";
	}
	
	
}

