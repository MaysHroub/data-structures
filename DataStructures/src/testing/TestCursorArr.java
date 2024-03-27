package testing;

import cursorarray.CursorArray;

public class TestCursorArr {

	public static void main(String[] args) {
		CursorArray<Integer> cursorArray = new CursorArray<>(11);
		cursorArray.traverse(0);
		
		int ml = cursorArray.createList();
		cursorArray.insertAtHead(1, ml);
		cursorArray.recursiveInsertAtTail(5, ml);
		cursorArray.recursiveInsertAtTail(10, ml);
		cursorArray.recursiveInsertAtTail(15, ml);
		
		cursorArray.recursiveTraverse(ml);
		
		System.out.println(cursorArray.recursiveLength(ml));
		
		System.out.println(cursorArray.recursiveDeleteFromTail(ml));
		
		cursorArray.recursiveTraverse(ml);
		
		System.out.println(cursorArray.recursiveFind(5, ml));
		System.out.println(cursorArray.find(5, ml));
		
		System.out.println(cursorArray.findPrevious(10, ml));
		System.out.println(cursorArray.recursiveFindPrevious(10, ml));
		
		System.out.println(cursorArray.length(ml));
		System.out.println(cursorArray.recursiveLength(ml));
		
		System.out.println(cursorArray.recursiveLength(0));
		cursorArray.recursiveRemoveList(ml);
		System.out.println(cursorArray.recursiveLength(0));
	}

}
