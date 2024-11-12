package com.thread.threadprocessing.numberthreadexecutor2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<Thread> threads=new ArrayList<>();
        // 1.single thread
       // Executor executor=Executors.newSingleThreadExecutor();
        //2.create multi thread -total 21 thread will be available for work to do 20 task simultaneously but parrellity dependes on CPU core
        ExecutorService executor=Executors.newFixedThreadPool(20);
        for(int i=0;i<100;i++){
            // 1.executor will handle when to create thread and decide when to create and start the thread
            // all the thread will be running via executor but here only one thread is getting created
            //
            executor.execute(new NumberPrinter(i));
            if(i==40){
                System.out.println("Debug");
            }

        }
        executor.shutdown();//it will stop all stop all thread after execution
    }
}
