package JUC;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    private Thread t1 , t2;
    void fun(){
        t1 = new Thread(()->{
            while (true){
                System.out.println("线程1");
                LockSupport.unpark(t2);
                LockSupport.park();
            }

        });


        t2 = new Thread(()->{
            while (true){
                LockSupport.park();
                System.out.println("线程2");
                LockSupport.unpark(t1);
            }
        });
        t1.start();
        t2.start();
    }
    public  static  void main(String[] args){
        LockSupportDemo lockSupportDemo = new LockSupportDemo();
        lockSupportDemo.fun();
    }
}
