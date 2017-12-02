package com.javalei.mainTest;

import sun.applet.Main;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/***
 *
 */
public class Maintest {
    static {
        System.out.println("我是main的代码库");
    }
                public    String msg="this is mess";
                private static class test implements Runnable{
                 static{
                        System.out.println("我是test的代码库");
                    }
                    @Override
                    public void run() {
                        System.out.println(new Maintest().msg);
                    }
                }

            public static void main(String[] args) {
                ThreadMXBean threadMXBean= ManagementFactory.getThreadMXBean();
                ThreadInfo[] threadInfos=
                        threadMXBean.dumpAllThreads(false,false);


              new Maintest();
                // .new test().run();
                //new test().run();
                for (int i = 0; i < threadInfos.length; i++) {
                    ThreadInfo threadInfo = threadInfos[i];

                    System.out.println(threadInfo.getThreadName());
                }






            }

}
