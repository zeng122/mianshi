package DesignPattern;

/* 工程方法模式  */
public class FactoryDemo {
    public static void main(String [] args){
        FruitFactory fruitFactory = new AppleFactory();
        Fruit fruit = fruitFactory.creat();
        fruit.print();
    }

}


interface  Fruit{
    void print();
}

class  Apple implements Fruit{

    @Override
    public void print() {
        System.out.println("我是苹果");
    }
}

class  Banana implements Fruit{

    @Override
    public void print() {
        System.out.println("我是香蕉");
    }
}


interface FruitFactory{
    Fruit creat();
}

class AppleFactory implements  FruitFactory{

    @Override
    public Fruit creat() {
        System.out.println("开始生产");
        return  new Apple();
    }
}
class BananaFactory implements  FruitFactory{

    @Override
    public Fruit creat() {
        System.out.println("开始生产");
        return  new Banana();
    }
}