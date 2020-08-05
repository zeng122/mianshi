package Collection.List;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {
    public  static  void main(String[] args){
        LinkedList<String>  strings = new LinkedList<>();
        strings.add("ssss");
        strings.addFirst("ttttt");
        strings.addLast("Sdddsd");
        Iterator<String> stringsIt =  strings.iterator();
        while (stringsIt.hasNext()){
            System.out.println(stringsIt.next());
        }
    }
}
