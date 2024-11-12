package com.thread.threadprocessing.numberthreadexecutor2;

public class NumberPrinter implements Runnable{
    public int numberPrint;
     NumberPrinter(int number){
        this.numberPrint=number;
    }
    @Override
    public void run() {

        if(numberPrint%2==1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Number is "+numberPrint);
    }
}
