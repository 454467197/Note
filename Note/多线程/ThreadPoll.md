

* FixedThreadPoll

* SingleThreadExecutor


* CachedThreadPoll 

    * 根据需要创建更新的
    * 来一个任务就启动一个线程 如果并发高的话会无限开启线程 
    
             
             public static ExecutorService newCachedThreadPool() {
                    return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                                  60L, TimeUnit.SECONDS,
                                                  new SynchronousQueue<Runnable>());
                }


* WorkStelingPoll 工作觅取 ForkJoinPoll  (JDK7之后)    
             
             
             
* ScheduledThreadPollExecutor

   *                 
             
             
