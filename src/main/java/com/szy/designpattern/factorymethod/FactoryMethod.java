package com.szy.designpattern.factorymethod;

import java.util.Calendar;

/*
* 工厂模式
* @author：沈钊宇
* */
public class FactoryMethod {
    public static void main(String[] args) {
        Application application=new ConcreateProductA1();
        Product product=application.getObject();
        product.method1();

    }
}

interface Product{
    public void method1();
}

class ProductA implements Product{
    public void method1(){
        System.out.println("ProductA.method1 eexcuted.");
    }
}
class ProductA1 implements Product{
    public void method1(){
        System.out.println("ProductA1.method1 eexcuted.");
    }
}


class SimpleFactory{
    public static Product createProduct(String type){
        if (type.equals("0")){
            return new ProductA();
        }else if (type.equals("1")) {
            return new ProductA1();
        }else{
            return null;
        }

    }
}

abstract class Application{
    //将类的实现延迟到子类
    abstract Product createProduct();

    Product getObject(){
        Product product=createProduct();

        return product;
    }
}

class ConcreateProductA extends Application{

    @Override
    Product createProduct() {
        return new ProductA();
    }
}

class ConcreateProductA1 extends Application{

    @Override
    Product createProduct() {
        return new ProductA1();
    }
}



