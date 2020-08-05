package DesignPattern;

public class PrototypeDemo implements Cloneable{

    private String name;
    private String password;
    public  Book book;

    public PrototypeDemo(String name ,String password){
        this.name = name;
        this.password = password;
        book = new Book("小红帽",123);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
       Object obj = super.clone();
       PrototypeDemo prototypeDemo = (PrototypeDemo)obj;
       prototypeDemo.book = (Book)this.book.clone();
       return (Object) prototypeDemo;
    }

    public  void print(){
        System.out.println("name:"+name);
        System.out.println("password："+password);
        System.out.println("bookName："+book.getName());
        System.out.println("bookPage："+book.getPage());
    }

    public static void main(String[] args){
        PrototypeDemo prototypeDemo = new PrototypeDemo("zzm","123");
        try {
            PrototypeDemo newProto = (PrototypeDemo) prototypeDemo.clone();
            if(newProto.equals(prototypeDemo)){
                System.out.println("yes1");
            }
            if(newProto == prototypeDemo){
                System.out.println("yes2");
            }
            if(prototypeDemo.book == newProto.book){
                System.out.println("yes3");
            }
            newProto.print();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

class Book implements Cloneable{
    private String name;
    private  int page;
    public  Book(String name,int page){
        this.name = name;
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public int getPage() {
        return page;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
