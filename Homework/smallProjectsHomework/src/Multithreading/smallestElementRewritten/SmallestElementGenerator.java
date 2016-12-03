package Multithreading.smallestElementRewritten;

import java.util.concurrent.RecursiveAction;

public class SmallestElementGenerator extends RecursiveAction {

	private static final long serialVersionUID = -6200187334498294485L;
	private double[] array;
	private int low, high;
	private double lowestElemtent;

	public SmallestElementGenerator(double[] array, int low, int high) {
		this.array = array;
		this.low = low;
		this.high = high;
	}

	public double getLowestElemtent() {
		return lowestElemtent;
	}

	@Override
	protected void compute() {
		if (this.high - this.low <= 25_000_000) {
			this.lowestElemtent = CalcSmallest.findSmallestElement(array, low, high);
		} else {
			int mid = (this.low + this.high) / 2;
			SmallestElementGenerator task1 = new SmallestElementGenerator(array, low, mid);
			SmallestElementGenerator task2 = new SmallestElementGenerator(array, mid + 1, high);

			invokeAll(task1, task2);
			this.lowestElemtent = task1.getLowestElemtent() > task2.getLowestElemtent() ? task2.getLowestElemtent()
					: task1.getLowestElemtent();

		}
	}
	
}
