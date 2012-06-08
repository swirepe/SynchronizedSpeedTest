package store;

public abstract class Container {

	private double[] values;

	public abstract void addAtIndex(double value, int index);
	
	
	public boolean allEqualTo(double value) {
		for(double v: this.values){
			if(v != value){
				return false;
			}
		}	
		
		return true;
	}

	
	public int size() {
		return values.length;
	}
	
} // end of class container
