package org.howard.edu.lsp.midterm.problem51;

import static org.junit.jupiter.api.Assertions.*;

import org.howard.edu.lsp.midterm.problem51.Range.EmptyRangeException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class IntegerRangeTest {

	IntegerRange my_range;
	
	@BeforeEach
	void setUp() throws Exception {
		my_range = new IntegerRange(1, 5);
	}

	@AfterEach
	void tearDown() throws Exception {
		my_range = null;
	}

	@Test
	@DisplayName("Test for getLower")
	void testGetLower() {
		assertEquals(my_range.getLower(), 1);
	}
	
	@Test
	@DisplayName("Test for getUpper")
	void testGetUpper() {
		assertEquals(my_range.getUpper(), 5);
	}
	
	@Test
	@DisplayName("Test for contains")
	void testContains() {
		assertTrue(my_range.contains(3));
		assertFalse(my_range.contains(0));
		assertFalse(my_range.contains(6));
		assertTrue(my_range.contains(5));
	}
	
	@Test
	@DisplayName("Test for overlaps")
	void testOverlaps() throws EmptyRangeException {
		IntegerRange your_range;
		
		your_range = new IntegerRange(3, 7);
		assertTrue(my_range.overlaps(your_range));
		assertTrue(your_range.overlaps(my_range));
		
		your_range = new IntegerRange(-2, 3);
		assertTrue(my_range.overlaps(your_range));
		assertTrue(your_range.overlaps(my_range));
		
		your_range = new IntegerRange(6, 8);
		assertFalse(my_range.overlaps(your_range));
		assertFalse(your_range.overlaps(my_range));
	}
	
	@Test
	@DisplayName("Test for EmptyRangeException")
	void testOverlapsException() {
		IntegerRange your_range = null;
		
		assertThrows(EmptyRangeException.class, () -> my_range.overlaps(your_range));
	}
	
	@Test
	@DisplayName("Test for size")
	void testSize() {
		IntegerRange your_range;
		
		your_range = new IntegerRange(2, 4);
		assertEquals(your_range.size(), 3);
		
		your_range = new IntegerRange(0, 9);
		assertEquals(your_range.size(), 10);
		
		your_range = new IntegerRange(-3, 3);
		assertEquals(your_range.size(), 7);
		
		assertEquals(my_range.size(), 5);
	}
}
