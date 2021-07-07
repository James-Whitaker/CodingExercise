package data;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Data d = new Data();
		d.init();
		Scanner sc = new Scanner(System.in);
		String temp;
		while (true) {
			System.out.print("Would you like to generate data or import a file?:");
			temp = sc.next();
			if (temp.equals("generate") || temp.equals("Generate") || temp.equals("g")) {
				System.out.print("How many lines?:");
				temp = sc.next();
				d.generateData(Integer.parseInt(temp));
				break;
			} else if (temp.equals("import") || temp.equals("Import") || temp.equals("i")) {
				System.out.print("Enter File Name:");
				temp = sc.next();
				if (d.importFile(temp)) {
					break;
				}
			} else {
				System.out.println("Invalid option :" + temp);
			}
		}

		d.printLines();
		System.out.println("Data successfully created");
		parse(d, sc);
		sc.close();
	}

	/*
	 * The main method for accepting user input. Honestly probably should have been
	 * several switches, but nesting them always looks weird.
	 */
	public static void parse(Data d, Scanner sc) {
		String temp;
		System.out.print("What would you like to do next?: ");
		temp = sc.next();
		if (temp.equals("Sort") || temp.equals("sort") || temp.equals("s")) {
			System.out.println("by Age, Name, or Country?:  ");
			temp = sc.next();
			if (temp.equals("Age") || temp.equals("age") || temp.equals("a")) {
				System.out.println("Start with young?:   ");
				temp = sc.next();
				if (temp.equals("Old") || temp.equals("old") || temp.equals("o") || temp.equals("false")
						|| temp.equals("no")) {
					d.sortByAge(false, d.lines);
					d.printLines();
					System.out.println("Sorted list: oldest to youngest");
				} else {
					d.sortByAge(true, d.lines);
					d.printLines();
					System.out.println("Sorted list: youngest to oldest");
				}
			} else if (temp.equals("Name") || temp.equals("name") || temp.equals("n")) {
				System.out.println("Alphabetically?:   ");
				temp = sc.next();
				if (temp.equals("Reverse") || temp.equals("reverse") || temp.equals("r") || temp.equals("false")
						|| temp.equals("no")) {
					d.sortByName(false, d.lines);
					d.printLines();
					System.out.println("Sorted list: names reverse alphabetically");
				} else {
					d.sortByName(true, d.lines);
					d.printLines();
					System.out.println("Sorted list: names alphabetically");
				}
			} else if (temp.equals("Country") || temp.equals("country") || temp.equals("c")) {
				System.out.println("Alphabetically?:   ");
				temp = sc.next();
				if (temp.equals("Reverse") || temp.equals("reverse") || temp.equals("r") || temp.equals("false")
						|| temp.equals("no")) {
					d.sortByCountry(false, d.lines);
					d.printLines();
					System.out.println("Sorted list: country reverse alphabetically");
				} else {
					d.sortByCountry(true, d.lines);
					d.printLines();
					System.out.println("Sorted list: country alphabetically");
				}
			}
		} else if (temp.equals("Find") || temp.equals("find") || temp.equals("f") || temp.equals("Get")
				|| temp.equals("get") || temp.equals("g")) {
			temp = sc.next();
			if (temp.equals("Old") || temp.equals("old") || temp.equals("o") || temp.equals("oldest")
					|| temp.equals("Oldest")) {
				d.findOldest();
				System.out.println("Oldest found");
			} else if (temp.equals("Young") || temp.equals("young") || temp.equals("y") || temp.equals("youngest")
					|| temp.equals("Youngest")) {
				d.findYoungest();
				System.out.println("Youngest found");
			} else if (temp.equals("Age") || temp.equals("age") || temp.equals("a") || temp.equals("g")
					|| temp.equals("groups")) {
				System.out.print("\tWhat country?: ");
				temp = sc.nextLine();
				temp = temp.substring(1, temp.length());
				System.out.println(temp);
				if (temp.equals("g") || temp.equals("groups") || temp.equals("Groups")) {
					temp = sc.nextLine();
					d.printAgeGroups(d.countryAgeGroups(temp, d.lines));
				} else {
					d.printAgeGroups(d.countryAgeGroups(temp, d.lines));
				}
			} else if (temp.equals("count") || temp.equals("Count") || temp.equals("c")) {
				d.getCountryCount();
			}
		} else if (temp.equals("generate") || temp.equals("Generate") || temp.equals("g")) {
			System.out.print("How many lines?:");
			temp = sc.next();
			d.generateData(Integer.parseInt(temp));
			System.out.println("New data generated");
		} else if (temp.equals("import") || temp.equals("Import") || temp.equals("i")) {
			System.out.print("Enter File Name:");
			temp = sc.next();
			if (!d.importFile(temp)) {
				System.out.println("File failed to load");
			} else {
				System.out.println("Data successfully loaded");
			}
		} else if (temp.equals("clear") || temp.equals("Clear") || temp.equals("c")) {
			d.clear();
			System.out.println("Lists emptied");
		} else if (temp.equals("exit") || temp.equals("Exit")) {
			d.clear();
			return;
		} else if (temp.equals("export") || temp.equals("Export")) {
			System.out.print("Enter the name of the new file: ");
			temp = sc.next();
			d.exportData(temp, d.lines);
			return;
		}else if (temp.equals("print") || temp.equals("Print") || temp.equals("p")) {
			d.printLines();;
			return;
		}
		parse(d, sc);
	}

}
