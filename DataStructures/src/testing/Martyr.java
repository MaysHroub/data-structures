package testing;

public class Martyr implements Comparable<Martyr> {
	
	private String name, district, location;
	private char gender;
	private int age;
	
	public Martyr() {}
	
	public Martyr(String name, String district, String location, char gender, int age) {
		setName(name);
		setDistrict(district);
		setLocation(location);
		setGender(gender);
		setAge(age);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 0) throw new IllegalArgumentException("Invalid age value");
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		if (gender != 'F' && gender != 'M') 
			throw new IllegalArgumentException("We don't allow other genders here hhhh :)");
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public int compareTo(Martyr o) {
		int comp = district.compareToIgnoreCase(o.district);
		return (comp == 0) ? name.compareToIgnoreCase(o.name) : comp;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public static void heapSortAsc(Martyr[] a) {
		int N = a.length - 1;
		Martyr temp;
		
		maxHeapify(a);  // to a max-heap
		
		while (N > 1) {
			// 1. Swap the first element with the last element
			temp = a[1];
			a[1] = a[N];
			a[N] = temp;
			
			// 2. decrement N
			N--;
			
			// 3. sink[1]
			int k = 1;
			while (2*k <= N) {
				int j = 2*k;
				if (j < N && a[j].age < a[j+1].age) j++;
				if (a[k].age >= a[j].age) break;
				temp = a[k];
				a[k] = a[j];
				a[j] = temp;
				k = j;
			}
		}
	}
	
	public static void maxHeapify(Martyr[] a) {
		int N = a.length - 1, i = N / 2;
		Martyr temp;
		while (i-- > 0) {
			int k = i+1;
			while (2*k <= N) {
				int j = 2*k;
				if (j < N && a[j].compareTo(a[j+1]) < 0) j++;
				if (a[k].age >= a[j].age) break;
				temp = a[k];
				a[k] = a[j];
				a[j] = temp;
				k = j;
			}
		}
	}

}
