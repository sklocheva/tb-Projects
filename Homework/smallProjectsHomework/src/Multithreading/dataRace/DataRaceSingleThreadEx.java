package Multithreading.dataRace;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DataRaceSingleThreadEx {

	private static SharedData sharedData = new SharedData();

	public static void main(String[] args) throws InterruptedException {

		Runnable runnable = new Runnable() {

			@Override
			public synchronized void run() {
				for (int i = 0; i < 1_000_000; ++i) {
					sharedData.count++;
				}

			}

		};

		ExecutorService executor = Executors.newFixedThreadPool(2);

		executor.execute(runnable);
		executor.execute(runnable);
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.HOURS);
		System.out.println(sharedData.count);
	}

}
