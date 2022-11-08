package com.company;

public class List <T>
{
    public List (T[] array)
    {
        elements = array;
        maxSize = array.length;
        size = 0;
    }

    public boolean isFull ()
    {
        return size >= maxSize;
    }

    public boolean isEmpty ()
    {
        return size == 0;
    }

    public void addFirst (T element)
    {
        add(0, element);
    }

    public void addLast (T element)
    {
        add(size, element);
    }

    public void add (int index, T element)
    {
        for (int i = size - 1; i >= index; i--)
            elements [i + 1] = elements [i];
        elements [index] = element;
        size++;
    }

    public T removeLast ()
    {
        return remove(size - 1);
    }


    // code to be written
     public T removeFirst ()
     {
        return remove(0);
     }

     public T remove(int index) {
        T deleted = elements[index];

        for (int i = index; i < size - 1; i++)
            elements [i] = elements [i + 1];
        size--;

        return deleted;
     }

    public String toString ()
    {
        StringBuffer strBuf = new StringBuffer ();
        for (int i = 0; i < size; i++)
        {
            strBuf.append (elements [i]);
            if (i < size - 1)
                strBuf.append (", ");
        }
        return strBuf.toString ();
    }

    private int maxSize;
    private int size;
    private T[] elements;
}

