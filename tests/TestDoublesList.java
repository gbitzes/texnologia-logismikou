package tests;

import doublesLibrary.*;

public class TestDoublesList {

	/* Test simple insertion. Owner: Giorgos */
	static void testInsertion() {
		DoublesList list = new DoublesList();
		list.insert(0, 0.1);
		list.insert(1, 0.2);

		double[] array = list.toArray();
		assert array.length == 2 && array[0] == 0.1 && array[1] == 0.2;
	
		list.insert(0, 0.5);
		array = list.toArray();
		assert array.length == 3 && array[0] == 0.5 && array[1] == 0.1 && array[2] == 0.2;
	}

	/* It attempt to insert at invalid positions, so it should throw exceptions. Owner: Giorgos */
	static void testFaultyInsertion() {
		DoublesList list = new DoublesList();
		try {
			list.insert(-1, 0.1); // should throw Exception
			assert false;
		}
		catch(IllegalArgumentException e) {
		}
		
		try {
			list.insert(0, 0.5);
			list.insert(1, 0.6);
			list.insert(5, 0.7); // should throw Exception
			assert false;
		}
		catch(IllegalArgumentException e) {
		}
	}

	/* Test a lot of insertions. Owner: Giorgos */
	static void testManyInsertions() {
		DoublesList list = new DoublesList();

		for(int i = 0; i <= 200; i++)
			list.insert(0, i+0.5);

		double[] array = list.toArray();
		for(int i = 0; i <= 200; i++)
			assert array[i] == (200-i)+0.5;

	}

	/* Runs all tests */
	public static void main(String[] args) {
		testInsertion();
		testFaultyInsertion();
		testManyInsertions();

		System.out.println("All tests run OK.");
	}


}


 
