package testing;

import queue_pack.SQueue;

public class TestQueue {

	public static void main(String[] args) {
		SQueue<Integer> sQueue = new SQueue<>();
		sQueue.enqueue(1);
		System.out.println(sQueue.dequeue());
		System.out.println(sQueue.getFront());
		System.out.println(sQueue.isEmpty());
		sQueue.enqueue(2);
		sQueue.enqueue(3);
		sQueue.enqueue(4);
		System.out.println(sQueue.dequeue());
		System.out.println(sQueue.dequeue());
		System.out.println(sQueue.getFront());
		System.out.println(sQueue.isEmpty());
		sQueue.clear();
		System.out.println(sQueue.getFront());
		System.out.println(sQueue.isEmpty());
	}

}
