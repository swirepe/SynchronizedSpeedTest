package config;

public class Configuration {

	private static final int million = 1000000;
	
	protected int numThreads = 32;
	protected int arraySize = 10*million; // in millions
	protected long workLoad = 10; // in milliseconds
	protected int numIterations = 100;
	protected int workers = 1000;
	
	public Configuration(){
		
	}
	
	public int getNumThreads() {
		return numThreads;
	}


	public void setNumThreads(int numThreads) {
		this.numThreads = numThreads;
	}


	public int getArraySize() {
		return arraySize;
	}


	public void setArraySize(int arraySize) {
		this.arraySize = arraySize * million;
	}


	public long getWorkLoad() {
		return workLoad;
	}


	public void setWorkLoad(long d) {
		this.workLoad = d;
	}


	public int getNumIterations() {
		return numIterations;
	}

	
	public void setNumIterations(int numIterations) {
		this.numIterations = numIterations;
	}

	public void setWorkers(int workers) {
		this.workers = workers;
	}

	public int getWorkers(){
		return this.workers;
	}
	
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n-Configuration------");
		
		sb.append("\nThreads:\t");
		sb.append(this.numThreads);
		
		sb.append("\nIterations:\t");
		sb.append(this.numIterations);
		
		sb.append("\nArray size:\t");
		sb.append(this.arraySize);
		
		sb.append("\nNumber of Workers:\t");
		sb.append(this.workers);
		
		sb.append("\nMilliseconds per task:\t");
		sb.append(this.workLoad);
		
		sb.append("\n--------------------");
		return sb.toString();
	}
} // end of class configuration
