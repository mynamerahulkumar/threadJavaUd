package com.thread.threadprocessing.numberthread;

public class NumberPrinter implements Runnable{
    public int numberPrint;
     NumberPrinter(int number){
        this.numberPrint=number;
    }
    @Override
    public void run() {
        System.out.println("Number is"+numberPrint);
    }
}
