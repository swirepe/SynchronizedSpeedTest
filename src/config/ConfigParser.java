package config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigParser {

	public ConfigParser(){
		
	}
	
	public Configuration parse(String filename) {
		Configuration config = new Configuration();
		Properties properties = new Properties();
	
		try{
			properties.load(new FileInputStream(filename));
				
		}catch(Exception e){
			System.err.println("Error reading configuration file " + filename);
			return config;
		}
		
		
		if(properties.containsKey("threads")){
			config.setNumThreads(Integer.parseInt(properties.getProperty("threads")));
		}
		
		if(properties.containsKey("size")){
			config.setArraySize(Integer.parseInt(properties.getProperty("size")));
		}
		
		if(properties.containsKey("workload")){
			config.setWorkLoad(Long.parseLong(properties.getProperty("workload")));
		}
		
		if(properties.containsKey("workers")){
			config.setWorkers(Integer.parseInt(properties.getProperty("workers")));
		}
		
		
		return config;
	}
	
} // end of class configParser
