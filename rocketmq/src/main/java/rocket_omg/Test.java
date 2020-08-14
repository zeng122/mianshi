package rocket_omg;

import java.beans.SimpleBeanInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class Test {

    public  static  void main(String [] args){
        /*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = "1998-07-06";
        try {
            Date date = simpleDateFormat.parse(time);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        Byte byte1 = new Byte((byte) 1);
        System.out.println(byte1.toString());
        int a = 2;
        if(a==2){
            System.out.println("111");
            a = 3;

            System.out.println("dsadsa");
        }else if(a == 3){
            System.out.println("222");
        }

        Student student  = new Student();
        student.setName("111");
        Student student1 = student;
        student1.setName("@22");
        System.out.println(student.getName());

        Map<String,Boolean > map = new HashMap<>();
        map.put("111",true);
        map.put("111",false);
        System.out.println(map.get("111"));
    }


    static  class  Student{
        private  String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
