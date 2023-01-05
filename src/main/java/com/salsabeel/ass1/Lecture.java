package com.salsabeel.ass1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;



//import com.sun.tools.classfile.CharacterRangeTable_attribute.Entry;

public class Lecture {
	DayOfWeek dayOfWeek;
	LocalTime time;
	Duration duration;
	static List<Lecture> lecture = new ArrayList<>();
	
	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public Lecture() {
	}

	public Lecture(DayOfWeek dayOfWeeks, LocalTime localTime, Duration duration) {
		this.dayOfWeek = dayOfWeeks;
		this.time = localTime;
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "\nLecture [day=" + this.dayOfWeek.name() + ", Time=" + this.time + ",Duration=" + this.duration.toMinutes();
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
         String line =null;
		
		BufferedInputStream inputSream = new BufferedInputStream(new FileInputStream("lectureFile.txt"));
		
		
		BufferedReader reader =new BufferedReader(new InputStreamReader(inputSream ));
		
		

		while ((line=reader.readLine()) !=null) {
			//String lineData = line.nextLine();
			String[] data = line.split(" ");
		//------------------------------------------------------
            
			lecture.add(new Lecture(DayOfWeek.of(getDayOfWeek(data[0])), LocalTime.parse(data[1]),
					Duration.ofMinutes(Integer.parseInt(data[2]))));
			
			
		}
		inputSream.close();
		
	isConflict();
	 
		
	 
	}
	
	//--------------------------------------------
	public static LocalTime end(Lecture lec) {
		 return lec.getTime().plusMinutes(lec.getDuration().toMinutes());
		
	}

	//--------------------------------------------
		public static List<String> isConflict() throws IOException {
		BufferedOutputStream outStream =new BufferedOutputStream(new FileOutputStream("writer1.txt"));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outStream));
		List<String> list =new ArrayList<>();
		
				
			String result="";
			//lec = lecture.stream().collect(Collectors.groupingBy(Lecture::getDayOfWeek));
	    		 //.collect(Collectors.groupingBy(Lecture::getDayOfWeek));
			Map<DayOfWeek,List<Lecture>> lec = lecture.stream().collect(Collectors.groupingBy(Lecture::getDayOfWeek));
			boolean answer =true;
	     for(Entry<DayOfWeek,List<Lecture>> entry : lec.entrySet()) {
	    	 //map.getValue
	    	 List<Lecture> lectures = entry.getValue();
	    	 for (int i = 0; i < lectures.size(); i++) {
	    		 for (int j = 1+i; j < lectures.size(); j++) {
	    			 
	    			if(end(lectures.get(i)).isBefore(lectures.get(j).getTime())) {
	    				continue;
	    			}
	    			else {
	    				answer=false;
	    				writer.write("Conflict between " + lectures.get(i).toString()+" and between "+ lectures.get(j).toString()+"\n") ;
	    				writer.flush();
	    			list.add("Conflict between " + lectures.get(i).toString()+" and between "+ lectures.get(j).toString()+"\n");
	    			}}}
	    	 
	     }
	     
	     if(answer) {
	    	 writer.write("no conflict");
	    	 writer.flush();
				System.out.println("salsabeel");
				list.add("no conflict");
			}
		return list;
	     
			
		
	}
		
	
		public static String NoConflict( ) {
			String s="no conflict";
			return s;
		}

		//--------------------------------------------
	public static int getDayOfWeek(String day) {
		switch (day.toUpperCase()) {
		case "MON": 
			return 1;
		case "TUE": 
			return 2;
		case "WED": 
			return 3;
		case "THU": 
			return 4;
		case "FRI": 
			return 5;
		case "SAT": 
			return 6;
		case "SUN": 
			return 7;
	
		}
		return 0;
	}


}
