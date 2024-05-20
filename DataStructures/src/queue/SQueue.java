package queue;

import stack.LinkedListStack;

public class SQueue<T extends Comparable<T>> implements Queueable<T> {

	private LinkedListStack<T> items, temp;
	
	public SQueue() {
		items = new LinkedListStack<>();
		temp = new LinkedListStack<>();
	}
	
	@Override
	public void enqueue(T data) {
		while (!items.isEmpty()) 
			temp.push(items.pop());
		items.push(data);
		while (!temp.isEmpty()) 
			items.push(temp.pop());
	}

	@Override
	public T dequeue() {
		return items.pop();
	}

	@Override
	public T getFront() {
		return items.peek();
	}

	@Override
	public boolean isEmpty() {
		return items.isEmpty();
	}

	@Override
	public void clear() {
		items.clear();
	}

}
