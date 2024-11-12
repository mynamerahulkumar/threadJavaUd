package com.thread.threadprocessing.concurrency3.addersubtractorlock;

public class Substractor implements Runnable {
    Value value;
    Substractor(Value value){
        this.value=value;
    }
    @Override
    public void run(){
        for(int i=0;i<100;i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            value.sub(i);
        }
    }
}
