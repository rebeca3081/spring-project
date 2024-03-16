package com.yedam.app;

/*
 * char - Character
 * byte - Byte
 * int - Integer O
 * short - Short
 * long - Long
 * float - Float
 * double - Double O
 * boolean -Boolean
 */


public class 형변환 {

	public static void main(String[] args) {
		Integer score = 100;
		String s = Integer.toString(score); // Integer -> String
		
		double avg = 90.5;
		s = Double.toString(avg); // Double -> String
		
		
		// String -> other type
		score = Integer.parseInt(s); // String -> Integer
		
		avg = Double.parseDouble(s); // String -> Double
		
		System.out.println(score + "데스트");
		

	}

}
