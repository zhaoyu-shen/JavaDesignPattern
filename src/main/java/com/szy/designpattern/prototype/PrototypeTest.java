package com.szy.designpattern.prototype;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

/*
* 原型设计模式
* @author:沈钊宇
* */
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        BaseInfo baseInfo=new BaseInfo("huawei");
        Product product=new Product("part1","part2",3,4,5,baseInfo);
        Product clone=product.clone();
        System.out.println("original:"+product);
        System.out.println("clone:   "+clone);

        product.getBaseInfo().setCompanyName("tencent");

        System.out.println("original:"+product);
        System.out.println("clone:   "+clone);
    }
}

class BaseInfo implements Cloneable,Serializable {
    private static final long serialVersionUID = 42L;
    private String companyName;

    public BaseInfo(String companyName) {
        this.companyName = companyName;
    }


    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    protected BaseInfo clone() throws CloneNotSupportedException {
        return (BaseInfo) super.clone();
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return super.hashCode()+"BaseInfo{" +
                "companyName='" + companyName + '\'' +
                '}';
    }
}

class Product implements Cloneable, Serializable {
    private static final long serialVersionUID = 42L;
    private String part1;
    private String part2;
    private Integer part3;
    private Integer part4;
    private Integer part5;
    private BaseInfo baseInfo;

    @Override
    protected Product clone()
            throws CloneNotSupportedException {
//        Product clone = (Product) super.clone();
//        //BaseInfo已经实现Cloneable接口与重写clone方法
//        BaseInfo clone1 = this.baseInfo.clone();
//        clone.setBaseInfo(clone1);
//        return clone;

        //利用java序列化
        ByteOutputStream byteOutputStream = new ByteOutputStream();
        try(ObjectOutputStream oos=new ObjectOutputStream(byteOutputStream);) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteOutputStream.toByteArray());
        try (ObjectInputStream ois=new ObjectInputStream(byteArrayInputStream)){
            Product object = (Product) ois.readObject();
            return object;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    

    public Product() {
    }

    public Product(String part1, String part2, Integer part3, Integer part4, Integer part5,BaseInfo baseInfo) {
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
        this.part5 = part5;
        this.baseInfo=baseInfo;
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public Integer getPart3() {
        return part3;
    }

    public void setPart3(Integer part3) {
        this.part3 = part3;
    }

    public Integer getPart4() {
        return part4;
    }

    public void setPart4(Integer part4) {
        this.part4 = part4;
    }

    public Integer getPart5() {
        return part5;
    }

    public void setPart5(Integer part5) {
        this.part5 = part5;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    @Override
    public String toString() {
        return super.hashCode()+"Product{" +
                "part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3=" + part3 +
                ", part4=" + part4 +
                ", part5=" + part5 +
                ", baseInfo=" + baseInfo +
                '}';
    }
}

