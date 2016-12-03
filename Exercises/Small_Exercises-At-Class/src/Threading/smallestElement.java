package Threading;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class smallestElement extends RecursiveAction {

	private static final long serialVersionUID = -6200187334498294485L;
	private double[] array;
	private int low, high;
	private double lowestElemtent;

	public smallestElement(double[] array, int low, int high) {
		this.array = array;
		this.low = low;
		this.high = high;
	}

	@Override
	protected void compute() {
		if (this.high - this.low <= 25_000_000) {
			this.lowestElemtent = findLowestElement(array, low, high);
		} else {
			int mid = (this.low + this.high) / 2;
			smallestElement task1 = new smallestElement(array, low, mid);
			smallestElement task2 = new smallestElement(array, mid + 1, high);

			invokeAll(task1, task2);
			this.lowestElemtent = task1.getLowestElemtent() > task2.getLowestElemtent() ? task2.getLowestElemtent()
					: task1.getLowestElemtent();

		}
	}

	public double getLowestElemtent() {
		return lowestElemtent;
	}

	static double findLowestElement(double[] array, int low, int high) {
		double lowest = array[low];
		for (int i = low; i < high; i++) {
			if (array[i] < lowest) {
				lowest = array[i];
			}
		}

		return lowest;
	}

	public static void main(String[] args) throws InterruptedException {
		int size = 100_000;

		double[] array = generateArray(size);
		double[] copy = Arrays.copyOf(array, array.length);

		smallestElement task = new smallestElement(array, 0, array.length);

		long start = System.nanoTime();

		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);
		pool.shutdown();

		pool.awaitTermination(1, TimeUnit.DAYS);

		System.out.println("Time thread: " + (double) ((System.nanoTime() - start) / 1e9) + " sec");
		System.out.println("Thread result: " + task.getLowestElemtent());

		start = System.nanoTime();

		System.out.println("Result without thread: " + findLowestElement(copy, 0, array.length));

		System.out.println("Time without thread:" + (double) ((System.nanoTime() - start) / 1e9) + " sec");

	}

	public static double[] generateArray(int size) {

		double[] array = new double[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = Math.random() * 100_000;

		}

		return array;
	}
}
