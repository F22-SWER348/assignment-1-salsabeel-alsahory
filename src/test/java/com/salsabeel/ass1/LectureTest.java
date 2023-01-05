package com.salsabeel.ass1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


class LectureTest {
//	@Test
//	void testGetDayOfWeek () {
//		assertEquals(Lecture.getDayOfWeek("MON"),1);
//	}
//	
	
	@Test
	void ConflitTest() throws IOException {
		//assertEquals(Lecture.isConflict(),"no conflict");
		List<String> list =new ArrayList<>();
		list.add("no conflict");
		assertLinesMatch(Lecture.isConflict(), list);
	}
	
	

}
