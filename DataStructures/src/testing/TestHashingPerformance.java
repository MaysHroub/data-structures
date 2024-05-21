package testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import hashing.DoubleHashing;
import hashing.LinearOHash;
import hashing.Martyr;
import hashing.QuadraticOHash;
import hashing.SHash;

public class TestHashingPerformance {

	public static void main(String[] args) throws FileNotFoundException {
		SHash<Martyr> sHash = new SHash<>(2000);
		LinearOHash<Martyr> linearOHash = new LinearOHash<>(10000);
		QuadraticOHash<Martyr> quadraticOHash = new QuadraticOHash<>(10000);
		DoubleHashing<Martyr> doubleHashing = new DoubleHashing<>(10000);
		
		int numOfMartyrs = 0;
		File file = new File("C:\\Users\\ismae\\Downloads\\data_2.csv");
		
		try (Scanner in = new Scanner(new FileInputStream(file))) {
			in.nextLine(); // 0.name, 1.event, 2.age, 3.location, 4.district, 5.gender
			while (in.hasNext()) {
				String line = in.nextLine();
				numOfMartyrs++;
				Martyr martyr = Martyr.constructMartyr(line);
				
				if (martyr == null) continue;
				
				sHash.add(martyr);
				linearOHash.add(martyr);
				quadraticOHash.add(martyr);
				doubleHashing.add(martyr);
			}
		}
		
		System.out.println("Average length of linked lists in separate-chaining hashing: " + sHash.avgLength());
		System.out.println("------------------------");
		
		double avgCollisionsLinear = linearOHash.getCollisions() / (double) numOfMartyrs,
				avgCollisionsQuadratic = quadraticOHash.getCollisions() / (double) numOfMartyrs,
				avgCollisionsDouble = doubleHashing.getCollisions() / (double) numOfMartyrs;
		System.out.println("Average number of collisions in:");
		System.out.println("Linear Hashing: " + avgCollisionsLinear);
		System.out.println("Quadratic Hashing: " + avgCollisionsQuadratic);
		System.out.println("Double Hashing: " + avgCollisionsDouble);
	}
	
}















