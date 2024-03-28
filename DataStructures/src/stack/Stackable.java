package stack;

public interface Stackable<T> {
	
	void push(T data);
	T pop();
	T peek();
	boolean isEmpty();
	void clear();
	
}
