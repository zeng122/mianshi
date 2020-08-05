package Collection.List;

import java.util.Stack;

public class StackDemo {
    public  static  void main(String[] args){
        Stack<String> strings = new Stack<>();
        strings.push("111");
        strings.push("222");
        strings.push("333");
        System.out.println(strings.peek());
        System.out.println(strings.pop());
        System.out.println(strings.peek());
    }
}
