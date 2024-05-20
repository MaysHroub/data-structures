package hashing;

public class LinearOHash<T extends Comparable<T>> {
	
	private HNode<T>[] table;
	private int m;
	
	@SuppressWarnings("unchecked")
	public LinearOHash(int dataSize) {
		m = dataSize * 2;
		for(; !isPrime(++m); );
		table = new HNode[m];
		for (int i = 0; i < m; i++)
			table[i] = new HNode<>(null);
	}
	
	public void add(T data) {
		int index = Math.abs(data.hashCode()) % m;
		int i = 0;
		for (; table[(index + i++) % m].getFlag() != Flag.EMPTY && i <= m; );
		if (i > m) // a loop occurred
			System.out.println("This element cannot be added");
		else {
			index = (index + --i) % m;
			table[index].setData(data);
			table[index].setFlag(Flag.FULL);
		}
	}
	
	public HNode<T> find(T data) {
		int index = Math.abs(data.hashCode()) % m;
		int i = 0; Flag flag = table[(index + i) % m].getFlag();
		
		for (; flag == Flag.DELETED ||
				flag == Flag.FULL && table[(index + i) % m].getData().compareTo(data) != 0
				&& i <= m; // to avoid entering an infinite loop
				flag = table[(index + ++i) % m].getFlag());
		
		if (flag == Flag.FULL && table[(index + i) % m].getData().compareTo(data) == 0)
			return table[(index + i) % m];
		
		return null;
	}
	
	public HNode<T> delete(T data) {
		HNode<T> deleted = find(data);
		if (deleted != null) deleted.setFlag(Flag.DELETED);
		return deleted;
	}
	
	private boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++)
			if (n % i == 0) return false;
		return true;
	}
	
	public void traverse() {
		for (int i = 0; i < m; i++) 
			if (table[i].getData() != null)
				System.out.print(i + "" + table[i] + " - ");
	}
	
}
