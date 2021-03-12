package com.szy.designpattern.adapter.classadapter;

/*
* 适配器模式
* 类适配器模式
* @author：沈钊宇
* */
public class ClassAdapterTest {
    public static void main(String[] args) {
        Target target=new Adapter();
        target.output5v();
    }
}

class Adaptee{
    public int output220v(){
        return 220;
    }
}

interface Target{
    int output5v();
}

class Adapter extends Adaptee implements Target{


    @Override
    public int output5v() {
        int i = output220v();
        System.out.println(String.format("原始电压：  %d v -> 输出电压： %d v",i,5));

        return 5;
    }
}


