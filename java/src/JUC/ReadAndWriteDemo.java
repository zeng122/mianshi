package JUC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadAndWriteDemo {
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock readLock = readWriteLock.readLock();
    Lock writeLock = readWriteLock.writeLock();

    void read(){
        try {
            readLock.lock();
            System.out.println(Thread.currentThread().getName()+"在读");
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            readLock.unlock();
        }
    }

    void write(){
        try {
            writeLock.lock();
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"在写");
        }finally {
            writeLock.unlock();
        }
    }

    public  static  void main(String[] args){
        ReadAndWriteDemo readAndWriteDemo = new ReadAndWriteDemo();
        for(int i = 0 ;i<10;i++){
            new Thread(()->{
                readAndWriteDemo.read();
            }).start();
        }
        for(int i = 0 ;i<10;i++){
            new Thread(()->{
                readAndWriteDemo.write();
            }).start();
        }
    }

}
