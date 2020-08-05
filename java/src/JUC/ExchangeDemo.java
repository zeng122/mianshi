package JUC;

import java.util.concurrent.Exchanger;

public class ExchangeDemo {
    Exchanger<String> exchanger = new Exchanger<>();
    void fun1(){
        try {
           String str =  exchanger.exchange("1111");
           System.out.println(Thread.currentThread().getName()+" "+str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    void fun2(){
        try {
            String str =  exchanger.exchange("2222");
            System.out.println(Thread.currentThread().getName()+" "+str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExchangeDemo exchangeDemo = new ExchangeDemo();
        new Thread(()->{exchangeDemo.fun1();}).start();
        new Thread(()->{exchangeDemo.fun2();}).start();
    }

}
