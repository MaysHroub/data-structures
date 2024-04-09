package stack;

import cursorarray.CursorArray;

public class CursorStack<T extends Comparable<T>> implements Stackable<T> {
	
	private CursorArray<T> cursorArray;
	private int listIdx;
	
	public CursorStack(int size) {
		cursorArray = new CursorArray<>(size + 2); 
		listIdx = cursorArray.createList();
	}

	@Override
	public void push(T data) {
		if (!cursorArray.isEmpty(0))
			cursorArray.insertAtHead(data, listIdx);
		else
			System.out.println("stack is out of space");
	}

	@Override
	public T pop() {
		if (!isEmpty()) 
			return cursorArray.deleteFromHead(listIdx).getData();
		return null;
	}

	@Override
	public T peek() {
		if (!cursorArray.isEmpty(listIdx)) {
			T data = cursorArray.deleteFromHead(listIdx).getData();
			cursorArray.insertAtHead(data, listIdx);
			return data;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return cursorArray.isEmpty(listIdx);
	}

	@Override
	public void clear() {
		cursorArray.clear();
	}
	
}
