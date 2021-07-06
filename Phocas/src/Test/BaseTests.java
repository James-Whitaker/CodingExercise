package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import data.Data;
import data.Line;

class BaseTests {

	@Test
	public void generateTest1() {
		Data d = new Data();
		d.generateData(100);
		assertEquals(d.lines.size(), 100);
	}

	@Test
	public void generateTest2() {
		Data d = new Data();
		d.generateData(10);
		d.generateData(100);
		assertEquals(d.lines.size(), 100);
	}

	@Test
	public void generateTest3() {
		Data d = new Data();
		d.generateData(10);
		d.generateData(0);
		assert (d.lines.isEmpty());
	}

	@Test
	public void lineTest1() {
		Data d = new Data();
		d.generateData(1);
		Line l = d.lines.get(0);
		assert (l.getAge() >= 0);
		assert (l.getID() >= 0);
		assert (!l.getFirstName().isEmpty());
		assert (!l.getLastName().isEmpty());
		assert (!l.getCountry().isEmpty());
	}

	@Test
	public void lineTest2() {
		Data d = new Data();
		d.generateData(10000);
		for (int i = 0; i < d.lines.size() - 1; i++) {
			for (int j = i + 1; j < d.lines.size(); j++) {
				assert( d.lines.get(i).getID() != d.lines.get(j).getID());
			}
		}
	}
}
