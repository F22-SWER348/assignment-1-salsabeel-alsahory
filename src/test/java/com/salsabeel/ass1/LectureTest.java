package com.salsabeel.ass1;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.Test;


class LectureTest {
//	@Test
//	void testGetDayOfWeek () {
//		assertEquals(Lecture.getDayOfWeek("MON"),1);
//	}
//	
	
	@Test
	void ConflitTest() {
		assertEquals(Lecture.isConflict(),"no conflict");
	}
	
	

}
