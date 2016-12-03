package Multithreading.fileCounterFromClassExtended;

import java.io.File;

/**
 * output: Thread counting in C:\Git using two threads 6539 files Thread
 * counting in C:\Workspaces using two threads 1466 files Separeted threads
 * finished counting for: 6.300978394 seconds Thread counting in C:\Git using
 * one thread 6539 files Thread counting in C:\Workspaces using one thread 1466
 * files One thread finished counting for: 5.209407637 seconds
 */
public class FileCounterSecondVersion {

	public static void main(String[] args) throws InterruptedException {

		TaskGen task1 = new TaskGen(new File("C:/Git"));
		TaskGen task2 = new TaskGen(new File("C:/Workspaces"));
		TaskGen taskBoth = new TaskGen(new File("C:/Git"), new File("C:/Workspaces"));

		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);
		Thread threadBoth = new Thread(taskBoth);

		long timeStart = System.nanoTime();
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println(
				"Separeted threads finished counting for: " + (System.nanoTime() - timeStart) / 1e9 + " seconds");

		timeStart = System.nanoTime();
		threadBoth.start();
		threadBoth.join();
		System.out.println("One thread finished counting for: " + (System.nanoTime() - timeStart) / 1e9 + " seconds");

	}

}
