package com.javalei.mainTest.volatile2;

public class volatileThread  implements  Runnable{
    private  boolean xie;
    private   int i=0;
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+"----------"+i++);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"----------"+i++);
    }



}
