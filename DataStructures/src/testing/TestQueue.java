package testing;

import java.util.Random;

import queue.SQueue;

public class TestQueue {

	public static void main(String[] args) {
		
		simulateSuperMarket();
		
	}
	
	
	static void simulateSuperMarket() {
		SQueue<Integer> sQueue = new SQueue<>();
		int total = 0, numOfProcessedCustomers = 0, sum = 0, pre = 0;
		Random rand = new Random();
		System.out.println("| min | in | total | out |");
		for (int m = 0; m <= 60; m++) {
			int numOfCustomers = rand.nextInt(4);
			if (numOfCustomers == 3) numOfCustomers = 0;
			if (numOfCustomers == 2) sQueue.enqueue(1);
			if (numOfCustomers != 0) sQueue.enqueue(1);
			total += numOfCustomers;
			if (numOfCustomers == 1) sum += pre;
			if (numOfCustomers == 2) sum += pre + pre + 1;
			Integer processedCustomer = sQueue.dequeue();
			if (processedCustomer != null) {
				total--;
				numOfProcessedCustomers++;
			}
			pre = total;
			System.out.printf("| %3d | %2d | %5d | %3d |\n", m, numOfCustomers, total, (processedCustomer == null) ? 0 : 1);
		}
		System.out.println("Number of processed customers: " + numOfProcessedCustomers);
		System.out.println("Number of remaining customers: " + total);
		System.out.println(sum);
		System.out.println("Average waiting time: " + sum / (double) numOfProcessedCustomers);
	}

}












