package com.netflix.demo.Controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.demo.model.Title;
import com.netflix.demo.Repo.TitleRepo;

@RestController
public class Controller {
	
	@Autowired
	TitleRepo repo;
	
	
	@GetMapping(value = "tvshows", params = "count")
	public List<Title> getCount(@RequestParam(value = "count", defaultValue = "0") Integer count) {
		
		try {
			return repo.getTvShows(count, null);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	@GetMapping(value = "tvshows", params = "country")
	public List<Title> getHorrorTVShows(@RequestParam(value = "country", defaultValue = "") String country) {
		
		try {
			return  repo.getMoviesFromIndia(Integer.MAX_VALUE, null, country);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
	@GetMapping(value = "tvshows", params = {"startDaate", "endDate"})
	public List<Title> getTVShowsWithinADateRange(@RequestParam Map<String, String> requests) {
		
		String[] range = new String[2];
		range[0] = requests.get("startDate");
		range[1] = requests.get("endDate");
		
		try {
			return repo.getTvShows(Integer.MAX_VALUE, range);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@GetMapping("movies")
	public List<Title> getHorrorMovies(@RequestParam(value = "movieType", defaultValue = "") String Type) {

		try {
			return repo.getHorrorMovies(Integer.MAX_VALUE, null, Type);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
	
