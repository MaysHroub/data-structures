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
		// TODO Auto-generated method stub
		
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
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
