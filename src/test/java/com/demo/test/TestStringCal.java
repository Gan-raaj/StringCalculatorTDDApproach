package com.demo.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.demo.beans.StringCalculator;

public class TestStringCal {
	StringCalculator sc;
	
	@Before
	public void setUp() {
		sc = new StringCalculator();
	}
	
	@Test
	public void testForZero() {
		assertEquals(0,sc.add(""));
	}
	
	@Test
	public void testForOneNumber() {
		assertEquals(1,sc.add("1"));
	}

	@Test
	public void testForTwoNumbers() {
		assertEquals(3,sc.add("1,2"));
	}
	
	@Test
	public void testForMultipleNumbers() {
		assertEquals(6,sc.add("1,2,3"));
	}
	
	@Test
	public void testForMultipleNumbers2() {
		assertEquals(10,sc.add("1,2,3,4"));
	}

	@Test
	public void testForDelimiter() {
		assertEquals(6,sc.add("1,2\n3"));
	}
	
	@Test
	public void testForDelimiter2() {
		assertEquals(11,sc.add("2\n3,4\n2"));
	}
	
	@Test
	public void testForNewDelimiter() {
		assertEquals(3,sc.add("//;\n1;2"));
	}
	
	@Test
	public void testNegatives() {
		Boolean threwException = false;
        	try {
            		sc.add("-4,-3");
        	}
        	catch(IllegalArgumentException ex) {
            		threwException = true;
           		System.out.print("\nException message for testNegativeTwoNumbers: " + ex.getMessage() + "\n");
        	}
        	assertTrue(threwException);
	}
	
	
	@Test
    	public void testNegativeNumbersWithDelim() {
        Boolean threwException = false;
        	try {
            	sc.add("//;\n1;-2");
        	}
	        catch(IllegalArgumentException ex) {
            		threwException = true;
	            	System.out.print("\nException message for testNegativeNumbersWithCustomDelim: " + ex.getMessage() + "\n");
        	}
        	assertTrue(threwException);
    	}
	
	@Test
    	public void testNegSignAsDelimiter() {
        Boolean threwException = false;
        	try {
            		sc.add("//-\n5-3");
        	}
        	catch(IllegalArgumentException ex) {
            		threwException = true;
            		System.out.print("\nException message for testNegSignAsDelimiter: " + ex.getMessage() + "\n");
        	}
        	assertTrue(threwException);
    	}
	
	@Test
    	public void testLargeNumber() {
        	assertEquals(2, sc.add("2,1001"));
    	}
	
	@Test
    	public void test1000() {
        	assertEquals(1002, sc.add("1000,2"));
    	}
	
	@Test
    	public void testLargeNumberWithCustomDelimiter() {
        	assertEquals(3, sc.add("//;\n1001;3"));
    	}
	
	@Test
    	public void testLargeNumberWithNegativeNumbers() {
        Boolean threwException = false;
        	try {
            		sc.add("5000,-3, 5");
        	}
        	catch(IllegalArgumentException ex) {
            		threwException = true;
            		System.out.print("\nException message for testNegSignAsDelimiter: " + ex.getMessage() + "\n");
        	}
        	assertTrue(threwException);
    	}
	
	@Test
	public void testLengthyDelimiters() {
		assertEquals(6, sc.add("//[***]\n1***2***3"));
		assertEquals(6, sc.add("//[,**;*]\n1,**;*2,**;*3"));
	 }
	
	@Test
    	public void testLengthyDelimiterWith1Symbol() {
        	assertEquals(6, sc.add("//[*]\n1*2*3"));
    	}
	
}
