package hashing;

public class LinearOHash<T extends Comparable<T>> extends OpenAddressignHash<T>{
	
	public LinearOHash(int dataSize) {
		super(dataSize);
	}
	
	@Override
	public void add(T data) {
		if (size == m/2) rehash();
		int index = Math.abs(data.hashCode()) % m;
		int i = 0;
		for (; table[(index + i++) % m].getFlag() == Flag.FULL && i <= m; collisions++);
		if (i > m) // a loop occurred
			System.out.println("This element cannot be added");
		else {
			index = (index + --i) % m;
			table[index].setData(data);
			table[index].setFlag(Flag.FULL);
			++size;
		}
	}
	
	@Override
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
	
}
