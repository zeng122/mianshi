package JUC;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    CountDownLatch countDownLatch = new CountDownLatch(10);
    void fun1(){
        System.out.println(Thread.currentThread().getName());
        countDownLatch.countDown();
    }

    void fun2(){
        try {
            countDownLatch.await();
            System.out.println("开始");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public  static  void main(String[] args){

        CountDownLatchDemo  countDownLatchDemo = new CountDownLatchDemo();
        for(int i = 0;i<20;i++){
            new Thread(()->{
                countDownLatchDemo.fun1();
            }).start();
        }
        countDownLatchDemo.fun2();
    }
}
