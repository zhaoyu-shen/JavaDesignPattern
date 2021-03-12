package com.szy.designpattern.strategy.v1;

public class ZombieTest {
    public static void main(String[] args) {
        AbstractZombie normalZombie = new NormalZombie();
        AbstractZombie flagZombie = new FlagZombie();

        normalZombie.display();
        normalZombie.move();
        normalZombie.attack();

        System.out.println("===================");

        flagZombie.display();
        flagZombie.move();
        flagZombie.attack();
    }
}



abstract class AbstractZombie{
    public abstract void display();

    public void attack(){
        System.out.println("咬");
    }

    public void move(){
        System.out.println("一步一步");
    }
}

class NormalZombie extends AbstractZombie{

    @Override
    public void display() {
        System.out.println("我是普通僵尸。");
    }
}

class FlagZombie extends AbstractZombie{

    @Override
    public void display() {
        System.out.println("我是旗手僵尸");
    }
}

class BigHeadZombie extends AbstractZombie{

    @Override
    public void display() {
        System.out.println("我是大头僵尸");
    }

    @Override
    public void attack() {
        System.out.println("头撞");
    }
}

class Xxxzombie extends BigHeadZombie{
    @Override
    public void move() {
        System.out.println("xxxx");
    }
}
