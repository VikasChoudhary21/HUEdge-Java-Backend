package com.netflix.proj.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
//import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.proj.Entity.Title;
import com.netflix.proj.repo.TitleRepo;
import com.netflix.proj.repo.TitleRepository;


@RestController
public class api {
	
	
	@Autowired
	TitleRepo repo;
	
	@Autowired
	TitleRepository dbrepo;
	
	@Autowired
	EntityManager em;
	
	@PostMapping("/addShow")
	public String addShow(@RequestBody Title t) {
		dbrepo.save(t);
		return dbrepo.findById(t.getShow_id()).toString();
	}
	
	/*@GetMapping(value="Hello", params ="s")
	public String hello(HttpServletRequest request, @RequestParam String s) {
		System.out.println(request.getHeader("X-Auth")+" "+s);
		return "hello";
	}*/

	
	@SuppressWarnings({ "unused", "unchecked" })
	@GetMapping(value = "/tvshows/{count}/{source}")
	public List<Title> getCount(@PathVariable Integer count, @PathVariable String source) {
		
		if(source.equals("csv")) {
			
			try {
				return repo.getTvShows(count, null);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		else
		{
			List<Title> res = em.createQuery("select t from Title t").setMaxResults(count).getResultList();
			System.out.print("in block "+res.get(0).toString());
			return res;
		}
		return null;
		
	}
	
	
	@GetMapping(value = "/tvshowsbycountry/{country}/{source}")
	public List<Title> getHorrorTVShows(@PathVariable String country, @PathVariable String source) {
		
		if(source.equals("csv")) {
			try {
				return  repo.getMoviesFromIndia(Integer.MAX_VALUE, null, country);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			return dbrepo.findByCountry(country);
		}
		return null;
		
	}
	
	
	
	@GetMapping(value = "/tvshowsbytime", params = "requests")
	public List<Title> getTVShowsWithinADateRange(@RequestParam String requests) {
		
		String[] data = requests.split(",");
		String src = data[2];
		
		if(src.equals("csv")) {
			String[] range = new String[2];
			range[0]=data[0];
			range[1]=data[1];
			try {
				return repo.getTvShows(Integer.MAX_VALUE, range);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else
		{
			Date start=null, end=null;
			try {
				start = new SimpleDateFormat("DD-MMM-YY").parse(data[0]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				end = new SimpleDateFormat("DD-MMM-YY").parse(data[1]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dbrepo.findByGivendate(start, end);
		}
		
		return null;
		
	}
	
	@GetMapping("/moviesbytype/{type}/{source}")
	public List<Title> getHorrorMovies(@PathVariable String type, @PathVariable String source) {
		if(source.equals("csv")) {
			try {
				return repo.getHorrorMovies(Integer.MAX_VALUE, null, type);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			return dbrepo.findByType(type);
		}
		return null;
	}
}
	

