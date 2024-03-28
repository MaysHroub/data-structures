package stack;

import java.lang.reflect.Array;

public class ArrayStack<T> implements Stackable<T> {
	
	private T[] arr;
	private int top;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(Class<T> clazz, int size) {
		arr = (T[]) Array.newInstance(clazz, size);
	}

	@Override
	public void push(T data) {
		if (top != arr.length)
			arr[top++] = data;
	}

	@Override
	public T pop() {
		if (isEmpty()) return null; 
		return arr[top--];
	}

	@Override
	public T peek() {
		if (isEmpty()) return null;
		return arr[top - 1];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
}
