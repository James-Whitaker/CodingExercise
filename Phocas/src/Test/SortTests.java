package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import data.Data;
import data.Line;

class SortTests {

	@Test
	public void sortAgeTest1() {
		Data d = new Data();
		d.generateData(100);
		d.sortByAge(true, d.lines);
		for (int i = 0; i < d.lines.size() - 1; i++) {
			for (int j = i + 1; j < d.lines.size(); j++) {
				assert (d.lines.get(i).getAge() <= d.lines.get(j).getAge());
			}
		}
	}

	@Test
	public void sortAgeTest2() {
		Data d = new Data();
		d.generateData(100);
		d.sortByAge(false, d.lines);
		for (int i = 0; i < d.lines.size() - 1; i++) {
			for (int j = i + 1; j < d.lines.size(); j++) {
				assert (d.lines.get(i).getAge() >= d.lines.get(j).getAge());
			}
		}
	}

	@Test
	public void sortNameTest1() {
		Data d = new Data();
		d.generateData(10);
		d.sortByName(true, d.lines);
		for (int i = 0; i < d.lines.size() - 1; i++) {
			for (int j = i + 1; j < d.lines.size(); j++) {
				if (d.lines.get(i).getLastName().equals(d.lines.get(j).getFirstName())) {
					assert (d.lines.get(i).getFirstName().compareTo(d.lines.get(j).getFirstName()) <= 0);
				} else {
					assert (d.lines.get(i).getLastName().compareTo(d.lines.get(j).getLastName()) < 0);
				}
			}
		}
	}

	@Test
	public void sortNameTest2() {
		Data d = new Data();
		d.generateData(10);
		d.sortByName(false, d.lines);
		for (int i = 0; i < d.lines.size() - 1; i++) {
			for (int j = i + 1; j < d.lines.size(); j++) {
				if (d.lines.get(i).getLastName().equals(d.lines.get(j).getFirstName())) {
					assert (d.lines.get(i).getFirstName().compareTo(d.lines.get(j).getFirstName()) >= 0);
				} else {
					assert (d.lines.get(i).getLastName().compareTo(d.lines.get(j).getLastName()) > 0);
				}
			}
		}
	}

	@Test
	public void sortCountryTest1() {
		Data d = new Data();
		d.generateData(10);
		d.sortByCountry(true, d.lines);
		for (int i = 0; i < d.lines.size() - 1; i++) {
			for (int j = i + 1; j < d.lines.size(); j++) {
				assert (d.lines.get(i).getCountry().compareTo(d.lines.get(j).getCountry()) <= 0);
			}
		}
	}

	@Test
	public void sortCountryTest2() {
		Data d = new Data();
		d.generateData(10);
		d.sortByCountry(false, d.lines);
		for (int i = 0; i < d.lines.size() - 1; i++) {
			for (int j = i + 1; j < d.lines.size(); j++) {
				assert (d.lines.get(i).getCountry().compareTo(d.lines.get(j).getCountry()) >= 0);
			}
		}
	}
}
