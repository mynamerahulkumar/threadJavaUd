package com.thread.threadprocessing.concurrency3.addersubtractorlock;

public class Value {
    int value;
    public synchronized void add(int i){
        value+=i;
    }
    public synchronized void sub(int i){
        value-=i;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }



}
