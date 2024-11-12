package com.thread.threadprocessing.concurrency2.mergesortmultithread2;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class NormalMergeSortWithoutThread {
    public void mergeSort(int[]arr ,int n){
        if(n<2){
            return;
        }

        int mid=n/2;
        int[] left=new int[mid];
        int[]right=new int[n-mid];
        int k=0;
        for(int i=0;i<mid;i++){
            left[k++]=arr[i];
        }
        k=0;
        for(int i=mid;i<n;i++){
            right[k++]=arr[i];
        }
        mergeSort(left,mid);
        mergeSort(right,n-mid);
        merge(left,right,arr);
    }
    public void merge(int[] left,int[] right,int[] resArr){
         int i=0;
         int j=0;
         int k=0;
         while(i<left.length && j<right.length){
             if(left[i]<right[j]){

                 resArr[k]=left[i];
                 i++;
             }
             else{

                 resArr[k]=right[j];
                j++;
             }
             k++;
         }
         while (i<left.length){
             resArr[k]=left[i];
             i++;
         }
         while (j<right.length){
             resArr[k]=right[j];
             j++;
         }
    }
    public static void main(String[] args) {
        int n=100000;
        SecureRandom secureRandom=new SecureRandom();
        Date startTime=new Date();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=secureRandom.nextInt(n);
        }
         NormalMergeSortWithoutThread object=new NormalMergeSortWithoutThread();
         object.mergeSort(arr,arr.length);
         Date endTime=new Date();
        System.out.println("Time to sort using merge sort with Thread= "+(endTime.getTime()-startTime.getTime())+" ms");//ms

//        for(int a:arr){
//             System.out.print(a+" ");
//         }
       // System.out.println(Arrays.stream(arr).asDoubleStream());
    }
}
