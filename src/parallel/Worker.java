package parallel;

import store.Container;

public class Worker implements Runnable{

	Container container;
	private long workload;
	
	public Worker(Container container, long workload){
		this.container = container;
		this.workload = workload;
	}
	
	
	@Override
	public void run() {
		
		for(int i = 0; i < container.size(); i++){
			try {
				Thread.sleep(this.workload);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			container.addAtIndex(1.0, i);
		}
		
	} // end of method run

}
