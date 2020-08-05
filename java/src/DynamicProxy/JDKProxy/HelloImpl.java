package DynamicProxy.JDKProxy;

public class HelloImpl implements  HelloInterface {
    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}
