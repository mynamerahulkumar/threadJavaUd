package com.thread.threadprocessing.concurrency3.addersubtractorlock;

public class Adder implements Runnable{
    Value value;

    Adder(Value value){
        this.value=value;
    }
    @Override
    public void run() {
        for (int i=0;i<90;i++){
            try{
                Thread.sleep(10);
            }
            catch (Exception e){
                System.out.println(e);
            }
            value.add(i);
        }
    }
}
