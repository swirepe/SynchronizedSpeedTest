package store;

import java.util.concurrent.Semaphore;

public class LockingContainer extends Container {

	double[] values;
	Semaphore[] locks;
	
	public LockingContainer(int size){
		this.values = new double[size];
		this.locks = new Semaphore[size];
		
		for(int i = 0; i < size; i++){
			locks[i] = new Semaphore(1);
		}
	}
	
	@Override
	public void addAtIndex(double value, int index) {
		try {
			this.locks[index].acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.values[index] += value;
		
		this.locks[index].release();
		
	}


} // end of class LockingContainer
