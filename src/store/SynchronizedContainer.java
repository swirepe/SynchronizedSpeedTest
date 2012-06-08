package store;

public class SynchronizedContainer extends Container{
	double[] values;
	
	public SynchronizedContainer(int size){
		this.values = new double[size];
	}

	@Override
	public void addAtIndex(double value, int index) {
		synchronized(this.values){
			this.values[index] += value;
		}
		
	}

}
