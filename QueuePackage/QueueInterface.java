package QueuePackage;

public interface QueueInterface<T>
{
    /** Adds a new entry to the back of the queue.
     * @param newEntry An object to be added */
    void enqueue(T newEntry);

    /** Removes and returns the entry at the front of this queue.
     * @return The object at the front of the queue
     * @throws EmptyQueueException if the queue is empty before the operation */
    T dequeue();

    /** Removes and returns the entry at the front of this queue.
     * @return The object at the front of the queue
     * @throws EmptyQueueException if the queue is empty */
    T getFront();

    /** Detects whether the queue is empty
     * @return True if the queue is empty, false otherwise */
    boolean isEmpty();

    /** Removes all entries from the queue*/
    void clear();
}
