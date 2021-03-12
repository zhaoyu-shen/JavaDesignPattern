package com.szy.designpattern.singleton.innerclasssingleton;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

/*
 * 单例模式的静态内部类实现
 * 懒加载模式
 * @author 沈钊宇
 * */
public class InnerClassSingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException {
        //使用Java反射
        /*Constructor<InnerClassSingleton> declaredConstructor = InnerClassSingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        InnerClassSingleton innerClassSingleton = declaredConstructor.newInstance();

        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        System.out.println(innerClassSingleton==instance);*/


        //序列化
//        InnerClassSingleton instance =
//                InnerClassSingleton.getInstance();
//        ObjectOutputStream oos=new ObjectOutputStream(
//                new FileOutputStream("testSerializable"));
//        oos.writeObject(instance);
//        oos.close();

        //反序列化
        ObjectInputStream ois=new
                ObjectInputStream(new FileInputStream("testSerializable"));
        InnerClassSingleton object = ((InnerClassSingleton) ois.readObject());

        //System.out.println(instance==object);
    }
}

class InnerClassSingleton implements Serializable {
    static final long serialVersionUID=42L;

    //当这个类被调用时才会初始化
    private static class InnerClassHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton() {
        /*用来防止反射破坏单例*/
        if (InnerClassHolder.instance!=null){
            throw new RuntimeException("单例不允许多个实例");
        }
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.instance;
    }

    Object readResolve() throws ObjectStreamException{
        return InnerClassHolder.instance;
    }

}
