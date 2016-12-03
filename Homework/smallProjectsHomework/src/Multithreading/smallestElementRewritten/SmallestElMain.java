package Multithreading.smallestElementRewritten;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class SmallestElMain {
/**
 * output:
 * 	Result using thread: 0.07609469299119098
 * 	Time using thread: 0.020737852 seconds.
 * 	Result without thread: 0.07609469299119098
 * 	Time without thread: 0.014594299 seconds.
 * 
 */
	public static void main(String[] args) throws InterruptedException {
		int size = 100_000;

		double[] array = GenerateRandomArray.generateArray(size);
		double[] copy = Arrays.copyOf(array, array.length);

		SmallestElementGenerator task = new SmallestElementGenerator(array, 0, array.length);

		ForkJoinPool pool = new ForkJoinPool();

		long start = System.nanoTime();
		pool.invoke(task);
		pool.shutdown();

		pool.awaitTermination(1, TimeUnit.DAYS);

		System.out.println("Result using thread: " + task.getLowestElemtent());
		System.out.println("Time using thread: " + (double) ((System.nanoTime() - start) / 1e9) + " seconds.");

		start = System.nanoTime();

		System.out.println("Result without thread: " + CalcSmallest.findSmallestElement(copy, 0, array.length));
		System.out.println("Time without thread: " + (double) ((System.nanoTime() - start) / 1e9) + " seconds.");
	}

}
