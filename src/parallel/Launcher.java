package parallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import store.Container;
import store.ContainerType;
import store.LockingContainer;
import store.SynchronizedContainer;

import config.Configuration;


public class Launcher {
	protected Configuration config;
	
	public Launcher(Configuration config){
		this.config = config;
	}
	
	public long[] run(ContainerType type){
		int numIterations = config.getNumIterations();
		long[] times = new long[numIterations];
		
		long start;
		long stop;
		for(int i = 0; i < numIterations; i++){
			System.out.println("Iteration " + (i+1));
			System.gc();
			start = System.currentTimeMillis();

			work(type);
			
			stop = System.currentTimeMillis();
			times[i] = stop - start;
		}
		
		return times;
	}
	
	public void work(ContainerType type){
		ExecutorService svc = Executors.newFixedThreadPool(config.getNumThreads());
		
		int numWorkers = config.getWorkers();
		int size = config.getArraySize();
		long workload = config.getWorkLoad();
		
		// get the appropriate type
		Container c;
		switch(type){
			case LockingContainer:
				c = new LockingContainer(size);
				break;
			case SynchronizedContainer:
			default:
				c = new SynchronizedContainer(size);
				break;
				
		}
		
		// run everything
		for(int i = 0; i < numWorkers; i++){
			svc.execute(new Worker(c,workload));
		}
		
		svc.shutdown();
		
		// wait to finish
		while(! svc.isTerminated() ){
			try { 
				Thread.sleep(1000);  // 1 second 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
	} // end of method work
	
} // end of class launcher
