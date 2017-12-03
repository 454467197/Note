package com.javalei.mainTest.volatile2;

public class volatileTest {

    public static void main(String[] args) {

        volatileThread v=new volatileThread();


        new Thread(v).start();
        new Thread(v).start();
        new Thread(v).start();
        new Thread(v).start();
    }
}
