package com.szy.designpattern.decorator;

/*
* 装饰者模式
* @author：沈钊宇
* */
public class DecoratorTest {
    public static void main(String[] args) {
        Component component=new ConcreteDecorator2(new ConcreteDecorator(new ConcreteComponent()));
        component.operation();
    }
}

interface Component{
    void operation();
}

class ConcreteComponent implements Component{

    @Override
    public void operation() {
        System.out.println("拍照");
    }
}


abstract class Decorator implements Component{
    Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}

class ConcreteDecorator extends Decorator{

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("添加美颜");
        component.operation();
    }
}

class ConcreteDecorator2 extends Decorator{

    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("添加滤镜");
        component.operation();
    }
}

