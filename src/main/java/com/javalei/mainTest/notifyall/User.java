package com.javalei.mainTest.notifyall;

public class User {
    public   static  final  String CITY="Shanghai";
    private String city;
    private int  age;

    public User(String city, int age) {
        this.city = city;
        this.age = age;
    }

    public User() {
    }


    public  synchronized void changeCity(){
        this.city="Beijing";
        notifyAll();
    }

    public  synchronized  void  changeAge(){
        this.age=31;
        notify();

    }


    public  synchronized  void  waitAge(){
        while (this.age<=30){
            try {
                wait();
                System.out.println("wait age change ["+
                        Thread.currentThread().getId()
                        +
                        "] is wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("this age===="+this.age);


        }

    }


    public  synchronized  void  waitCity(){

        while (this.city.equals(CITY)){
            try {
                wait();
                System.out.println("wait city change ["+
                        Thread.currentThread().getId()
                        +
                        "] is wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("this city===="+this.city);

    }






}
