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

	private static String removalOfDelimiters(String number) {
		number = number.replace("\n", ",");

		if(number.startsWith("//[")) {			
			String delim = number.substring(3, number.indexOf("]"));
			
			if(delim.contains("-"))
				throw new IllegalArgumentException("Illegal delimiter: " + delim);
			
			number = number.substring(5 + delim.length());
			number = number.replace(delim, ",");
		}

		if (number.startsWith("//")) {
			String delim = number.substring(2, 3);
			
			if(delim.contains("-"))
				throw new IllegalArgumentException("Illegal delimiter: " + delim);
			
			number = number.substring(4);
			number = number.replace(delim, ",");
		}
		return number;
	}
}
