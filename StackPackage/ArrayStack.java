package StackPackage;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements StackInterface<T>
{
    private T[] stack;
    private int topIndex;   // index of top entry
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int initialCapacity)
    {
        checkCapacity(initialCapacity);

        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
    }

    @Override
    public T pop()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        }
    }

    @Override
    public void push(T newEntry)
    {
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex ++;
    }

    @Override
    public T peek()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            return stack[topIndex];
        }
    }

    @Override
    public boolean isEmpty()
    {
        return topIndex < 0;
    }

    @Override
    public void clear()
    {
        for(int i = 0; i <= topIndex; i++)
        {
            stack[i] = null;
        }
        topIndex = -1;
    }

    private void ensureCapacity()
    {
        if(topIndex == stack.length - 1)
        {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        }
    }

    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
        {
            throw new IllegalStateException("Attempt to create a stack whose capacity exceeds allowed maximum");
        }
    }

    @Override
    public char setResult(int result)
    {
        return 0;
    }

    @Override
    public int getResult()
    {
        return 0;
    }
}
