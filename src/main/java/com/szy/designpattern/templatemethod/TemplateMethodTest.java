package com.szy.designpattern.templatemethod;

/*
* 模板方法
* @author：沈钊宇
* */
public class TemplateMethodTest {
    public static void main(String[] args) {
        AbstractClass abstractClass=new SubClass();
        abstractClass.opeation();

    }
}

abstract class AbstractClass{
    public void opeation(){
        System.out.println("预处理");
        System.out.println("step1");
        System.out.println("step2");
        System.out.println("step3");
        System.out.println("step4");
        templateMethod();
        //....
    }
    abstract protected void templateMethod();
}

class SubClass extends AbstractClass{

    @Override
    protected void templateMethod() {
        System.out.println("SubClass executed.");
    }
}


