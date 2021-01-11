import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class test_Dag_Add {
	@Test
	void test1() {

		Integer[][] addElem = { { null, 5 }, { 5, 6 }, { 5, 4 }, { 6, 7 } };

		DAG<Integer> d = new DAG();
		for (int i = 0; i < addElem.length; i++) {
			d.add(addElem[i][0], addElem[i][1]);
		}

		Integer[][] expectedResult = { { 5, null }, { 5, 6 }, { 6, 5 }, { 5, 4 }, { 4, 5 }, { 6, 7 }, { 7, 6 } };
		
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
	
	
	//in the following test, we have an edge from 4 to 6, while 4 is not parent of 6
	@Test
	void test2() {

		Integer[][] addElem = { { null, 5 }, { 5, 6 }, { 5, 4 }, { 6, 7 }, { 4, 6 } };

		DAG<Integer> d = new DAG();
		for (int i = 0; i < addElem.length; i++) {
			d.add(addElem[i][0], addElem[i][1]);
		}

		Integer[][] expectedResult = { { 5, null }, { 5, 6 }, { 6, 5 }, { 5, 4 }, { 4, 5 }, { 6, 7 }, { 7, 6 }, { 4, 6 } };
		
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

		Integer[][] expectedResult = { { 5, null }, { 6, null }, { 4, null } };
		
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

		Integer[][] addElem = { { null, 5 }, { null, 12 }, { 5, 6 }, { 5, 4 }, { 6, 7 } };

		DAG<Integer> d = new DAG();
		for (int i = 0; i < addElem.length; i++) {
			d.add(addElem[i][0], addElem[i][1]);
		}

		Integer[][] expectedResult = { { 5, null }, { 12, null }, { 5, 6 }, { 6, 5 }, { 5, 4 }, { 4, 5 }, { 6, 7 }, { 7, 6 } };
		
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
	void test5() {

		Integer[][] addElem = { { null, 5 }, { 5, 6 }, { 6, 4 }, { 4, 7 }, {7, 3} };

		DAG<Integer> d = new DAG();
		for (int i = 0; i < addElem.length; i++) {
			d.add(addElem[i][0], addElem[i][1]);
		}

		Integer[][] expectedResult = { { 5, null }, { 5, 6 }, { 6, 5 }, { 6, 4 }, { 4, 6 }, { 4, 7 }, { 7, 4 }, {7, 3}, {3, 7} };
		
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
	void test6() {

		Integer[][] addElem = { { null, 5 }, { 5, 6 }, { 6, 4 }, { 4, 7 }, {7, 3}, {6, 7} };

		DAG<Integer> d = new DAG();
		for (int i = 0; i < addElem.length; i++) {
			d.add(addElem[i][0], addElem[i][1]);
		}

		Integer[][] expectedResult = { { 5, null }, { 5, 6 }, { 6, 5 }, { 6, 4 }, { 4, 6 }, { 4, 7 }, { 7, 4 }, {7, 3}, {3, 7}, {6, 7} };
		
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
	void test7() {

		Integer[][] addElem = { { null, 5 }, { 5, 6 }, { 6, 4 }, { 4, 7 }, {7, 3}, {6, 12}, {12, 3} };

		DAG<Integer> d = new DAG();
		for (int i = 0; i < addElem.length; i++) {
			d.add(addElem[i][0], addElem[i][1]);
		}

		Integer[][] expectedResult = { { 5, null }, { 5, 6 }, { 6, 5 }, { 6, 4 }, { 4, 6 }, { 4, 7 }, { 7, 4 }, {7, 3}, {3, 7},
				                         {6, 12}, {12, 6}, {12,3} };
		
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
				System.out.println(" pair was not found: " + expectedResult[i][0] + ", " + expectedResult[i][1]);
				fail("Not yet implemented");

			}
		}
	}
	
	
	

}
