package com.szy.designpattern.singleton.lazysingleton;

/*
 * 单例模式的懒汉实现
 * @author 沈钊宇
 * */
public class LazySingletonTest {

    public static void main(String[] args) {
        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();

        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();
    }
}


class LazySingleton {
    //volatile保证底层不会指令重排序
    private volatile static LazySingleton instance;
    private LazySingleton() { }

    public static LazySingleton getInstance() {

        if (instance == null) {

            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                    //字节码层面
                    /*
                    *JIT，CPU
                    * 1.分配空间
                    * 2.初始化
                    * 3.引用赋值
                    * */
                }
            }
        }
        return instance;
    }
}


