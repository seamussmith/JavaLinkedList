package main;

public class App 
{
    public static void main(String[] args) 
    {
        System.out.println("Normal list: ");
        var normalList = new LinkedList<>(1);

        for (int i = 2; i != 10; ++i)
            normalList.add(i);

        System.out.println(normalList);
        var inversedNormalList = normalList.inverse();
        System.out.println(inversedNormalList);
        
        System.out.println("-----------------------------");

        System.out.println("Self-Linking list:");
        var selfLinkingList = new LinkedList<>(1);
        var tail = selfLinkingList;

        for (int i = 2; i != 10; ++i)
            tail = selfLinkingList.add(i);
        tail.next = selfLinkingList;

        System.out.println(selfLinkingList);
        var inversedSelfLinkingList = selfLinkingList.inverse();
        System.out.println(inversedSelfLinkingList);
    }
}
