package Multithreading.smallestElementRewritten;

public class CalcSmallest {
	
	static double findSmallestElement(double[] array, int low, int high) {
		double lowest = array[low];
		for (int i = low; i < high; i++) {
			if (array[i] < lowest) {
				lowest = array[i];
			}
		}

		return lowest;
	}

}
