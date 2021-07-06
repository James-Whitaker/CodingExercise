package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Data {
	public static List<String> firstNames;
	public static List<String> lastNames;
	public static List<String> countries;
	public List<Line> lines;
	public List<Integer> idList;

	public Data() {
		try {
			init();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Loads the name and country data from their respective files. Creates idList
	 * and lines
	 */
	public void init() throws FileNotFoundException {
		idList = new ArrayList<Integer>();
		lines = new ArrayList<Line>();
		Scanner sc0 = new Scanner(new File("first.txt"));
		firstNames = new ArrayList<String>();
		while (sc0.hasNextLine()) {
			firstNames.add(sc0.nextLine());
		}
		sc0.close();
		Scanner sc1 = new Scanner(new File("last.txt"));
		lastNames = new ArrayList<String>();
		while (sc1.hasNextLine()) {
			lastNames.add(sc1.nextLine());
		}
		sc1.close();
		Scanner sc2 = new Scanner(new File("countries.txt"));
		countries = new ArrayList<String>();
		while (sc2.hasNextLine()) {
			countries.add(sc2.nextLine());
		}
		sc2.close();
	}

	/*
	 * Generates and returns a list of num lines. Each line has a unique id, each of
	 * which is stored in idList. Each line also has a randomly generated first
	 * name, last name, country, and age. Names and countries are pulled from files
	 * of example names and countries, age is a random number.
	 */
	public List<Line> generateData(int num) {
		idList = new ArrayList<Integer>();
		lines = new ArrayList<Line>();
		if (num == 0) {
			return lines;
		}
		int id = new Random().nextInt(1000000000);
		idList.add(id);
		Line temp = new Line(id);
		lines.add(temp);
		for (int i = 1; i < num; i++) {
			id = new Random().nextInt(1000000000);
			while (idList.indexOf(id) >= 0) {
				id = new Random().nextInt(1000000000);
			}
			idList.add(id);
			temp = new Line(id);
			lines.add(temp);
		}
		return lines;
	}

	/*
	 * Empties the idList and lines.
	 */
	public void clear() {
		this.idList = new ArrayList<Integer>();
		this.lines = new ArrayList<Line>();
	}

	/*
	 * Outputs each line in the given list to the console.
	 */
	public void printLines(List<Line> lines) {
		System.out.println("[");
		for (int i = 0; i < lines.size() - 1; i++) {
			System.out.println("\t" + lines.get(i).toString() + ",");
		}
		if (lines.size() > 0) {
			System.out.println("\t" + lines.get(lines.size() - 1).toString());
		}
		System.out.println("]");
	}

	/*
	 * Outputs each line in lines to the console.
	 */
	public void printLines() {
		System.out.println("[");
		for (int i = 0; i < lines.size() - 1; i++) {
			System.out.println("\t" + lines.get(i).toString() + ",");
		}
		if (lines.size() > 0) {
			System.out.println("\t" + lines.get(lines.size() - 1).toString());
		}
		System.out.println("]");
	}

	/*
	 * Returns the index of the lines with the largest age. If multiple lines share
	 * the largest age, returns the one with the earliest index.
	 */
	public int findOldest() {
		int age = -1;
		int index = -1;
		if (lines.isEmpty()) {
			System.out.println("No data to query");
		}
		for (int i = 0; i < lines.size(); i++) {
			if (age < lines.get(i).getAge()) {
				age = lines.get(i).getAge();
				index = i;
			}
		}
		System.out.println(lines.get(index).toString());
		return index;
	}

	/*
	 * Returns the index of the lines with the smallest age. If multiple lines share
	 * the smallest age, returns the one with the earliest index.
	 */
	public int findYoungest() {
		int age = 1000;
		int index = -1;
		if (lines.isEmpty()) {
			System.out.println("No data to query");
		}
		for (int i = 0; i < lines.size(); i++) {
			if (age > lines.get(i).getAge()) {
				age = lines.get(i).getAge();
				index = i;
			}
		}
		System.out.println(lines.get(index).toString());
		return index;
	}

	/*
	 * Sorts the given list by age. If youngest is true, then the list will start
	 * with the youngest else it starts with the oldest.
	 */
	public void sortByAge(Boolean youngest, List<Line> lines) {
		int next;
		Line temp;
		// youngest to oldest
		if (youngest) {
			for (int i = 0; i < lines.size() - 1; i++) {
				next = i;
				for (int j = i + 1; j < lines.size(); j++) {
					if (lines.get(next).getAge() > lines.get(j).getAge()) {
						next = j;
					}
				}
				temp = lines.get(i);
				lines.set(i, lines.get(next));
				lines.set(next, temp);
			}
		}
		// oldest to youngest
		else {
			for (int i = 0; i < lines.size() - 1; i++) {
				next = i;
				for (int j = i + 1; j < lines.size(); j++) {
					if (lines.get(next).getAge() < lines.get(j).getAge()) {
						next = j;
					}
				}
				temp = lines.get(i);
				lines.set(i, lines.get(next));
				lines.set(next, temp);
			}
		}
	}

	/*
	 * Sorts the given list by name. If alph is true the list will be sorted
	 * alphabetically, if false it will be in reverse alphabetical order. The method
	 * organizes the list by last name and only checks first name if a last name is
	 * shared.
	 */
	public void sortByName(Boolean alph, List<Line> lines) {
		int next;
		Line temp;
		// alphabetical order
		if (alph) {
			for (int i = 0; i < lines.size() - 1; i++) {
				next = i;
				for (int j = i + 1; j < lines.size(); j++) {
					// if the two share a last name, checks first name
					if (lines.get(next).getLastName().equals(lines.get(j).getLastName())) {
						if (lines.get(next).getFirstName().compareTo(lines.get(j).getFirstName()) > 0) {
							next = j;
						}
					}
					if (lines.get(next).getLastName().compareTo(lines.get(j).getLastName()) > 0) {
						next = j;
					}
				}
				temp = lines.get(i);
				lines.set(i, lines.get(next));
				lines.set(next, temp);
			}
		}
		// reverse alphabetical order
		else {
			for (int i = 0; i < lines.size() - 1; i++) {
				next = i;
				for (int j = i + 1; j < lines.size(); j++) {
					// if the two share a last name, checks first name
					if (lines.get(next).getLastName().equals(lines.get(j).getLastName())) {
						if (lines.get(next).getFirstName().compareTo(lines.get(j).getFirstName()) < 0) {
							next = j;
						}
					}
					if (lines.get(next).getLastName().compareTo(lines.get(j).getLastName()) < 0) {
						next = j;
					}
				}
				temp = lines.get(i);
				lines.set(i, lines.get(next));
				lines.set(next, temp);
			}
		}

	}

	/*
	 * Sorts the given list by country. If alph is true the list will be sorted
	 * alphabetically, if false it will be in reverse alphabetical order.
	 */
	public void sortByCountry(Boolean alph, List<Line> lines) {
		int next;
		Line temp;
		// alphabetical order
		if (alph) {
			for (int i = 0; i < lines.size() - 1; i++) {
				next = i;
				for (int j = i + 1; j < lines.size(); j++) {
					if (lines.get(next).getCountry().compareTo(lines.get(j).getCountry()) > 0) {
						next = j;
					}
				}
				temp = lines.get(i);
				lines.set(i, lines.get(next));
				lines.set(next, temp);
			}
		}
		// reverse alphabetical order
		else {
			for (int i = 0; i < lines.size() - 1; i++) {
				next = i;
				for (int j = i + 1; j < lines.size(); j++) {
					if (lines.get(next).getCountry().compareTo(lines.get(j).getCountry()) < 0) {
						next = j;
					}
				}
				temp = lines.get(i);
				lines.set(i, lines.get(next));
				lines.set(next, temp);
			}
		}

	}

	/*
	 * prints the age groups of the given Lists. 
	 */
	public void printAgeGroups(List<List<Line>> lines) {
		for (int i = 0; i < lines.size() - 1; i++) {
			System.out.println((i * 10) + "-" + ((i + 1) * 10 - 1) + " :");
			System.out.println("\t[");
			for (int j = 0; j < lines.get(i).size() - 1; j++) {
				System.out.println("\t\t" + lines.get(i).get(j).toString() + ",");
			}
			if (lines.get(i).size() > 0) {
				System.out.println("\t\t" + lines.get(i).get(lines.get(i).size() - 1).toString());
			}
			System.out.println("\t],");
		}
		System.out.println("90-99 :");
		System.out.println("\t[");
		for (int j = 0; j < lines.get(9).size() - 1; j++) {
			System.out.println("\t\t" + lines.get(9).get(j).toString() + ",");
		}
		if (lines.get(9).size() > 0) {
			System.out.println("\t\t" + lines.get(9).get(lines.get(9).size() - 1).toString());
		}
		System.out.println("\t]");
	}

	/*
	 * returns age groups of a given country
	 */
	public List<List<Line>> countryAgeGroups(String country, List<Line> lines) {
		List<Line> temp = getCountry(country, lines);
		return getAgeGroups(temp);
	}

	/*
	 * Takes a list of lines and splits it into 10 lists by age. The first list has
	 * ages 0-9 then 10-19 etc.
	 */
	public List<List<Line>> getAgeGroups(List<Line> lines) {
		List<List<Line>> groups = new ArrayList<List<Line>>();
		for (int i = 0; i < 10; i++) {
			groups.add(getAgeGroup(i * 10, (i + 1) * 10 - 1, lines));
		}
		return groups;
	}

	/*
	 * takes 2 int and a list of lines and returns a list of the lines whose ages
	 * fall after or at the first int but at or before the second
	 */
	public List<Line> getAgeGroup(int start, int end, List<Line> lines) {
		List<Line> temp = new ArrayList<Line>();
		for (int i = 0; i < lines.size(); i++) {
			if (start <= lines.get(i).getAge() && lines.get(i).getAge() <= end) {
				temp.add(lines.get(i));
			}
		}
		return temp;
	}

	/*
	 * converts a text file in NDJSON format into a list of lines, sets global to
	 * the list
	 */
	public boolean importFile(String fileName) {
		File file = new File(fileName);
		List<Line> temp = new ArrayList<Line>();
		List<Integer> tempID = new ArrayList<Integer>();
		Scanner sc;
		String firstName;
		String lastName;
		String country;
		int age;
		int id;
		try {
			sc = new Scanner(file);
			String s = sc.nextLine();
			while (sc.hasNextLine()) {
				s = sc.nextLine();
				String[] elements = s.split("\"");
				// invalid values to break operation if not all are present
				firstName = null;
				lastName = null;
				country = null;
				age = -1;
				id = -1;
				// string is split by quotes, so each var name is followed by a colon then the
				// data.
				for (int i = 0; i < elements.length - 2; i++) {
					if (elements[i].equals("firstName")) {
						firstName = elements[i + 2];
						i += 2;
					} else if (elements[i].equals("lastName")) {
						lastName = elements[i + 2];
						i += 2;
					} else if (elements[i].equals("country")) {
						country = elements[i + 2];
						i += 2;
					} else if (elements[i].equals("age")) {
						age = Integer.parseInt(elements[i + 2]);
						i += 2;
					} else if (elements[i].equals("id")) {
						id = Integer.parseInt(elements[i + 2]);
						i += 2;
					}
				}
				// if not all values found
				if (firstName == null || lastName == null || country == null || age == -1 || id == -1) {
					if (!temp.isEmpty()) {
						lines = temp;
						idList = tempID;
						sc.close();
						return true;
					} else {
						System.out.println("Improperly formatted doc");
						sc.close();
						return false;
					}
				} else {
					temp.add(new Line(firstName, lastName, age, id, country));
					tempID.add(id);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("No file found with that name");
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * converts a string in NDJSON format into a list of lines, sets global to the
	 * list.
	 */
	public void importData(String data) {
		List<Line> temp = new ArrayList<Line>();
		Scanner sc = new Scanner(data);
		String firstName;
		String lastName;
		String country;
		int age;
		int id;
		String s = sc.nextLine();
		while (sc.hasNextLine()) {
			s = sc.nextLine();
			String[] elements = s.split("\"");
			// invalid values to break operation if not all are present
			firstName = null;
			lastName = null;
			country = null;
			age = -1;
			id = -1;
			// string is split by quotes, so each var name is followed by a colon then the
			// data.
			for (int i = 0; i < elements.length - 2; i++) {
				if (elements[i].equals("firstName")) {
					firstName = elements[i + 2];
					i += 2;
					while (!(elements[i].equals(",") || elements[i].equals("}") || elements[i].equals("},"))) {
						firstName += elements[i];
						i++;
					}
				} else if (elements[i].equals("lastName")) {
					lastName = elements[i + 2];
					i += 2;
					while (!(elements[i].equals(",") || elements[i].equals("}") || elements[i].equals("},"))) {
						lastName += elements[i];
						i++;
					}
				} else if (elements[i].equals("country")) {
					country = elements[i + 2];
					i += 2;
					while (!(elements[i].equals(",") || elements[i].equals("}") || elements[i].equals("},"))) {
						country += elements[i];
						i++;
					}
				} else if (elements[i].equals("age")) {
					age = Integer.parseInt(elements[i + 2]);
					i += 2;
				} else if (elements[i].equals("id")) {
					id = Integer.parseInt(elements[i + 2]);
					i += 2;
				}
			}
			// if not all values were found
			if (firstName == null || lastName == null || country == null || age == -1 || id == -1) {
				if (!temp.isEmpty()) {
					lines = temp;
					sc.close();
					return;
				} else {
					System.out.println("Improperly formatted doc");
					sc.close();
					return;
				}
			} else {
				temp.add(new Line(firstName, lastName, age, id, country));
			}
		}
		sc.close();
	}

	/*
	 * Exports the given list to a new file with the name fileName.txt. Returns true
	 * if successful.
	 */
	public boolean exportData(String fileName, List<Line> lines) {
		try {
			File myFile = new File(fileName + ".txt");
			if (myFile.createNewFile()) {
				FileWriter myWriter = new FileWriter(myFile);
				myWriter.append("[\n");
				for (int i = 0; i < lines.size() - 1; i++) {
					myWriter.append("\t" + lines.get(i).toString() + ",\n");
				}
				if (lines.size() > 0) {
					myWriter.append("\t" + lines.get(lines.size() - 1).toString() + "\n");
				}
				myWriter.append("]");
				myWriter.close();
				System.out.println("Data exported to " + myFile.getName());
				return true;
			} else {
				System.out.println("File already exists.");
				return false;
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			return false;
		}
	}

	/*
	 * Takes a string representing a country and a list of the data
	 * 
	 * returns a list containing only lines that have the given country
	 */
	public List<Line> getCountry(String country, List<Line> lines) {
		List<Line> temp = new ArrayList<Line>();
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).getCountry().equals(country)) {
				temp.add(lines.get(i));
			}
		}
		return temp;
	}

	/*
	 * Returns each country and the number of people in each
	 */
	public void getCountryCount() {
		List<String> countries = new ArrayList<String>();
		if (lines.isEmpty()) {
			System.out.println("No data to query");
			return;
		}
		countries.add(lines.get(0).getCountry());
		for (int i = 1; i < lines.size(); i++) {
			if (!countries.contains(lines.get(i).getCountry())) {
				countries.add(lines.get(i).getCountry());
			}
		}
		for (int i = 0; i < countries.size(); i++) {
			List<Line> temp = getCountry(countries.get(i), lines);
			System.out.println(countries.get(i) + "->" + temp.size());
		}
	}
}
