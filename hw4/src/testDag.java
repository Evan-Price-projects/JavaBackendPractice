import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class testDag {

	
	@Test
	void test() {

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

}
