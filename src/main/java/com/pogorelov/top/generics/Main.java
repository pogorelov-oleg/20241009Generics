package com.pogorelov.top.generics;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> ma = new MyArrayList<>();

        ma.pushBack(1);
        ma.pushBack(2);
        ma.pushBack(3);
        ma.pushBack(4);
        ma.pushBack(5);
        ma.pushBack(6);
        ma.pushBack(7);
        ma.pushBack(8);
        ma.pushBack(9);
        ma.pushBack(10);
        System.out.println(ma + " pushBack 1-10");

        ma.pushFront(0);
        System.out.println(ma+ " pushFront 0");


        ma.popFront();
        System.out.println(ma + " popFront");

        ma.insert(2, -1);
        ma.insert(4, -1);
        ma.insert(6, -1);
        System.out.println(ma + " insert index 2,4,6 el -1");

        ma.removeAt(0);
        System.out.println(ma + " removeAt index 0");

        ma.remove(-1);
        System.out.println(ma + " remove -1");

        ma.removeAll(-1);
        System.out.println(ma + " removeAll -1");

        ma.popBack();
        System.out.println(ma + " popBack");

        ma.clear();
        System.out.println(ma + " clear");
        System.out.println(ma.getSize()+ " getSize");
    }
}