package JUC;

import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {
    ThreadLocal<Integer> stringThreadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    String str = "hahhahah";

    public static class UnsafeTask implements Runnable {
        private Date startDate;

        public void run() {
            startDate = new Date();
            System.out.printf("Starting Thread: %s : %s\n",
                    Thread.currentThread().getId(), startDate);

            try {
                TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate);
        }
    }

    void fun1() {
        int num = stringThreadLocal.get();
        num++;
        stringThreadLocal.set(num);
        System.out.println(stringThreadLocal.get());
    }

    void fun2() {
        int num = stringThreadLocal.get();
        num++;
        stringThreadLocal.set(num);
        System.out.println(stringThreadLocal.get());
    }

    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        new Thread(()->{
            threadLocalDemo.fun1();
        }).start();
        new Thread(()->{
            threadLocalDemo.fun2();
        }).start();

        System.out.println(threadLocalDemo.stringThreadLocal.get());


//        String str = "SSSSSS";
//        WeakReference<String> stringWeakReference = new WeakReference<>(str);
//        System.out.println(stringWeakReference.get());
    }
}