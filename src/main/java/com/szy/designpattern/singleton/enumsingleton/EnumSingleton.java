package com.szy.designpattern.singleton.enumsingleton;


import java.io.*;
import java.lang.reflect.InvocationTargetException;

/*
 * 单例模式的懒汉实现
 * @author 沈钊宇
 * */
public enum EnumSingleton {
    INSTANCE;

    public void print() {
        System.out.println(this.hashCode());
    }
}

class EnumSingletonTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException {
        /*基于enum实现单例，既可以防止反射攻击，也可以保证线程安全*/
//        Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(String.class,int.class);
//        declaredConstructor.setAccessible(true);
//        EnumSingleton instance = declaredConstructor.newInstance("INSTANCE", 0);
        //EnumSingleton instance1 = EnumSingleton.INSTANCE;
        EnumSingleton instance = EnumSingleton.INSTANCE;
//        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("enumsingleton"));
//        oos.writeObject(instance);
//        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("enumsingleton"));
        EnumSingleton object = (EnumSingleton) ois.readObject();
        System.out.println(object == instance);
    }
}
