package Test;

import java.util.List;

import org.junit.jupiter.api.Test;

import data.Data;
import data.Line;

class QueryTests {

	@Test
	public void OldestTest1() {
		Data d = new Data();
		d.importFile("example.txt");
		int i = d.findOldest();
		assert (d.lines.get(i).getAge() == 87);
	}

	@Test
	public void OldestTest2() {
		Data d = new Data();
		int i = d.findOldest();
		assert (i == -1);
	}

	@Test
	public void YoungestTest1() {
		Data d = new Data();
		d.importFile("example.txt");
		int i = d.findYoungest();
		assert (d.lines.get(i).getAge() == 1);
	}

	@Test
	public void YoungestTest2() {
		Data d = new Data();
		int i = d.findYoungest();
		assert (i == -1);
	}

	@Test
	public void CountryTest1() {
		Data d = new Data();
		d.importFile("example2.txt");
		List<Line> l = d.getCountry("Argentina", d.lines);
		d.printLines(l);
		assert (l.size() == 12);
	}

	@Test
	public void CountryTest2() {
		Data d = new Data();
		d.importFile("example2.txt");
		List<Line> l = d.getCountry("a", d.lines);
		d.printLines(l);
		assert (l.isEmpty());
	}

	@Test
	public void CountTest1() {
		Data d = new Data();
		d.importFile("example2.txt");
		d.sortByCountry(true, d.lines);
		List<String> c = d.getCountryCount();
		assert (c.get(0).equals("Argentina->12"));
	}

	@Test
	public void CountTest2() {
		Data d = new Data();
		d.sortByCountry(true, d.lines);
		List<String> c = d.getCountryCount();
		assert (c.isEmpty());
	}

	@Test
	public void AgeGroupTest1() {
		Data d = new Data();
		d.importFile("example2.txt");
		List<List<Line>> ls = d.countryAgeGroups("Argentina", d.lines);
		assert(ls.get(0).size() == 2);
	}
	
	@Test
	public void AgeGroupTest2() {
		Data d = new Data();
		d.importFile("example2.txt");
		List<List<Line>> ls = d.countryAgeGroups("A", d.lines);
		assert(ls.get(0).isEmpty());
	}
	
	@Test
	public void AgeGroupTest3() {
		Data d = new Data();
		d.importFile("example.txt");
		List<List<Line>> ls = d.countryAgeGroups("Argentina", d.lines);
		assert(ls.get(0).isEmpty());
	}
}
