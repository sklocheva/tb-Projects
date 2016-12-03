package smallProjectsHomework;

public class BinaryExampleAlgorithms {

	public static void main(String[] args) {
		
		double begin = 1.0;
		double end = 100.0;
		for (int i=1; i<100;i++){
			double x = (end+begin)/2;
			if(f(x)>72.0){
				end = x;
			}
			else{
				
				if((f(x)-72.0)==0){
					System.out.println(x);
					break;
				}
				
				begin = x;
			}
		}	
	}
	
	static double f(double x){
		return Math.pow(x, 3.0) + 3.0 * Math.sqrt(x) + Math.log(x);
	}
}
