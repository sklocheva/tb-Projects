package Multithreading.smallestElementRewritten;

public class GenerateRandomArray {

	public static double[] generateArray(int size) {

		double[] array = new double[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = Math.random() * 100_000;
		}
		return array;
	}
}
