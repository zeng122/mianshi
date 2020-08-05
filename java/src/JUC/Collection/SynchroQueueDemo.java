package JUC.Collection;

import java.util.concurrent.SynchronousQueue;

public class SynchroQueueDemo {
    public  static  void main(String[] args){
        SynchronousQueue<String> queue = new SynchronousQueue<>();
        new Thread(()->{
            try {
                while (true){
                    System.out.println("阻塞");
                    queue.put("Dasdasd");
                    System.out.println("开始");   //可以继续执行
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                while (true){
                    Thread.sleep(2000);
                    System.out.println( queue.take());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
