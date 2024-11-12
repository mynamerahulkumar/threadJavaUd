package com.thread.threadprocessing.concurrency2.mergesortmultithread2;


import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main2WithThread {

    public static void main(String[] args) throws Exception {
        List<Integer> list =new ArrayList<>();
        int n=100000; // without thread 347 ms and with threading 307
        SecureRandom secureRandom=new SecureRandom();
        Date startTime=new Date();
        for(int i=0;i<n;i++){
            int rand=secureRandom.nextInt(n);
            list.add(rand);
        }
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<List<Integer>> sortedListFuture = executorService.submit(
                new SorterWithThread2(list, executorService)
        );
        executorService.shutdown();
        Date endTime=new Date();
        System.out.println("Time to sort using merge sort with Thread= "+(endTime.getTime()-startTime.getTime())+" ms");//ms

//        List<Integer> sortedList = sortedListFuture.get();
//        System.out.println(sortedList);

        // ExecutorService e = Executors.....
        // void e.execute(Runnable)
        // T return = e.execute(Callable)
        // Thread t = new Thread(Callable)
        // t.start()


    }
}