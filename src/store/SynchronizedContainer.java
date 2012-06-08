package store;

public class SynchronizedContainer extends Container{

	public SynchronizedContainer(int size){
		super(size);
	}

	@Override
	public void addAtIndex(double value, int index) {
		synchronized(super.values){
			super.values[index] += value;
		}
		
	}

}
