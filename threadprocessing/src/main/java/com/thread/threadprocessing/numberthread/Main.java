package com.thread.threadprocessing.numberthread;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Thread> threads=new ArrayList<>();
        for(int i=0;i<100;i++){
            // 1) main thread is running
//            System.out.print(i);
//            System.out.println(" "+Thread.currentThread().getName());


            // 2)here main thread and hello world is not getting printed sequentially ,its depends on CPU schedules
//            HelloWorld helloWorld=new HelloWorld();
//            Thread thread=new Thread(helloWorld);
//              System.out.print(i+"-"+thread.getName());
//            thread.start();

            //3)number printer-here every thread is independent is depend on CPU which thread to schedule firs
            // thread with number 3 may execute first
            Thread t=new Thread(new NumberPrinter(i));
            t.start();

            //3.1) here to show the status of each thread store the thread in list and run debugger to see the values,here tid is value
           //FYI main loop i is still running by main thread
            threads.add(t);
            if(i==40){
                System.out.println("Debug");
            }


        }
    }
}
