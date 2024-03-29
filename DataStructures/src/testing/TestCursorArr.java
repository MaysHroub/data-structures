package testing;

import cursorarray.CursorArray;

public class TestCursorArr {

	public static void main(String[] args) {
		CursorArray<Integer> cursorArray = new CursorArray<>(101);
		cursorArray.traverse(0);
		
		int sl = cursorArray.createList();
		cursorArray.insertSorted(50, sl);
		cursorArray.insertSorted(60, sl);
		cursorArray.insertSorted(90, sl);
		cursorArray.insertSorted(40, sl);
		cursorArray.insertSorted(55, sl);
		cursorArray.insertSorted(99, sl);
		cursorArray.traverse(sl);
		
		int ml = cursorArray.createList();
		cursorArray.insertAtHead(1, ml);
		cursorArray.recursiveInsertAtTail(65, ml);
		cursorArray.recursiveInsertAtTail(97, ml);
		cursorArray.recursiveInsertAtTail(150, ml);
		cursorArray.recursiveTraverse(ml);
		
		int mergedl = cursorArray.merge(sl, ml);
		cursorArray.traverse(mergedl);
	}

}
