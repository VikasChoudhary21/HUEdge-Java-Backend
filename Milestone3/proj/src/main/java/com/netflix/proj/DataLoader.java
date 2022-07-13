package com.netflix.proj;


import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.netflix.proj.Entity.Title;
import com.netflix.proj.repo.TitleRepo;


public class DataLoader {

	
	public static TitleRepo repo = new TitleRepo();
	public static Title t = null;
	public static ArrayList<String> cols = null;
	
	
	public static void loadData() {
		
		//populate data from the file

		File f = new File("C:\\netflix_titles.csv");
		Scanner sc = null;;
		try {
			sc = new Scanner(f);
			sc.useDelimiter("\n");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int count = 0;
		
		
 		String s = null;
		StringBuilder sb;
		
		cols = new ArrayList<>();
		while(sc.hasNext() && count<100) {
			count++;
			s = sc.next();
			int apos=0;
			sb = new StringBuilder();
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				sb.append(c);
				if(c=='"') apos++;
				if((apos==0 && c==',') || (apos%2==0 && (c==',' || i==s.length()-1))) {
					if(c==',')
						sb.deleteCharAt(sb.length()-1);
					setProperty(count, sb.toString());
					apos = 0;
					sb = new StringBuilder();
				}
			}
			
			
		}
		
		sc.close();
		
	}
	
	
	public static void setProperty(int count, String value) {
		if(count>1) {
			if(cols.size()<12) {
				cols.add(value);
			}
			if(cols.size()==12) {
				Date date = null;
				try {
					if (cols.get(6) != "") {
						date = new SimpleDateFormat("DD-MMM-YY").parse(cols.get(6));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
				t = new Title(cols.get(0),cols.get(1),cols.get(2),cols.get(3),cols.get(4),cols.get(5),date,
						Year.parse(cols.get(7)),cols.get(8),cols.get(9),cols.get(10),cols.get(11));
				repo.addTitle(count, t);
				cols = new ArrayList<>();
			}
		}
	}
}
