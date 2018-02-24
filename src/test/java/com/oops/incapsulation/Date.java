package com.oops.incapsulation;

/**
 * Created by abc on 22-02-2018.
 */
public class Date
{
    private int day;
    private int month;
    private int year;

    public void setDay(int day)
    {
        this.day=day;
    }

    public int getDay()
    {
        return day;
    }

    public void setMonth(int month)
    {
        this.month=month;
    }

    public int getMonth()
    {
        return month;
    }

    public void setYear(int year)
    {
        this.year=year;
    }

    public int getYear()
    {
        return year;
    }

    public static void main (String [] aa)
    {
        Date d= new Date();
        d.setDay(22);
        d.getDay();
        d.setMonth(2);
        d.getMonth();
        d.setYear(2018);
        d.getYear();

        System.out.println("DATE IS :: "+d.getDay()+"-"+d.getMonth()+"-"+d.getYear());

    }
}
