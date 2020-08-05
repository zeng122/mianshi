package DynamicProxy.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
    public static  void main(String [] args){
        HelloInterface hello = new HelloImpl();
        InvocationHandler handler = new ProxyHandle(hello);
        HelloInterface helloInterface  = (HelloInterface) Proxy.newProxyInstance(hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(),handler);
        helloInterface.sayHello();
    }
}
