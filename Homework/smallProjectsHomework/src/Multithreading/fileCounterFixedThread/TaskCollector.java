package Multithreading.fileCounterFixedThread;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TaskCollector implements Runnable {

	private CompletionService<String> completionService;
	
	public TaskCollector(CompletionService<String> completionService){
		this.completionService = completionService;
	}
	
	@Override
	public void run() {
		try{
			while(true){
				Future<String> future = completionService.take();
				System.out.println(future.get());
			}
		}catch(InterruptedException |ExecutionException e){
			e.printStackTrace();
		}
		
	}

}
