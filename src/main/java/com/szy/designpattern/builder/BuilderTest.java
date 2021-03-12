package com.szy.designpattern.builder;

/*
* 建造者模式
* @author:沈钊宇
* */
public class BuilderTest {
    public static void main(String[] args) {
        ProductBuilder ProductBulider = new DefaultConcreateProductBuilder();
        Director director = new Director(ProductBulider);
        Product product = director.makeProduct("productName", "companyName", "part1"
                , "part2", "part3", "part4");
        System.out.println(product);
    }
}
interface ProductBuilder{

    void buliderProductName(String productName);
    void buliderCompanyName(String CompanyName);
    void buliderPart1(String part1);
    void buliderPart2(String part2);
    void buliderPart3(String part3);
    void buliderPart4(String part4);

    Product build();
}


class DefaultConcreateProductBuilder implements ProductBuilder{
    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    @Override
    public void buliderProductName(String productName) {
        this.productName=productName;
    }

    @Override
    public void buliderCompanyName(String CompanyName) {
        this.companyName=CompanyName;
    }

    @Override
    public void buliderPart1(String part1) {
        this.part1=part1;
    }

    @Override
    public void buliderPart2(String part2) {
        this.part2=part2;
    }

    @Override
    public void buliderPart3(String part3) {
        this.part3=part3;
    }

    @Override
    public void buliderPart4(String part4) {
        this.part4=part4;
    }

    @Override
    public Product build() {
        return new Product(this.productName,this.companyName,this.part1,this.part2,this.part3,this.part4);
    }
}

class Director{

    private ProductBuilder builder;

    public Director(ProductBuilder productBuilder) {
        this.builder=productBuilder;
    }

    public Product makeProduct(String productName, String companyName, String part1, String part2, String part3, String part4){
        builder.buliderProductName(productName);
        builder.buliderCompanyName(companyName);
        builder.buliderPart1(part1);
        builder.buliderPart2(part2);
        builder.buliderPart3(part3);
        builder.buliderPart4(part4);
        Product product = builder.build();
        return product;
    }

}


class Product{
    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;
    //......


    public Product() {
    }

    public Product(String productName, String companyName, String part1, String part2, String part3, String part4) {
        this.productName = productName;
        this.companyName = companyName;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getPart3() {
        return part3;
    }

    public void setPart3(String part3) {
        this.part3 = part3;
    }

    public String getPart4() {
        return part4;
    }

    public void setPart4(String part4) {
        this.part4 = part4;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", part4='" + part4 + '\'' +
                '}';
    }
}
