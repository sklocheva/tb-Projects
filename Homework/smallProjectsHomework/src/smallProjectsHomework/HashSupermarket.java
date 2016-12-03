package smallProjectsHomework;

import java.util.Scanner;

public class HashSupermarket {

	private static Scanner in;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		in = new Scanner(System.in);
		HashMap market = new HashMap();

		System.out.println("Ð’ÑŠÐ²ÐµÐ´ÐµÑ‚Ðµ ÐºÐ¾Ð»ÐºÐ¾ Ð²Ð¸Ð´Ð° Ð¿Ñ€Ð¾Ð´ÑƒÐºÑ‚Ð¸ Ñ‰Ðµ Ñ�Ðµ Ð²ÑŠÐ²ÐµÐ´Ð°Ñ‚: ");
		int n = in.nextInt();

		System.out.println("Ð’ÑŠÐ²ÐµÐ´ÐµÑ‚Ðµ " + n + " Ð¿Ñ€Ð¾Ð´ÑƒÐºÑ‚Ð° Ð¸ Ñ‚Ñ�Ñ…Ð½Ð°Ñ‚Ð° Ñ†ÐµÐ½Ð°: ");
		
		for(int i=0; i<n;i++){
			char key = in.next().charAt(0);
			double value = in.nextDouble();
			market.put(key, value);
		}
		
		System.out.print("Ð’ÑŠÐ²ÐµÐ´ÐµÑ‚Ðµ search Ð·Ð° Ñ‚ÑŠÑ€Ñ�ÐµÐ½Ðµ Ð¸Ð»Ð¸ exit Ð·Ð° Ð¿Ñ€ÐµÐºÑ€Ð°Ñ‚Ñ�Ð²Ð°Ð½Ðµ: ");
		String input = in.next().trim();
		
		if(input.equals("exit")){
			System.exit(0);
		}
		else if(input.equals("search")){
			
			System.out.print("Ð’ÑŠÐ²ÐµÐ´ÐµÑ‚Ðµ Ñ‚ÑŠÑ€Ñ�ÐµÐ½Ð¸Ñ� Ð¿Ñ€Ð¾Ð´ÑƒÐºÑ‚: ");
			String stringKey = in.next();
			char key = stringKey.charAt(0);
			double result = market.get(key);
			
			if(result == 2.2){
				System.out.println("Ð�Ðµ Ñ�ÑŠÑ‰ÐµÑ�Ñ‚Ð²ÑƒÐ²Ð° Ñ‚Ð°ÐºÑŠÐ² Ð¿Ñ€Ð¾Ð´ÑƒÐºÑ‚!");
			}
			else{
				System.out.println(stringKey + " Ñ�Ñ‚Ñ€ÑƒÐ²Ð° " + result);
			}
		}
	}
}

class HashEntry{
	private char key;
    private double value;

    HashEntry(char key, double value) {
          this.key = key;
          this.value = value;
    }     

    public char getKey() {
          return key;
    }

    public double getValue() {
          return value;
    }
}

class HashMap{
    final static int TABLE_SIZE = 100;

    HashEntry[] table;

    HashMap() {
          table = new HashEntry[TABLE_SIZE];
          for (int i = 0; i < TABLE_SIZE; i++)
                table[i] = null;
    }

	    public double get(char key) {
	        int hash = (key % TABLE_SIZE);
	        while (table[hash] != null && table[hash].getKey() != key)
	              hash = (hash + 1) % TABLE_SIZE;
	        if (table[hash] == null)
	              return 2.2;
	        else
	              return table[hash].getValue();
	  }

	  public void put(char key, double value) {
	        int hash = (key % TABLE_SIZE);
	        while (table[hash] != null && table[hash].getKey() != key)
	              hash = (hash + 1) % TABLE_SIZE;
	        table[hash] = new HashEntry(key, value);
	  }
	  
}


