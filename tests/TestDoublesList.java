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

	/* It attempts to insert at invalid positions, so it should throw exceptions. Owner: Giorgos */
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

	/* Test add value starting at index i. Owner: bitzesmichail */
	static void test1addNumAfter() {
		DoublesList list = new DoublesList();

		for(int i = 0; i <= 200; i++)
			list.insert(i, i);

		list.addNumAfter(100, 453.0);

		double[] array = list.toArray();
		for(int i = 0; i <= 99; i++) {
			assert array[i] == i;
		}

		for(int i = 100; i <= 200; i++) {
			assert array[i] == i + 453.0;
		}

		/* add 0.0 to all - nothing should change */
		list.addNumAfter(0, 0.0);

		double[] array2 = list.toArray();
		for(int i = 0; i <= 99; i++) {
			assert array2[i] == i;
		}

		for(int i = 100; i <= 200; i++) {
			assert array2[i] == i + 453.0;
		}
	}

	/* It attempts to add at invalid positions, so it should throw exceptions. Owner: bitzesmichail */
	static void test2addNumAfter() {
		DoublesList list = new DoublesList();
		try {
			list.addNumAfter(-1, 453.0); /* illegal index -1 */
			assert false;
		}
		catch(IllegalArgumentException e) {
		}
		
		try {
			list.insert(0, 0.1);
			list.insert(1, 0.2);
			list.addNumAfter(5, 0.3); /* illegal index 5 */
			assert false;
		}
		catch(IllegalArgumentException e) {
		}
	}

	/* Test subtract number starting at index. Owner: bitzesmichail */
	static void test1subtractNumAfter() {
		DoublesList list = new DoublesList();

		for(int i = 0; i <= 200; i++)
			list.insert(i, i);

		/* make all elements zero */
		for(int i = 200; i >= 0; i--)
			list.subtractNumAfter(i, i);

		/* the array should be empty */
		double[] array = list.toArray();
		assert array.length == 0;
	}

	/* It attempts to insert at invalid positions, so it should throw exceptions. Owner: bitzesmichail */
	static void test2subtractNumAfter() {
		DoublesList list = new DoublesList();
		try {
			list.subtractNumAfter(-1, 453.0); /* illegal index -1 */
			assert false;
		}
		catch(IllegalArgumentException e) {
		}
		
		try {
			list.insert(0, 0.1);
			list.insert(1, 0.2);
			list.subtractNumAfter(5, 0.3); /* illegal index 5 */
			assert false;
		}
		catch(IllegalArgumentException e) {
		}
	}

	/* Test removal of value 0.0 starting at all elements except the first(index 0). 
	   Owner: bitzesmichail */
	static void test3subtractNumAfter() {
		DoublesList list = new DoublesList();

		for(int i = 0; i <= 200; i++)
			list.insert(i, i);

		/* remove 0.0 from all elements starting at 1 */
		list.subtractNumAfter(1, 0.0);

		/* nothing should have changed */
		double[] array = list.toArray();
		for(int i = 0; i <= 200; i++)
			assert array[i] == i;
	}

	/* Runs all tests */
	public static void main(String[] args) {
		testInsertion();
		testFaultyInsertion();
		testManyInsertions();
		test1addNumAfter();
		test2addNumAfter();
		test1subtractNumAfter();
		test2subtractNumAfter();
		test3subtractNumAfter();

		System.out.println("All tests run OK.");
	}


}


 
