package cursorarray;

public class CursorArray<T extends Comparable<T>> {

	private CNode<T>[] arr;
	
	public CursorArray(int size) {
		arr = new CNode[size];
	}
	
	private void init() {
		for (int i = 0; i < arr.length - 1; i++)
			arr[i] = new CNode<>(null, i + 1);
		arr[arr.length - 1] = new CNode<>(null, 0);
	}
	
	
}
