package com.thread.threadprocessing.concurrency2.addersubstractor;

import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Value value=new Value();
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(new Adder(value));
        executorService.execute(new Substractor(value));
        executorService.shutdown();
       // executorService.awaitTermination(10,TimeUnot)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //  executorService.awaitTermination(5L);
        System.out.println(value.getValue());
    }
}