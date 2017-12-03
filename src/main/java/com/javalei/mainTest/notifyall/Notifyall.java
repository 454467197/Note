package com.javalei.mainTest.notifyall;

public class Notifyall{


    public static final User u=new User(User.CITY,30);

    public static class checkage extends  Thread{

        @Override
        public void run() {
            u.waitAge();
        }
    }


    public static class checkCity extends  Thread{

        @Override
        public void run() {
             u.waitCity();
        }
    }


    public static void main(String[] args) {

        for (int i = 0; i <3 ; i++) {
            new checkage().start();
        }

        for (int i = 0; i <3 ; i++) {
            new checkCity().start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        u.changeCity();

    }


}
