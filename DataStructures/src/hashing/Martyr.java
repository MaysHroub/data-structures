package hashing;

import java.util.Date;

public class Martyr implements Comparable<Martyr> {
	
	private String name;
	private int age;
	private char gender;
	private Date event;

	public Martyr() { }
	
	public Martyr(String name, int age, char gender, Date event) {
		setName(name);
		setAge(age);
		setGender(gender);
		setEvent(event);
	}
	
	public Date getEvent() {
		return event;
	}

	public void setEvent(Date event) {
		this.event = event;
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

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Martyr)) return false;
		Martyr m = (Martyr) obj;
		return name.equalsIgnoreCase(m.name) && age == m.age; // check the name for the combo box selection
	}

	@Override
	public int compareTo(Martyr o) {
		return age - o.age;
	}
	
	// csv data : Name,Event,Age,Location,District,Gender
	public static Martyr constructMartyr(String csvData) {
		String[] data = csvData.split(",");
		if (data[0].toLowerCase().contains("unknown") || data[2].equals("") ||
				data[5].charAt(0) != 'F' && data[5].charAt(0) != 'M')
			return null;
		
		Martyr martyr = new Martyr();
		martyr.setName(data[0]);
		String[] dateInfo = data[1].split("/");
		@SuppressWarnings("deprecation")
		// mm/dd/yyyy
		Date date = new Date(Integer.parseInt(dateInfo[2])-1900, Integer.parseInt(dateInfo[0])-1, Integer.parseInt(dateInfo[1]));
		martyr.setEvent(date);
		martyr.setAge(Integer.parseInt(data[2])); 
		martyr.setGender(data[5].charAt(0));
		return martyr;
	}
	
	@Override
	public int hashCode() {
		int hash = 17;
		hash = 31*hash + name.hashCode();
		hash = 31*hash + event.hashCode();
		hash = 31*hash + ((Integer) age).hashCode();
		return hash;
	}
	

}


