##  概念
 

    运行程序会创建一个进程.
    
    但OS调度的最小单元是线程(轻量级进程).
 
 #####普通的java程序包含的线程：
  
    
      1.Monitor Ctrl-Break  //监听中断信号
      
      2.Attach Listener  //获取内存dump,线程dump
      
      3.Signal Dispatcher  //将信号分给jvm的线程
      
      4.Finalizer  //调用对象的finalizer 方法 
      
      5.Reference Handler  //清除Reference
      
      6.main //程序的主入口



###为什么要用线程？ 

 1. 充分利用多处理核心
    
 1. 更快的响应时间(用户订单的场景，发送邮件等部分可由其他线程执行)


###学习线程的难点 

  1. 知识点多，相关的类和接口比较多，
    
  1. 学习原理，看源码牵涉的知识点多，
      + 包括有设计模式，
      + 数据结构
      + 操作系统
      + cpu相关的概念和定义
        
  1. 线程知识点本身的难度也高。
     
  1. 牢牢记住相关的概念和定义
  
      1. 多写代码
      1. 了解原理
      1. 阅读源码
      
  1. 创建线程的方法
  
      1. extends Thread
      
      2. implements Runnable  //启动线程的方法必须是start(). 不要被run方法误导
  1. 线程完成：
  
        * run（）方法执行完成
        
        * 抛出一个未处理的异常导致线程的提前结束
        
  1. 取消和中断
  
            不安全的取消：
             单独使用一个取消标志位.
            Stop(),suspend(),resume()是过期的api，很大的副作用，容易导致死锁或者数据不一致
            如何安全的终止线程
            使用线程的中断 : 
            interrupt() 中断线程，本质是将线程的中断标志位设为true，其他线程向需要中断的线程打个招呼。是否真正进行中断由线程自己决定。
            isInterrupted() 线程检查自己的中断标志位
            静态方法Thread.interrupted() 将中断标志位复位为false
            由上面的中断机制可知Java里是没有抢占式任务，只有协作式任务。
            为何要用中断，线程处于阻塞（如调用了java的sleep,wait等等方法时）的时候，是不会理会我们自己设置的取消标志位的，但是这些阻塞方法都会检查线程的中断标志位。
            处理不可中断的阻塞
            IO通信 inputstream read/write等阻塞方法，不会理会中断，而关闭底层的套接字socket.close()会抛出socketException
            NIO： selector.select()会阻塞，调用selector的wakeup和close方法会抛出ClosedSelectorException
            死锁状态不响应中断的请求，这个必须重启程序，修改错误。
            如何让我们的代码既可以响应普通的中断，又可以关闭底层的套接字呢？
            覆盖线程的interrupt方法，在处理套接字异常时，再用super.interrupt()自行中断线程
            线程的状态
            新创建   线程被创建，但是没有调用start方法
            可运行（RUNNABLE）  运行状态，由cpu决定是不是正在运行
            被阻塞（BLOCKING）  阻塞，线程被阻塞于锁
            等待/计时等待（WAITING） 等待某些条件成熟
            被终止  线程执行完毕
    
            线程的优先级：
            成员变量priority控制优先级，范围1-10之间，数字越高优先级越高，缺省为5，创建线程时setPriotity（）可以设置优先级，不要指望他发挥作用。
            Daemon线程 
            守护型线程（如GC线程），程序里没有非Daemon线程时，java程序就会退出。一般用不上，也不建议我们平时开发时使用，因为Try/Finally里的代码不一定执行的。
            常用方法深入理解 
            run()和start() 
            run就是一个普通的方法，跟其他类的实例方法没有任何区别。
            Sleep
            不会释放锁，所以我们在用sleep时，要把sleep放在同步代码块的外面。
            yield()
            当前线程出让cpu占有权，当前线程变成了可运行状态，下一时刻仍然可能被cpu选中，不会释放锁。
            wait()和 notify()/notiyfAll() 
            调用以前，当前线程必须要持有锁，调用了wait() notify()/notiyfAll()会释放锁。
            等待通知机制：
            线程 A调用了对象O的wait方法进入等待状态，线程 B调用了对象O的notify方法进行唤醒，唤醒的是在对象O上wait的线程（比如线程A）
            notify() 唤醒一个线程，唤醒哪一个完全看cpu的心情（谨慎使用）
            notiyfAll() 所有在对象O上wait的线程全部唤醒(应该用notiyfAll())



