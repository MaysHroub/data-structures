package hashing;

public class DoubleHashing<T extends Comparable<T>> extends OpenAddressignHash<T> {

	public DoubleHashing(int dataSize) {
		super(dataSize);
	}

	@Override
	public void add(T data) {
		if (size == m/2) rehash();
		int h1 = (short) Math.abs(data.hashCode()), h2 = (short) Math.abs((data.hashCode() >> 16));
		if (h2 == 0) h2 = 17;
		int i = 0;
		for (; table[Math.abs(h1 + (i++)*h2) % m].getFlag() != Flag.EMPTY && i <= m; collisions++);
		if (i > m) // a loop occurred
			System.out.println("This element cannot be added");
		else {
			int index = Math.abs(h1 + (--i)*h2) % m;
			table[index].setData(data);
			table[index].setFlag(Flag.FULL);
			++size;
		}
	}

	@Override
	public HNode<T> find(T data) {
		if (size == m/2) rehash();
		short h1 = (short) Math.abs(data.hashCode()), h2 = (short) Math.abs((data.hashCode() >> 16));
		if (h2 == 0) h2 = 17;
		int i = 0;
		Flag flag = table[(h1 + i*h2) % m].getFlag();
		for (; flag == Flag.DELETED ||
				flag == Flag.FULL && table[(h1 + i*h2) % m].getData().compareTo(data) != 0
				&& i <= m; // to avoid entering an infinite loop
				flag = table[(h1 + (++i)*h2) % m].getFlag());
		
		if (flag == Flag.FULL && table[(h1 + i*h2) % m].getData().compareTo(data) == 0)
			return table[(h1 + i*h2) % m];
		
		return null;
	}
	
	

}
