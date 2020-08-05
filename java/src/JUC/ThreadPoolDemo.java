package JUC;

import jdk.internal.org.objectweb.asm.Handle;

import java.sql.Time;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

//ThreadPoolExecutor.CallerRunsPolicy(): 抛弃旧的任务
//ThreadPoolExecutor.DiscardPolicy() :抛弃当前的任务
//ThreadPoolExecutor.AbortPolicy() :抛出java.util.concurrent.RejectedExecutionException异常
//ThreadPoolExecutor.CallerRunsPolicy() :当抛出RejectedExecutionException异常时，
// 会调用rejectedExecution方法
public class ThreadPoolDemo {

    ExecutorService executorService1 = Executors.newFixedThreadPool(1);
    ExecutorService executorService2 = Executors.newSingleThreadExecutor();
    ExecutorService executorService3 = Executors.newCachedThreadPool();
    ExecutorService executorService4 = Executors.newScheduledThreadPool(2);
    ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(5);
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,1,
            TimeUnit.SECONDS,queue ,new ThreadFactoryDemo(),
            new CallerRunsPolicyDemo());

    int j = 0;

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            j++;
            System.out.println(j);
        }
    };

    void fun1(){
        for(int i =0 ;i<15 ; i++){
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        //TimeUnit.SECONDS.sleep(2);
                        synchronized (this) {j++;}
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
        }

    }


    public static void main(String[] args) {
        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();

//        for(int i = 0 ; i<10;i++){
//            executorService.submit(threadPoolDemo.runnable);
//        }
//
//       System.out.println(executorService.getActiveCount());
//        executorService.shutdown();
//
        threadPoolDemo.fun1();

        threadPoolDemo.threadPoolExecutor.shutdown();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadPoolDemo.j);
    }

   static class ThreadFactoryDemo implements  ThreadFactory{

        public  AtomicInteger atomicInteger =new AtomicInteger();
        public ThreadFactoryDemo(){

        }

       @Override
       public Thread newThread(Runnable r) {
           return new Thread(r,"MyThread"+atomicInteger.incrementAndGet());
       }
   }

    public static class CallerRunsPolicyDemo implements RejectedExecutionHandler {

        private AtomicInteger atomicInteger = new AtomicInteger();

        public CallerRunsPolicyDemo() { }

        /**
         * Executes task r in the caller's thread, unless the executor
         * has been shut down, in which case the task is discarded.
         *
         * @param r the runnable task requested to be executed
         * @param e the executor attempting to execute this task
         */
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            System.out.println("失败");
           //new Thread(r,"failToAdd"+atomicInteger.incrementAndGet()).start();
        }
    }
}
