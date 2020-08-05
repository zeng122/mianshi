package Test;

public class Test1 {
    public static  void main(String [] args){
        Test1 test1 = new Test1();
        //test1.fun(1 ,2 );
        test1.fun2(1,2);
    }
    void fun(int i  , int j){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fun(1 , 2);
    }

    void fun2(int i  , int j){
      while (true){
         Test1 test1 = new Test1();
      }

    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("sads");
    }
}
