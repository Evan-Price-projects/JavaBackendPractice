import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class test_Dag_search {

	@Test
	void test1() {

		Integer[][] addElem = { { null, 5 }, { 5, 6 }, { 5, 4 }, { 6, 7 } };

		DAG<Integer> d = new DAG();
		for (int i = 0; i < addElem.length; i++) {
			d.add(addElem[i][0], addElem[i][1]);
		}
		
		if( !d.search(7) || (!d.search(6)) || d.search(12))
			fail("Not yet implemented");
	}
	
	@Test
	void test2() {

		Integer[][] addElem = { { null, 5 }, { null, 12 }, { 5, 6 }, { 5, 4 }, { 6, 7 } };

		DAG<Integer> d = new DAG();
		for (int i = 0; i < addElem.length; i++) {
			d.add(addElem[i][0], addElem[i][1]);
		}
		if(!d.search(4) || !d.search(7) || d.search(33))
			fail("Not yet implemented");
	}
	
}
