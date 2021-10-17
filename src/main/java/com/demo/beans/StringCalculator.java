package com.demo.beans;

public class StringCalculator {
	
	public int add(String number) {
		if(number == "") {
			return 0;
		}
		return 0;
		//number = removalOfDelimiters(number);
		//checkForNegativeNumbers(number);
		//number = removeLargeNumbers(number);
		return sum(splitString(number));
	}
	
	private int sum(String[] numbers) {
		int sum = 0;

		for(String num : numbers) {
			sum += toInt(num);
		}
		return sum;
	}
	
	private static String[] splitString(String number) {
		String[] numbers = number.split(",");
		return number.split(",");
	}
}
