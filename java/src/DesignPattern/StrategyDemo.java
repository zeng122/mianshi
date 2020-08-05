package DesignPattern;

/*
* 策略模式*/
public class StrategyDemo {

    public static void main(String[] args){

        People people = new People1();
        Attack attack = new Attack1();
        people.setAttack(attack);
        people.print();

    }
}

interface  Attack {
    public  void attack();
}


class  Attack1 implements  Attack{

    @Override
    public void attack() {
        System.out.println("通过刀剑攻击");
    }
}


class  Attack2 implements  Attack{

    @Override
    public void attack() {
        System.out.println("通过枪炮攻击");
    }
}


class  Attack3 implements  Attack{

    @Override
    public void attack() {
        System.out.println("通过拳头攻击");
    }
}

abstract  class  People{
    protected  Attack attack;

    void setAttack(Attack attack){
        this.attack = attack;
    }

    void print(){
        attack.attack();
    }
}

class People1 extends People{

    public People1(){
        super();
    }

}

