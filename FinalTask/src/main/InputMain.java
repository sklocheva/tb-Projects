package main;

import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import main.factory.Factory;

/**
 * The main class reads commands and executes them.
 * 
 * @author Sophia
 *
 */
public class InputMain {
	/**
	 * The main method reads commands from the console and from a file (using
	 * 'read-from-files' command) and executes them. It can read and execute
	 * commands from files at the same time, as the time it takes for one car to
	 * be created in a specific factory is approx. one second. Invalid inputs
	 * are returned without delay.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * set parameters for the first factory that takes command from the
		 * console
		 */
		Factory factory = new Factory("BG", 1);

		InputStream instr = System.in;
		Scanner inscan = new Scanner(instr);

		String consoleLine;
		String fileName1 = "orders.txt";
		String fileName2 = "orders2.txt";

		try {
			while (true) {
				consoleLine = inscan.nextLine().trim();

				if (consoleLine.contains("read-from-files")) {
					/*
					 * set parameters for the second and third factory, that
					 * read from file
					 */
					ReadGenerator task1 = new ReadGenerator(fileName1, "BG", 2);
					ReadGenerator task2 = new ReadGenerator(fileName2, "BG", 4);

					ExecutorService executor = Executors.newFixedThreadPool(2);
					executor.execute(task1);
					executor.execute(task2);
					executor.shutdown();
					executor.awaitTermination(1, TimeUnit.HOURS);

				} else if (consoleLine.equals("exit")) {
					throw new NoSuchElementException();
				}
				System.out.println(factory.goToFactory(consoleLine));
			}
		} catch (NoSuchElementException e) {
			// typed exit
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			inscan.close();
		}
	}

}
