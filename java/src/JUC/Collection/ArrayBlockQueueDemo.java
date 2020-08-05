package JUC.Collection;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockQueueDemo {
    public  static  void main(String[] args){
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(5);

        int i = 0;
        while(true){
           // arrayBlockingQueue.add("dsadsad");
            i++;
            // arrayBlockingQueue.offer("sadadas");    //不阻塞 ， 失败返回false
            // arrayBlockingQueue.add("adadad");       //失败报异常
            try {
                arrayBlockingQueue.put("sdaasd"+i);    // 满了阻塞  take取 ，取不到等
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(arrayBlockingQueue.peek());     //没删除,一直取最后一个
           // System.out.println(arrayBlockingQueue.poll());     //删除了的
        }


    }
}
