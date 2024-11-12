package com.thread.threadprocessing.concurrency2.mergesortmultithread2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class SortWithThread implements Callable<int[]> {
    int[]arr;
    ExecutorService executorService;
    SortWithThread(int[]arr,ExecutorService executorService){
        this.arr=arr;
        this.executorService=executorService;
    }


    @Override
    public int[] call() throws Exception {
        if(arr.length<1)
        {
            return arr;
        }
        int mid=arr.length/2;
        int n=arr.length;
        int[]left=new int[mid];
        int[]right=new int[n-mid];
        for(int i=0;i<mid;i++){
            left[i]=arr[i];
        }
        int k=0;
        for(int i=mid;i<n;i++){
            right[k]=arr[i];
            k++;
        }
        Future<int[]>sortedLeftFuture=executorService.submit(new SortWithThread(left,executorService));
        Future<int[]>sortedRightFuture=executorService.submit(new SortWithThread(right,executorService));
        int[]sortedLeft=sortedLeftFuture.get();
        int[]sortedRight=sortedRightFuture.get();
        merge(sortedLeft,sortedRight,arr);
        return arr;
    }
    public void merge(int[]left,int[]right,int[]arr){
        int i=0;
        int j=0;
        int k=0;
        while (i<left.length && j<right.length){
            if(left[i]<right[j]){
                arr[k++]=left[i++];
            }
            else{
                arr[k++]=right[j++];
            }
        }
        while(i<left.length){
            arr[k++]=left[i++];
        }
        while (j<right.length){
            arr[k++]=right[j++];
        }

    }
}
