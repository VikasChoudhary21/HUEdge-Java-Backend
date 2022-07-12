package Repo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import Model.Title;

public class TitleRepo {
	
	HashMap<Integer, Title> mp = null;
	
	
	public TitleRepo(){
		mp = new HashMap<>();
	}
	
	public int addTitle(int x, Title t) {
		
		mp.put(x, t);
		return mp.size();		
	}

	public void getTvShows(Integer n, String[] range) throws ParseException {
		// TODO Auto-generated method stub
		if(range!=null) {
			Date start = new SimpleDateFormat("DD-MMM-YY").parse(range[0]);
			Date end = new SimpleDateFormat("DD-MMM-YY").parse(range[1]);
			
			for(int i=2; i<=mp.size(); i++) {
				Title t = mp.get(i);
				if(t.getDate_added()!=null && t.getDate_added().before(end) && t.getDate_added().after(start))
					System.out.println(t.toString());
			}
		}
		else {
			int i=2;
			while(n-->0) {
				System.out.println(mp.get(i).toString());
				i++;
			}
		}
		
	}

	public void getHorrorMovies(Integer n, String[] range) throws ParseException {
		// TODO Auto-generated method stub
		if(range!=null) {
			Date start = new SimpleDateFormat("DD-MMM-YY").parse(range[0]);
			Date end = new SimpleDateFormat("DD-MMM-YY").parse(range[1]);
			int count=0;
			for(int i=2; i<=mp.size(); i++) {
				Title t = mp.get(i);
				if(t.getDate_added()!=null && t.getDate_added().before(end) && t.getDate_added().after(start) && t.getListed_in().contains("Horror Movies")) {
					System.out.println(t.toString());
					count++;
				}
				if(count==n) break;
			}
			
		}
		else {
			
			int i=2;
			int count=0;
			while(count<n && i<=mp.size()+1) {
				
				if(mp.get(i).getListed_in().contains("Horror Movies")) {
					System.out.println(mp.get(i).toString());
					count++;
				}
				i++;
			}
		}
	}

	public void getMoviesFromIndia(Integer n, String[] range) throws ParseException {
		// TODO Auto-generated method stub
		if(range!=null) {
			Date start = new SimpleDateFormat("DD-MMM-YY").parse(range[0]);
			Date end = new SimpleDateFormat("DD-MMM-YY").parse(range[1]);
			int count=0;
			for(int i=2; i<=mp.size(); i++) {
				Title t = mp.get(i);
				if(t.getDate_added()!=null && t.getDate_added().before(end) && t.getDate_added().after(start) && t.getType().equals("Movie") && t.getCountry().equals("India")) {
					System.out.println(t.toString());
					count++;
				}
				if(count==n) break;
			}
			
		}
		else {
			int i=2;
			int count=0;
			while(count<n && i<mp.size()+2) {
				
				if(mp.get(i).getType().equals("Movie") && mp.get(i).getCountry().equals("India")) {
					System.out.println(mp.get(i).toString());
					count++;
				}
				i++;
			}
		}
	}

	public HashMap<Integer, Title> getMp() {
		return mp;
	}

}
