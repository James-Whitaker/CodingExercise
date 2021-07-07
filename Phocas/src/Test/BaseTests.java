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
	public void ImportTest1() {
		Data d = new Data();
		d.importFile("example.txt");
		assertEquals(d.lines.size(), 10);
		assert(d.lines.get(5).getAge() == 86);
	}
	
	@Test
	public void ImportTest2() {
		Data d = new Data();
		d.importData("[\n" +
		          	"{\"firstName\": \"Tudora\",\"lastName\": \"Leonaggeo\",\"age\": \"87\",\"id\": \"444150151\",\"country\": \"Jamaica\"},\n"+
		        	"{\"firstName\": \"Benone\",\"lastName\": \"Hallum\",\"age\": \"47\",\"id\": \"377604657\",\"country\": \"Nauru\"},\n"+
		        	"{\"firstName\": \"Nandor\",\"lastName\": \"Im\",\"age\": \"60\",\"id\": \"487739816\",\"country\": \"Maldives\"},\n"+
		        	"{\"firstName\": \"Alexandria\",\"lastName\": \"Akapo\",\"age\": \"23\",\"id\": \"571916731\",\"country\": \"Ivory Coast\"},\n"+
		        	"{\"firstName\": \"Grygoriy\",\"lastName\": \"Amble\",\"age\": \"22\",\"id\": \"790905608\",\"country\": \"Colombia\"},\n"+
		        	"{\"firstName\": \"Navidad\",\"lastName\": \"Ketchen\",\"age\": \"86\",\"id\": \"206612463\",\"country\": \"Antigua & Deps\"},\n"+
		        	"{\"firstName\": \"Ashly\",\"lastName\": \"Ned\",\"age\": \"59\",\"id\": \"193228565\",\"country\": \"Singapore\"},\n"+
		        	"{\"firstName\": \"Ramute\",\"lastName\": \"Infield\",\"age\": \"1\",\"id\": \"714157188\",\"country\": \"Brazil\"},\n"+
		        	"{\"firstName\": \"Heidrun\",\"lastName\": \"Refsal\",\"age\": \"7\",\"id\": \"304167355\",\"country\": \"Tonga\"},\n"+
		        	"{\"firstName\": \"Deimante\",\"lastName\": \"Kabba\",\"age\": \"52\",\"id\": \"87903371\",\"country\": \"Fiji\"},\n"+
		        "]");
		assertEquals(d.lines.size(), 10);
		assert(d.lines.get(5).getAge() == 86);
	}
	@Test
	public void ImportTest3() {
		Data d = new Data();
		d.importFile("example2.txt");
		assertEquals(d.lines.size(), 500);
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
