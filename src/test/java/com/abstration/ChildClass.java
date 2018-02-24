package com.abstration;

/**
 * Created by abc on 23-02-2018.
 */
public class ChildClass extends BaseClass {
    public void Test1()
    {
        System.out.println("I am in base class, test1");
    }
    public void Test4()
    {
        System.out.println("I am in base class, test4");
    }
    public void Test5()
    {
        System.out.println("I am in child class, test5");
    }

    public static void main(String [] args)
    {
        //senario 1: child class referene and child class object
        ChildClass ref1= new ChildClass();
        ref1.Test1();
        ref1.Test2();
        ref1.Test3();
        ref1.Test4();
        ref1.Test5();

        //scenario2: base class referene and base class object, java will not allow is scenario.
        //BaseClass ref2= new BaseClass();

        //scenario3: base class referene and child class object
        BaseClass ref3= new ChildClass();
        ref3.Test1();
        ref3.Test2();
        ref3.Test3();
        ref3.Test4();

        //scenario4: child class referene and base class object. java will not allow this scenario.
        //ChildClass ref4= new BaseClass();
    }
}
