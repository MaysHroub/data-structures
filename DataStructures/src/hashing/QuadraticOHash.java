package hashing;

public class QuadraticOHash<T extends Comparable<T>>  extends OpenAddressignHash<T> {
	
	public QuadraticOHash(int dataSize) {
		super(dataSize);
	}
	
	@Override
	public void add(T data) {
		int index = Math.abs(data.hashCode()) % m;
		int i = 0;
		for (; table[(index + i * (i++)) % m].getFlag() != Flag.EMPTY && i <= m; );
		if (i > m) // a loop occurred
			System.out.println("This element cannot be added");
		else {
			index = (index + (--i) * i) % m;
			table[index].setData(data);
			table[index].setFlag(Flag.FULL);
		}
	}
	
	@Override
	public HNode<T> find(T data) {
		int index = Math.abs(data.hashCode()) % m;
		int i = 0; Flag flag = table[(index + i*i) % m].getFlag();
		
		for (; flag == Flag.DELETED ||
				flag == Flag.FULL && table[(index + i*i) % m].getData().compareTo(data) != 0
				&& i <= m; // to avoid entering an infinite loop
				flag = table[(index + (++i) * i) % m].getFlag());
		
		if (flag == Flag.FULL && table[(index + i*i) % m].getData().compareTo(data) == 0)
			return table[(index + i*i) % m];
		
		return null;
	}
	
}
