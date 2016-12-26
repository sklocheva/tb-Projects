package main;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import main.factory.Factory;

/**
 * This program is a factory for cars which can create, update, find and
 * disassemble cars.
 * 
 * In the creation process it validates all values, converts some of them, sets
 * defaults if some optional values are not present and stores them in the
 * ProductHistory file. When complete reading the order file or executing
 * the command from the console, returns the result information.
 * 
 * @author Sophia
 *
 */
public class InputMain {
	/**
	 * The main method reads commands from the console and from a file (using
	 * 'read-from-files' command) and executes them.
	 * 
	 * The factories work independent from each other and can work at the same
	 * time (currently limited to 3). The time it takes for one car to be
	 * created in a factory is approx. one second. Invalid inputs are returned
	 * without delay.
	 * 
	 * Commands from the console use the default factory credentials. The
	 * files from which it is read are set in the Program arguments.
	 * For example: "orders.txt BG 2" "orders2copy.txt BG 4"
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * set parameters for the first factory that takes command from the
		 * console
		 */
		Factory defaultFactory = new Factory("BG", 1);

		InputStream instr = System.in;
		Scanner inscan = new Scanner(instr);

		String consoleLine;
		
//		List<ReadGenerator> tasks;
		List<Future<String>> results;
		
		try {
			while (true) {
				consoleLine = inscan.nextLine().trim();

				if (consoleLine.contains("read-from-files")) {

					ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
					// tasks = new ArrayList<ReadGenerator>();
					results = new ArrayList<Future<String>>();

					// creates new ReadGenerator task to execute
					for (String i : args) {
						String[] arg = i.split(Constants.Const.SPACE_SEPARATOR);
						results.add(executor.submit(new ReadGenerator(arg[0], arg[1], Integer.parseInt(arg[2]))));
					}

					for (Future<String> result : results) {
						System.out.println(result.get());
					}
					executor.shutdown();
					executor.awaitTermination(1, TimeUnit.HOURS);

				} else if (consoleLine.equals("exit")) {
					throw new NoSuchElementException();
				}

				System.out.println(defaultFactory.goToFactory(consoleLine));
			}
		} catch (NoSuchElementException e) {
			// typed exit
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			inscan.close();
		}
	}

}
