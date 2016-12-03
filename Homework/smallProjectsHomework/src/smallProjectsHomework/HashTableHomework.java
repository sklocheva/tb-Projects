package smallProjectsHomework;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;

public class HashTableHomework {

	private static Scanner in;

	public static void main(String[] args) {

		firstExercise();
		
		secondExercise();

		int[] nums = {1, 1, 3, 4, 5};
		//third exercise  
		System.out.println(containsDuplicate(nums));
		

	}
	
	static void firstExercise(){
		Hashtable<String, Double> groceries = new Hashtable<String, Double>();
		groceries.put("banana", 2.7);
		groceries.put("carrots", 1.35);
		groceries.put("lemon", 4.75);
		groceries.put("avocado", 7.63);
		groceries.put("apple", 4.0);
		groceries.put("tomato", 3.72);
		
		System.out.println(groceries);
		for(String e: groceries.keySet()){
			System.out.println(e + " " + groceries.get(e));
		}
	}
	
	
	static void  secondExercise(){
		
		/** inputs: 
		 * 	 1 2
		 * 	 1 2
		 *   2 1
		 *   1 3
		 *   3 1
		 *   4 1
		 *   5 1 
		 */
		
		in = new Scanner(System.in);

		Hashtable<String, String> table = new Hashtable<String, String>();

		int counter = 0;
		for(int i=0; i<7;i++){
			
			boolean eq = true;
			String key = in.next();
			String value = in.next();
			
			if(table.size()!=0){				
	            for(String key2 : table.keySet()){
	            	if(key.equals(key2)){	            		
	            		eq=false;
	            		if(value.equals(table.get(key2))){
	            			break;
	            		}	
	            		else{counter++;}
	            	}
	            }
            }
			
			if(eq==true){
				table.put(key, value);
				counter++;
			}
        }
	
		System.out.println(counter);
		
		//System.out.println(table);
	}

	public static boolean containsDuplicate(int[] nums) {
		
		HashSet<Integer> table = new HashSet<Integer>();
		
		for(int i=0; i<nums.length;i++){
			table.add(nums[i]);
		}
		if(nums.length==table.size()){
			return false;
		}
		else{
			return true;
		}
	}
	
}
