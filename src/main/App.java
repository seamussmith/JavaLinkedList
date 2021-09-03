package main;

public class App 
{
    public static void main(String[] args) 
    {
        var list = new LinkedList<>(1);
        for (int i = 2; i != 10; ++i)
            list.add(i);
        
        System.out.println(list);
        var inversed = list.inverse();
        System.out.println(inversed);        
    }
}
