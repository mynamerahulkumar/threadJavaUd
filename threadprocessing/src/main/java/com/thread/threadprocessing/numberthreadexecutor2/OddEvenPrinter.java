package com.thread.threadprocessing.numberthreadexecutor2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OddEvenPrinter {
    public static void main(String[] args) {
        // print odd even sequentially odd by one thread and even by another thread 1,2,3,4
        // not we have to use sleep otherwise another thread will not scheduled it will be fast to print one thread all things together
        // or it will nor print in sequence if sleep not used
        ExecutorService oddExecutorService= Executors.newSingleThreadExecutor();
        ExecutorService evenExecutorService=Executors.newSingleThreadExecutor();
        for(int i=1;i<100;i++){
                if(i%2!=1){
                    evenExecutorService.execute(new NumberPrinter(i));
                }
                else{
                    oddExecutorService.execute(new NumberPrinter(i));
                }
        }
    }
}
