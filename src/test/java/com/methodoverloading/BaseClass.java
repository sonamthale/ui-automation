package com.methodoverloading;

/**
 * Created by abc on 22-02-2018.
 */
public class BaseClass {
    public static void main (String [] args)
    {
        BaseClass b= new BaseClass();
        System.out.println(b.add());
        System.out.println(b.add(1, 1.2));
    }
    int add()
    {
        int a=10;
        int b=20;
        return a+b;
    }

    double add(int a, double b)
    {
        return a+b;
    }
}


