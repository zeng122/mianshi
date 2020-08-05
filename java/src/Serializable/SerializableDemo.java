package Serializable;

import java.io.*;

public class SerializableDemo implements Serializable {
    private  String name;
    private  String  password;

    public  SerializableDemo(String name ,String  password){
        this.name = name;
        this.password = password;
    }

    public  static  void main(String[] args){
        SerializableDemo serializableDemo = new SerializableDemo("zzm" , "123");
        File file = new  File("e://1.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(serializableDemo);
            fileOutputStream.close();
            objectOutputStream.close();

            //反序列化
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            SerializableDemo object = (SerializableDemo) objectInputStream.readObject();
            System.out.println(object.name);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
