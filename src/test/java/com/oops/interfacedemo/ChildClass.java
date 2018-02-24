package com.oops.interfacedemo;

/**
 * Created by abc on 21-02-2018.
 */
public class ChildClass implements BaseClass
{
    public static void main(String [] args)
    {
        System.out.println(BaseClass.x);
        //senario 1: child class referene and child lass object
        ChildClass ref1= new ChildClass();
        ref1.add();
        ref1.sub();
        ref1.mul();
        ref1.div();

        //scenario2: base class referene and base class object, java will not allow is scenario.
       // BaseClass ref2= new BaseClass();

        //scenario3: base class referene and child class object
        BaseClass ref3= new ChildClass();
        ref3.add();
        ref3.sub();

        //scenario4: child class referene and base class object. java will not allow this scenario.
        //ChildClass ref4= new BaseClass();
    }

    public void add()
    {
        System.out.println("Addition is 100");
    }

    public void sub()
    {
        System.out.println("Subtraction is 10");

    }

    public void mul()
    {
        System.out.println("Multiplication is 100");
    }

    public void div()
    {
        System.out.println("Division is 10");

    }

}
