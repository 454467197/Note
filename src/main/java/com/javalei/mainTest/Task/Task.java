package com.javalei.mainTest.Task;

import java.util.Random;
import java.util.concurrent.Callable;

public class Task implements Callable<String>{

    private String name;
    
    
    @Override
    public String call() throws Exception {
        
        int sleeptime =new Random().nextInt(1000);
        Thread.sleep(sleeptime);
        
        return null;
    }
}