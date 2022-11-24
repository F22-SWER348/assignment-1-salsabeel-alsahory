package com.salsabeel.ass1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	
	public static boolean isConflict(List<Lecture> list) {
		//.plus(Duration.ofHours( 8 ))
		/*for(Map.Entry<String, List<Lecture>> entry:map.entrySet()) {
			// System.out.println(entry.getKey() + ":" + entry.getValue());
		}*/
	  for(int i=0;i<list.size();i++) {
		/*for (DayOfWeek c : ) {
			
		}*/
	}
		return false;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		List<Lecture> lecture = new ArrayList<>();
		File file =new File("lectureFile.txt");
		Scanner in = new Scanner(file);

		while (in.hasNextLine()) {
			String lineData = in.nextLine();
			String[] data = lineData.split(" ");
			
			/*DayOfWeek d= DayOfWeek.of(getDayOfWeek(data[0]));
			LocalTime l= LocalTime.parse(data[1]);
			Duration du =Duration.ofMinutes(Integer.parseInt(data[2]));
            Lecture le =new Lecture(d,l,du);
            
            lecture.add(le);*/
            
            //------------------------------------------------------
            
			lecture.add(new Lecture(DayOfWeek.of(getDayOfWeek(data[0])), LocalTime.parse(data[1]),
					Duration.ofMinutes(Integer.parseInt(data[2]))));
			
			
		}
		in.close();
		
		
	  
	  //emp.stream().collect(Collectors.groupingBy(Employee::getCity));  
	  
	  
	  
	 //Map<String,List<Lecture>> answer = lecture.stream().collect(Collectors.groupingBy(Lecture::toString));
	  /*Map<String,List<Lecture>> answer=new HashMap<>();
	  System.out.println( isConflict(answer));*/
	  
//     Stream<Lecture> stream = lecture.stream();
//     lecture.stream().forEach(System.out::print);
		
		Map<DayOfWeek,List<Lecture>> lec = lecture.stream().collect(Collectors.groupingBy(Lecture::getDayOfWeek));
		
    		 //.collect(Collectors.groupingBy(Lecture::getDayOfWeek));
     
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
    				System.out.println("Conflict between " + lectures.get(i).toString()+" and between "+ lectures.get(j).toString() );
    			
    			}
    			
    				
				
			}
			
		}
    	
    	 
    	 
    			//Days.add(lec.get(DayOfWeek.values()));
    	 //days.add(DayOfWeek.values());
    	 
    	
    	 
     }
     
     if(answer) {
			System.out.println("no conflict");
		}
     
	 
	}
//	public static LocalTime endLectureTime(List<Lecture> l,Map<DayOfWeek,List<Lecture>> lec) {
//		LocalTime s =LocalTime.now();
//		LocalTime answer = null;
//	
//		 for(Entry<DayOfWeek,List<Lecture> > entry : lec.entrySet()) {
//			 List<DayOfWeek> daysOfWeek =new ArrayList<>();
//		for(int i=0;i<l.size();i++) {
//			for(int j=0;j<l.size();j++) {
//		 answer = LocalTime.parse((CharSequence) l.get(i));
//		 
//		 if(l.isEmpty())
//			 System.out.println("List is empty");
//		   
//		 
//		 
//			}
//		}
//		 }
//		System.out.println(answer+"");
//		return s;
//	}
	
	public static LocalTime end (Lecture lec) {
		
		 return lec.getTime().plusMinutes(lec.getDuration().toMinutes());
		
	}
	
//	public static void conflict(Lecture) {
//		
//		System.out.println("Conflict between "+ );
//		
//	}

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
