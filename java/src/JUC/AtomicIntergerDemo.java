package JUC;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntergerDemo {
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    public  static void  fun(){
        for(int i=0;i<1000;i++){
            atomicInteger.incrementAndGet();
        }
    }

    public  static  void main(String[] args){
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i= 0 ;i<1000;i++){
            Thread thread = new Thread(()->{
                fun();
            });
            thread.start();
            threads.add(thread);
        }
        for(Thread thread:threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(atomicInteger);
    }
}
