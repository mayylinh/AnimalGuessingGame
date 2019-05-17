package StackPackage;

public interface StackInterface<T>
{
    public void push(T newEntry);
    public T pop();
    public T peek();
    public boolean isEmpty();
    public void clear();
    public char setResult(int result);
    public int getResult();
}