package com.thread.threadprocessing.concurrency2.mergesortmultithread2;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        List<Integer> list=List.of(1,5,4,3,7);
        int n=3;
        int[]arr=new int[n];
//        for(int i=0;i<n;i++){
//            arr[i]=(int)Math.random();
//        }
        arr[0]=3;
        arr[1]=1;
        arr[2]=2;

        ExecutorService executorService= Executors.newCachedThreadPool();
        Future<int[]> sortedListFuture=executorService.submit(
            new SortWithThread(arr,executorService)
        );
        int[] sortedList=sortedListFuture.get();
        for(int i=0;i<sortedList.length;i++){
            System.out.println(sortedList[i]);

        }
//        System.out.println(sortedList);
    }
}
