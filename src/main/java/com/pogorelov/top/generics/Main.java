package com.pogorelov.top.generics;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.pushBack(1);
        myArrayList.pushBack(2);
        myArrayList.pushBack(3);
        myArrayList.pushBack(4);
        myArrayList.pushBack(5);
        myArrayList.pushBack(6);
        myArrayList.pushBack(7);
        myArrayList.pushBack(8);
        myArrayList.pushBack(9);
        myArrayList.pushBack(10);
        System.out.println(myArrayList + " pushBack 1-10");

        myArrayList.pushFront(0);
        System.out.println(myArrayList + " pushFront 0");

        myArrayList.popFront();
        System.out.println(myArrayList + " popFront");

        myArrayList.insert(2, -1);
        myArrayList.insert(4, -1);
        myArrayList.insert(6, -1);
        System.out.println(myArrayList + " insert index 2,4,6 el -1");

        myArrayList.removeAt(0);
        System.out.println(myArrayList + " removeAt index 0");

        myArrayList.remove(-1);
        System.out.println(myArrayList + " remove -1");

        myArrayList.removeAll(-1);
        System.out.println(myArrayList + " removeAll -1");

        myArrayList.popBack();
        System.out.println(myArrayList + " popBack");

        myArrayList.clear();
        System.out.println(myArrayList + " clear");
        System.out.println(myArrayList.getSize() + " getSize");
    }
}