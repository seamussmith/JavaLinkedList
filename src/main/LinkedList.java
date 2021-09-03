package main;

public class LinkedList<T>
{
    public T data;
    public LinkedList<T> next;

    public LinkedList() {}
    public LinkedList(T data)
    {
        this.data = data;
    }
    public LinkedList(T data, LinkedList<T> next)
    {
        this.data = data;
        this.next = next;
    }
    public LinkedList(LinkedList<T> next)
    {
        this.next = next;
    }

    // Get the n-th node of the LinkedList
    public LinkedList<T> get(int idx)
    {
        // Index should not be lower than zero
        if (idx < 0)
            throw new IndexOutOfBoundsException();
        // Loop until i is the index.
        // If i is zero, the for loop just doesn't run and it just returns the linked list itself
        var curr = this;
        for (int i = 0; i != idx; ++i)
        {
            // If the next node is null, then the index is out of bounds. If we kept going, we would dereference a nullptr on the next itteration.
            if (curr.next == null)
                throw new IndexOutOfBoundsException();
            // Get the next node
            curr = curr.next;
        }
        // Once we exit the loop, curr will be the n-th nod.
        return curr;
    }
    // Sets the next property of the last node to a new node with the given data
    public void add(T data)
    {
        var newLink = new LinkedList<>(data);
        // Find the last node of the linked list
        var curr = this;
        while (curr.next != null)
            curr = curr.next;
        curr.next = newLink;
    }

    public LinkedList<T> insert(T data, int idx)
    {
        var insertionPoint = this.get(idx-1);
        var newNode = new LinkedList<>(data, insertionPoint.next);
        insertionPoint.next = newNode;
        return newNode;
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

    // Reverse all the links in the list
    // Reversing a linked list results the head of the list to become the tail
    // Returns the new head of the list
    public LinkedList<T> inverse()
    {
        LinkedList<T> curr = this;
        LinkedList<T> prev = null;
        while (curr != null)
        {
            // Preserve the original order of the two nodes
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
