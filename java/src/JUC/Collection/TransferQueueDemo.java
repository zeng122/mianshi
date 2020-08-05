package JUC.Collection;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class TransferQueueDemo {
    public  static  void main(String[] args){
        LinkedTransferQueue<String> linkedTransferQueue = new LinkedTransferQueue<>();

        new Thread(()-> {
            try {
                while (true){
                    System.out.println("阻塞吗1");
                    linkedTransferQueue.transfer("sadsad");
                    linkedTransferQueue.transfer("sadsad2");
                    System.out.println("阻塞吗2");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                while (true){
                    Thread.sleep(2000);
                    System.out.println(linkedTransferQueue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
