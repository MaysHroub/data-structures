package testing;

public class Martyr implements Comparable<Martyr> {
	
	private String name, district, location;
	private char gender;
	
	public Martyr() {}
	
	public Martyr(String name, String district, String location, char gender) {
		setName(name);
		setDistrict(district);
		setLocation(location);
		setGender(gender);
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

}
