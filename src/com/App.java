package com;

public class App 
{
    public static void main(String[] args) 
    {
        var list = new LinkedList<>(1);
        for (int i = 2; i != 11; ++i)
            list.append(i);
        var newhead = list.inverse();
        System.out.println(newhead);
    }
}
 