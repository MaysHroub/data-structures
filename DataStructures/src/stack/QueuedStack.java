package stack;

import queue.LinkedListQueue;

public class QueuedStack<T extends Comparable<T>> implements Stackable<T> {

	LinkedListQueue<T> queue;
    int size;

    public QueuedStack() {
        queue = new LinkedListQueue<>();
    }
    
	@Override
	public void push(T data) {
		queue.enqueue(data);
        size++;
	}

	@Override
	public T pop() {
		size--;
        for (int i = 0; i < size; i++) 
            queue.enqueue(queue.dequeue());
        return queue.dequeue();
	}

	@Override
	public T peek() {
		for (int i = 0; i < size - 1; i++) 
            queue.enqueue(queue.dequeue());
        T data = queue.dequeue();
        queue.enqueue(data);
        return data;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		size = 0;
		queue.clear();
	}

}
