package com;

public class LinkedList<T>
{
    public T data;
    public LinkedList<T> next;

    public LinkedList() {}
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

    @Override
    public String toString()
    {
        var sbuild = new StringBuilder();
        
        var curr = this;
        while (curr.next != null)
        {
            sbuild.append(String.format("[" + curr.data.toString() + "]->"));
            curr = curr.next;
        }
        sbuild.append("[" + curr.data.toString() + "]");
        return sbuild.toString();
    }

    public LinkedList<T> inverse()
    {
        LinkedList<T> curr = this;
        LinkedList<T> prev = null;
        while (curr != null)
        {
            var first = curr;
            var second = curr.next;

            first.next = prev;
            curr = second.next;
            prev = second;
            second.next = first;
        }
        return prev;
    }
}
