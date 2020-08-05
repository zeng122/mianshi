package JUC;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class CycliBarrierDemo {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
        @Override
        public void run() {
            System.out.println("开始启动");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    void fun2(){
        try {
            cyclicBarrier.await();   //减去
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
    public  static  void main(String[] args){
        CycliBarrierDemo cycliBarrierDemo = new CycliBarrierDemo();
        for(int i = 0 ;i<20;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                cycliBarrierDemo.fun2();
            }).start();
        }
    }
}
