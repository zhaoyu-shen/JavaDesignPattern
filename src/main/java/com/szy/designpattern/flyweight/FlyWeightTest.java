package com.szy.designpattern.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * 享元模式
 * @author:沈钊宇
 * */
public class FlyWeightTest {
    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(3, 4, TreeFactory.getTree("xxx", "xxxxxx"));
        TreeNode treeNode2 = new TreeNode(5, 4, TreeFactory.getTree("xxx", "xxxxxx"));
        TreeNode treeNode3 = new TreeNode(5, 24, TreeFactory.getTree("yyy", "xxxxxx"));
        TreeNode treeNode4 = new TreeNode(5, 14, TreeFactory.getTree("yyy", "xxxxxx"));

    }
}

class TreeFactory {
    private static Map<String, Tree> map = new ConcurrentHashMap<>();

    public static Tree getTree(String name, String data) {
        if (map.containsKey(name)) {
            return map.get(name);
        }
        Tree tree = new Tree(name, data);
        map.put(name, tree);
        return tree;
    }
}

class TreeNode {
    private int x;
    private int y;
    private Tree tree;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public TreeNode(int x, int y, Tree tree) {
        this.x = x;
        this.y = y;
        this.tree = tree;
    }
}


//
class Tree {
    private final String name;
    private final String data;

    public Tree(String name, String data) {
        System.out.println("name:"+name+" tree created.");
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }
}

