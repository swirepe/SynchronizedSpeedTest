# Synchronized Speed Test

Peter Swire - [swirepe.com](http://www.swirepe.com)

## What is it?

Say you have a problem where you have a very large array that you need to update parts of.  Which is faster: synchronizing that whole array, or making a separate array of Semaphores?

The separate array takes more memory, but should let you update parts of the array that have nothing to do with each other.

The synchronized array is easier to implement, but may lead to more contention.  Or, in a nutshell:

    synchronized(values){
        values[index] += x;
    }

VS

    locks[index].acquire();
    values[index] += x;
    locks[index].release();


## How do I use it?

    speedtest --default
    speedtest configFile
    
    
### Default
    # number of threads to initialize the pool with
    threads = 32
    
    # number of elements in the array, in thousands
    size = 10
    
    # milliseconds per action, simulating something hard
    workload = 10
    
    # number of workers trying to write to that array
    workers = 1000
