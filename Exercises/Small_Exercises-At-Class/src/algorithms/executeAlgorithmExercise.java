package algorithms;

public class executeAlgorithmExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//for(int n=1000;n<10000; n++){
		int n = 1000;
		long timeBefore = System.currentTimeMillis();
		System.out.println("output:" + executeAlgorithm(n));
		long timeAfter = System.currentTimeMillis();
		System.out.println("time in ms: " + (timeAfter-timeBefore));
		
		 n = 100000;
		long timeBefore2 = System.currentTimeMillis();
		System.out.println("output:" + executeAlgorithm(n));
		long timeAfter2 = System.currentTimeMillis();
		System.out.println("time in ms: " + (timeAfter2-timeBefore2));
		//}
	}
	
	public static long executeAlgorithm(int n){		
		long sum= 0;
		for(int i = 1; i<n; i++){
			for(int j=0; j<n;j++){
				for (int k=n+i+j-3;k<n;k++){
					sum++;
				}
				sum++;
			}
		}
		return sum;
	}
}
