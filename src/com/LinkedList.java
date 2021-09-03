package com;

public class LinkedList<T>
{
    T data;
    LinkedList<T> next;

    public LinkedList(T data)
    {
        this.data = data;
    }

    public LinkedList<T> index(int idx)
    {
        var curr = this;
        for (int i = 0; i != idx; ++i)
        {
            if (curr.next == null)
                throw new IndexOutOfBoundsException();
            curr = curr.next;
        }
        return curr;
    }
    
    public void append(T data)
    {
        var newLink = new LinkedList<>(data);
        var curr = this;
        while (curr.next != null)
            curr = curr.next;
        curr.next = newLink;
    }
}
