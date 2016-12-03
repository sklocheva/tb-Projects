package algorithms;

import java.util.Hashtable;

public class hashEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hashtable <String, Double> table1 = new Hashtable<String, Double>();
		table1.put("banana", 2.7);
		table1.put("carrots", 1.35);
		table1.put("lemon", 4.75);
		table1.put("avocado", 7.63);
		table1.put("apple", 4.0);
		table1.put("tomato", 3.72);
		
		for(String s :table1.keySet()){
			System.out.println(s +" "+ table1.get(s));
		}
	}

}
