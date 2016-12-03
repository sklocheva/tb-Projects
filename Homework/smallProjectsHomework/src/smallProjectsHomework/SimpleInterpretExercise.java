package smallProjectsHomework;

import java.util.Scanner;

public class SimpleInterpretExercise {

	private static Scanner in;

	public static void main(String[] args) {

		in = new Scanner(System.in);
		boolean flag = true;
		
		while(flag){
			
			String input = in.nextLine().trim();
			String[] newInput = input.split(" ");
			
			switch(newInput[0].toLowerCase()){
			
				case "reverse": System.out.println(reverse(newInput)); break;
				case "count-words": System.out.println(countwords(newInput)); break;
				case "reverse-words": System.out.println(reverseWords(newInput)); break;
				case "exit": flag = false; break;
				default: System.out.println("Enter a valid command or exit!"); 
			}
		}
	}
	
	public static String reverse(String[] n){
		
		StringBuilder reverse = new StringBuilder();
		
		for(int i=n.length-1;i>=1;i--){
			reverse.append(n[i]).append(" ");
		}
		return reverse.toString().trim();
	}
	
	public static int countwords(String[] n){
		
		return n.length-1;
		
	}
	
	public static String reverseWords(String[] n){
		
		StringBuilder reversedString = new StringBuilder();
		
		//obur6ta dumi
		for (int i=n.length-1;i>=1;i--){
			//obru6ta bukvi
			for(int j=n[i].length()-1; j>=0; j--){
				
				reversedString.append(n[i].charAt(j));
			}
			reversedString.append(" ");
		}
		return reversedString.toString().trim();
	}
}
