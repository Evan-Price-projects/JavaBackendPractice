
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class test_Dag_remove {
	@Test
	void test1() {

		Integer[][] addElem = { { null, 5 }, { 5, 6 }, { 5, 4 }, { 6, 7 } };

		DAG<Integer> d = new DAG();
		for (int i = 0; i < addElem.length; i++) {
			d.add(addElem[i][0], addElem[i][1]);
		}
		
		///Remove some nodes
		d.remove(7);
		
		if( d.search(7) || (!d.search(6)))
			fail("Not yet implemented");
		
		Integer[][] expectedResult = { { 5, null }, { 5, 4 }, { 4, 5 }, {5, 6}, {6, 5} };
		
		ArrayList<Pair<Integer, Integer>> edgePairs = d.getEdgesArray();
		
		boolean exist = false;
		for (int i = 0; i < expectedResult.length; i++) {
			exist = false;
			for (Pair<Integer, Integer> elem : edgePairs) {
				if (elem.equals(new Pair(expectedResult[i][0], expectedResult[i][1]))) {
					exist = true;
					//System.out.println("Found pair: " + expectedResult[i][0] + ", " + expectedResult[i][1]);
					break;
				}
			}
			if (exist == false) {
				//System.out.println(" pair was not found: " + expectedResult[i][0] + ", " + expectedResult[i][1]);
				fail("Not yet implemented");

			}
		}
	}
	
	@Test
	void test2() {

		Integer[][] addElem = { { null, 5 }, { 5, 6 }, { 5, 4 }, { 6, 7 } };

		DAG<Integer> d = new DAG();
		for (int i = 0; i < addElem.length; i++) {
			d.add(addElem[i][0], addElem[i][1]);
		}
		
		///Remove some nodes
		d.remove(6);
		
		if(d.search(7) || d.search(6) || (!d.search(5)))
			fail("Not yet implemented");
		
		Integer[][] expectedResult = { { 5, null }, { 5, 4 }, { 4, 5 } };
		
		ArrayList<Pair<Integer, Integer>> edgePairs = d.getEdgesArray();
		
		boolean exist = false;
		for (int i = 0; i < expectedResult.length; i++) {
			exist = false;
			for (Pair<Integer, Integer> elem : edgePairs) {
				if (elem.equals(new Pair(expectedResult[i][0], expectedResult[i][1]))) {
					exist = true;
					//System.out.println("Found pair: " + expectedResult[i][0] + ", " + expectedResult[i][1]);
					break;
				}
			}
			if (exist == false) {
				//System.out.println(" pair was not found: " + expectedResult[i][0] + ", " + expectedResult[i][1]);
				fail("Not yet implemented");

			}
		}
	}
	
	@Test
	void test3() {

		Integer[][] addElem = { { null, 5 }, { null, 6 }, { null, 4 } };

		DAG<Integer> d = new DAG();
		for (int i = 0; i < addElem.length; i++) {
			d.add(addElem[i][0], addElem[i][1]);
		}
		
		//Remove
		d.remove(4);
		d.remove(6);
		if(d.search(6) || d.search(4))
			fail("Not yet implemented");
		Integer[][] expectedResult = { { 5, null } };
		
		ArrayList<Pair<Integer, Integer>> edgePairs = d.getEdgesArray();
		
		boolean exist = false;
		for (int i = 0; i < expectedResult.length; i++) {
			exist = false;
			for (Pair<Integer, Integer> elem : edgePairs) {
				if (elem.equals(new Pair(expectedResult[i][0], expectedResult[i][1]))) {
					exist = true;
					//System.out.println("Found pair: " + expectedResult[i][0] + ", " + expectedResult[i][1]);
					break;
				}
			}
			if (exist == false) {
				//System.out.println(" pair was not found: " + expectedResult[i][0] + ", " + expectedResult[i][1]);
				fail("Not yet implemented");

			}
		}
	}
	
	@Test
	void test4() {

		Integer[][] addElem = { { null, 5 },{null, 9}, { 5, 6 }, { 5, 4 }, { 6, 7 }, { 4, 6 } };

		DAG<Integer> d = new DAG();
		for (int i = 0; i < addElem.length; i++) {
			d.add(addElem[i][0], addElem[i][1]);
		}
		
		d.remove(5);
		Integer[][] expectedResult = { { 9, null } };
		
		if(d.search(5) || d.search(4) || d.search(6))
			fail("Not yet implemented");
		
		ArrayList<Pair<Integer, Integer>> edgePairs = d.getEdgesArray();
		
		boolean exist = false;
		for (int i = 0; i < expectedResult.length; i++) {
			exist = false;
			for (Pair<Integer, Integer> elem : edgePairs) {
				if (elem.equals(new Pair(expectedResult[i][0], expectedResult[i][1]))) {
					exist = true;
					//System.out.println("Found pair: " + expectedResult[i][0] + ", " + expectedResult[i][1]);
					break;
				}
			}
			if (exist == false) {
				//System.out.println(" pair was not found: " + expectedResult[i][0] + ", " + expectedResult[i][1]);
				fail("Not yet implemented");

			}
		}
	}
	
}
