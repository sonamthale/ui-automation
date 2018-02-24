package com.oops.inheritance;

/**
 * Created by abc on 21-02-2018.
 */
public class ChildClass extends BaseClass {
    public static void main(String[] args)
    {
        //senario 1: child class referene and child lass object
        ChildClass ref1= new ChildClass();
        ref1.add();
        ref1.sub();
        ref1.mul();
        ref1.div();

        //scenario2: base class referene and base class object
        BaseClass ref2= new BaseClass();
        ref2.sub();
        ref2.add();

        //scenario3: base class referene and child class object
        BaseClass ref3= new ChildClass();
        ref3.add();
        ref3.sub();

        //scenario4: child class referene and base class object. java will not allow this scenario.
        //ChildClass ref4= new BaseClass();


    }

    public void mul()
    {
        System.out.println("I am in child class and multiplication is 100");
    }

    public void div()
    {
        System.out.println("I am in child class and div is 10");
    }


}
