package com.szy.designpattern.singleton.hungrysingleton;

/*
 * 单例模式的饿汉实现
 * @author 沈钊宇
 * */
public class HungrySingletonTest {
    public static void main(String[] args) {
        HungrySingleton isntance=HungrySingleton.getInstance();
        HungrySingleton isntanc1=HungrySingleton.getInstance();
        System.out.println(isntance==isntanc1);
    }

}

//饿汉模式
/*
* 1）	加载二进制数据到内存中，生成对应的Class数据结构
* 2）	连接：a.验证 b.准备（给类的静态成员变量赋默认值） c.解析
* 3）	初始化：给类的静态变量赋初值
*
* */
class HungrySingleton{
    private static HungrySingleton instance=new HungrySingleton();
    private HungrySingleton(){
    }
    public static HungrySingleton getInstance(){
        return instance;
    }
}
