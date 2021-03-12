package com.szy.designpattern.strategy.v2;

/*
* 使用策略模式对v1代码进行改进
* @author：沈钊宇
* */
public class StrategyTest {
    public static void main(String[] args) {
        Zombie zombie=new NormalZombie();
        zombie.display();
        zombie.attack();
        zombie.move();
    }
}

interface Moveable{
    void move();
}
interface Attackable{
    void attack();
}

abstract class Zombie{
    abstract public void display();
    Moveable moveable;
    Attackable attackable;
    abstract void move();

    public Zombie(Moveable moveable, Attackable attackable) {
        this.moveable = moveable;
        this.attackable = attackable;
    }

    public Moveable getMoveable() {
        return moveable;
    }

    public void setMoveable(Moveable moveable) {
        this.moveable = moveable;
    }

    public Attackable getAttackable() {
        return attackable;
    }

    public void setAttackable(Attackable attackable) {
        this.attackable = attackable;
    }

    abstract void attack();
}

class StepByStepMove implements Moveable{

    @Override
    public void move() {
        System.out.println("一步一步移动");
    }
}

class BiteAttack implements Attackable{

    @Override
    public void attack() {
        System.out.println("咬");
    }
}

class HitAttack implements Attackable{

    @Override
    public void attack() {
        System.out.println("打");
    }
}

class FlagZombie extends Zombie{

    public FlagZombie() {
        super(new StepByStepMove(),new BiteAttack());
    }

    public FlagZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println("我是旗手僵尸");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attackable.attack();
    }
}




class NormalZombie extends Zombie{

    public NormalZombie(){
        super(new StepByStepMove(),new HitAttack());
    }
    public NormalZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println("我是普通僵尸");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attackable.attack();
    }
}