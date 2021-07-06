package data;
/*
 * Names gotten from https://github.com/smashew/NameDatabases
 * Countries from https://gist.github.com/kalinchernev/486393efcca01623b18d
 */
import java.util.Random;
public class Line {
	private String firstName = "";
	private String lastName= "";
	private int age = 0;
	private int id = 0;
	private String country = "";
	//Constructor needs to be given id as it cannot be the same as any other
	public Line(int id) {
		this.id = id;
		firstName = Data.firstNames.get(new Random().nextInt(Data.firstNames.size()));
		lastName = Data.lastNames.get(new Random().nextInt(Data.lastNames.size()));
		age = new Random().nextInt(99);
		country = Data.countries.get(new Random().nextInt(Data.countries.size()));
	}
	
	public Line(String firstName, String lastName, int age, int id, String country) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.age = age;
		this.id = id;
	}
	//getters
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public int getAge() {
		return this.age;
	}
	public int getID() {
		return this.id;
	}
	public String getCountry() {
		return this.country;
	}
	
	public String toString() {
		String s = "{";
		s = s + "\"firstName\": \"" + firstName + "\",";
		s = s + "\"lastName\": \"" + lastName + "\",";
		s = s + "\"age\": \"" + age + "\",";
		s = s + "\"id\": \"" + id + "\",";
		s = s + "\"country\": \"" + country + "\"}";
		return s;
	}
}
