package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import parallel.Launcher;
import store.ContainerType;

import config.ConfigParser;
import config.Configuration;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		if(args.length == 0){
			String usage = "Usage:\n\n\tspeedtest configFile\n\tspeedtest --default";
			System.out.println(usage);
			System.exit(0);
		}
		
		Configuration c;
		if(args[0].equals("--default")){
			c = new Configuration();
		}else{
			c = new ConfigParser().parse(args[0]);
		}
		
		System.out.println(c);
		
		Launcher launcher = new Launcher(c);
		
		System.out.println("Locking...");
		write("locking.csv",
			launcher.run(
				ContainerType.LockingContainer
			)
		);
		System.out.println("Locking done.");
		System.gc();
		
		System.out.println("Synchronized...");
		write("synchronized.csv",
				launcher.run(
					ContainerType.SynchronizedContainer
				)
			);
		System.out.println("Synchronized done.");
	} // end of main method

	public static void write(String filename, long[] data) throws IOException{
		
		FileWriter fw = new FileWriter(new File(filename));
		BufferedWriter b = new BufferedWriter(fw);
		
		for(long d: data){
			b.write(d + ",");
		}
		
		//fw.close();
		b.close();
		
	}
	
} // end of main class
