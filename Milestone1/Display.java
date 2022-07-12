package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Model.Title;
import Repo.TitleRepo;

public class Display {
	
	public static TitleRepo repo = new TitleRepo();
	public static Title t = null;
	public static ArrayList<String> cols = null;
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		
		
		//populate data from the file

		File f = new File("C:\\netflix_titles.csv");
		Scanner sc = new Scanner(f);
		sc.useDelimiter("\n");
		
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
		
		
		
		
		//userInterface
		Scanner user = new Scanner(System.in);
		
		String[] range = null;
		Integer n;
		String  str;
		while (true) {
			long startTime = System.currentTimeMillis();
		System.out.println("Please input any option from below:");
		System.out.println("1.List the TV Shows");
		System.out.println("2.List the horror movies");
		System.out.println("3.List the movies from India");
		System.out.println("4.Exit");
		str = user.next();
		int input = Integer.parseInt(str);
		if(input!=4) {
				System.out.println("Enter the number of records you want to see");
				n = Integer.parseInt(user.next());
				if(n>0) {
					System.out.println("Want to see records by the time range? Y/N");
					String opt = user.next();
					if(opt.equals("Y")) {
						range = null;
						System.out.println("Enter the time range separated by space");
						str = user.next();
						System.out.println(str);
						range = str.split(",");
				}
				
				
				switch(input) {
				case 1:
					try {
						repo.getTvShows(n,range);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					break;
					
				case 2:
					try {
						repo.getHorrorMovies(n,range);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					break;
					
				case 3:
					try {
						repo.getMoviesFromIndia(n,range);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					break;
				}
				
					
			}
		Long endTime = System.currentTimeMillis();
		System.out.println((endTime-startTime));
		}
		else
			break;
		}
		
		user.close();
			
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



/*
 */
