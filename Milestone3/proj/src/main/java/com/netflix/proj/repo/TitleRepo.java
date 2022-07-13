package com.netflix.proj.repo;


import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.netflix.proj.Entity.Title;


@Repository
public class TitleRepo {
	
	public static HashMap<Integer, Title> mp = null;
	
	
	public TitleRepo(){
		mp = new HashMap<>();
	}
	public int addTitle(int x, Title t) {
		mp.put(x, t);
		return mp.size();		
	}

	public List<Title> getTvShows(Integer n, String[] range) throws ParseException {
		// TODO Auto-generated method stub
		List<Title> li = new ArrayList<>();
		if(range!=null) {
			Date start = new SimpleDateFormat("DD-MMM-YY").parse(range[0]);
			Date end = new SimpleDateFormat("DD-MMM-YY").parse(range[1]);
			
			for(int i=2; i<=mp.size(); i++) {
				Title t = mp.get(i);
				if(t.getDate_added()!=null && t.getDate_added().before(end) && t.getDate_added().after(start))
					li.add(t);
			}
		}
		else {
			int i=2;
			while(n-->0) {
				li.add(mp.get(i));
				System.out.print(mp.get(i));
				i++;
			}
		}
		return li;
		
	}

	public ArrayList<Title> getHorrorMovies(Integer n, String[] range, String type) throws ParseException {
		// TODO Auto-generated method stub
		ArrayList<Title> li = new ArrayList<>();
		if(range!=null) {
			Date start = new SimpleDateFormat("DD-MMM-YY").parse(range[0]);
			Date end = new SimpleDateFormat("DD-MMM-YY").parse(range[1]);
			int count=0;
			for(int i=2; i<=mp.size(); i++) {
				Title t = mp.get(i);
				if(t.getDate_added()!=null && t.getDate_added().before(end) && t.getDate_added().after(start) && t.getListed_in().contains(type)) {
					//System.out.println(t.toString());
					li.add(t);
					count++;
				}
				if(count==n) break;
			}
			
		}
		else {
			
			int i=2;
			int count=0;
			while(count<n && i<=mp.size()+1) {
				
				if(mp.get(i).getListed_in().contains(type)) {
					//System.out.println(mp.get(i).toString());
					li.add(mp.get(i));
					count++;
				}
				i++;
			}
		}
		return li;
	}

	public ArrayList<Title> getMoviesFromIndia(Integer n, String[] range, String location) throws ParseException {
		// TODO Auto-generated method stub
		ArrayList<Title> li = new ArrayList<>();
		if(range!=null) {
			Date start = new SimpleDateFormat("DD-MMM-YY").parse(range[0]);
			Date end = new SimpleDateFormat("DD-MMM-YY").parse(range[1]);
			int count=0;
			for(int i=2; i<=mp.size(); i++) {
				Title t = mp.get(i);
				if(t.getDate_added()!=null && t.getDate_added().before(end) && t.getDate_added().after(start) && t.getCountry().equals(location)) {
					//System.out.println(t.toString());
					li.add(t);
					count++;
				}
				if(count==n) break;
			}
			
		}
		else {
			int i=2;
			int count=0;
			while(count<n && i<mp.size()+2) {
				
				if(mp.get(i).getCountry().equals(location)) {
					//System.out.println(mp.get(i).toString());
					li.add(mp.get(i));
					count++;
				}
				i++;
			}
		}
		return li;
	}

	public HashMap<Integer, Title> getMp() {
		return mp;
	}

}

