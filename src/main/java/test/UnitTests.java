package test;

import binarysearch.BinarySearch;
import binarysearch.BinarySearch2DArray;
import goodrich.arrays.ch3.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.BubbleSort;
import sort.CycleSort;
import sort.SelectionSort;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnitTests
{
	private BinarySearch binarySearch;
	private BinarySearch2DArray binarySearch2DArray;
	RandomUtility randomUtility;
	InsertionSort insertionSort;
	CaesarCipher cipher;
	Random random;
	BubbleSort bubbleSort;
	SelectionSort selectionSort;
	CycleSort cycleSort;
	int rotation;
	int[] emptyArr = {};
	int[] arr2 = { 1, 4, 7, 9, 20 };
	int[] arr3 = { 1, 4, 7, 9, 20 };
	int[] arr4 = { 1, 4, 7, 9, 20 };

	@BeforeEach
	public void setup()
	{
		binarySearch = new BinarySearch();
		randomUtility = new RandomUtility();
		insertionSort = new InsertionSort();
		random = new Random();
		rotation = random.nextInt(0, 10);
		cipher = new CaesarCipher(rotation);
		bubbleSort = new BubbleSort();
		binarySearch2DArray = new BinarySearch2DArray();
		selectionSort = new SelectionSort();
		cycleSort = new CycleSort();

	}

	@Test
	public void testSelectionSort()
	{
		int[] arr = { 20, 10, 3, 40 };
		selectionSort.sort(arr);
		assertEquals("[3, 10, 20, 40]", Arrays.toString(arr));

	}

	@Test
	public void testCycleSort()
	{
		int[] arr = { 1, 4, 2, 3 };
		cycleSort.sort1ToN(arr);
		assertEquals("[1, 2, 3, 4]", Arrays.toString(arr));
		arr = new int[] { 0, 1, 4, 2, 3 };
		cycleSort.sort0ToN(arr);
		assertEquals("[0, 1, 2, 3, 4]", Arrays.toString(arr));

	}

	@Test
	public void testBinarySearch2DArray()
	{
		int[][] arr = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 28, 29, 37, 49 }, { 33, 34, 38, 50 } };
		assertEquals("[1, 0]", Arrays.toString(binarySearch2DArray.binarySearchOrdered(arr, 15)));
		int[][] sortedArray = { { 2, 3, 4, 5 }, { 7, 8, 10, 13 }, { 14, 17, 19, 21 }, { 24, 25, 27, 30 } };
		assertEquals("[1, 1]", Arrays.toString(binarySearch2DArray.searchSortedArray(sortedArray, 8)));

	}

	@Test
	public void testSearch2DArray()
	{
		int[][] arr = new int[][] { { 18, 9, 12 }, { 36, -4, 91 }, { 44, 33, 16 } };
		assertEquals("[2, 1]", Arrays.toString(binarySearch2DArray.simpleSearch(arr, 33)));
	}

	@Test
	public void testBinarySearchAlgo()
	{

		assertEquals(Arrays.binarySearch(new int[] { 2, 3, 6 }, 5), binarySearch.search(new int[] { 2, 3, 6 }, 5));

		assertEquals(-2, binarySearch.search(new int[] { 6, 3, 2 }, 5));

	}

	@Test
	public void testGameEntry()
	{
		Scoreboard board = new Scoreboard(4);
		board.addEntry(new GameEntry("manish", 5));
		board.addEntry(new GameEntry("vineet", 10));
		board.addEntry(new GameEntry("vineet", 6));
		board.addEntry(new GameEntry("vineet", 4));
		board.addEntry(new GameEntry("vineet", -1));
		assertEquals("[10, 6, 5, 4]", board.toString());
		board.removeEntry(new GameEntry("vineet", 10));
		assertEquals("[6, 5, 4, null]", board.toString());
	}

	@Test
	public void testInsertionSort()
	{
		assertEquals("[1, 2]", Arrays.toString(insertionSort.sortAscending1(new int[] { 2, 1 })));
		assertEquals("[]", Arrays.toString(insertionSort.sortAscending1(new int[] {})));
		assertEquals("[1]", Arrays.toString(insertionSort.sortAscending1(new int[] { 1 })));
		assertEquals("[1, 1, 2, 3, 3, 4, 5]",
				Arrays.toString(insertionSort.sortAscending1(new int[] { 1, 3, 4, 5, 1, 2, 3 })));
	}

	@Test
	public void testBubbleSort()
	{
		assertEquals("[1, 2]", Arrays.toString(bubbleSort.sortAscending1(new int[] { 2, 1 })));
		assertEquals("[]", Arrays.toString(bubbleSort.sortAscending1(new int[] {})));
		assertEquals("[1]", Arrays.toString(bubbleSort.sortAscending1(new int[] { 1 })));
		assertEquals("[1, 1, 2, 3, 3, 4, 5]",
				Arrays.toString(bubbleSort.sortAscending1(new int[] { 1, 3, 4, 5, 1, 2, 3 })));
	}

	@Test
	public void testInsertionSortNew()
	{
		assertEquals("[1, 2]", Arrays.toString(insertionSort.sortAscending2(new int[] { 2, 1 })));
		assertEquals("[]", Arrays.toString(insertionSort.sortAscending2(new int[] {})));
		assertEquals("[1]", Arrays.toString(insertionSort.sortAscending2(new int[] { 1 })));
		assertEquals("[1, 1, 2, 3, 3, 4, 5]",
				Arrays.toString(insertionSort.sortAscending2(new int[] { 1, 3, 4, 5, 1, 2, 3 })));
	}

	@Test
	public void testInsertionSortDesc1()
	{
		assertEquals("[2, 1]", Arrays.toString(insertionSort.sortDescending1(new int[] { 2, 1 })));
		assertEquals("[]", Arrays.toString(insertionSort.sortDescending1(new int[] {})));
		assertEquals("[1]", Arrays.toString(insertionSort.sortDescending1(new int[] { 1 })));
		assertEquals("[5, 4, 3, 3, 2, 1, 1]",
				Arrays.toString(insertionSort.sortDescending1(new int[] { 1, 3, 4, 5, 1, 2, 3 })));
		assertEquals("[5, 4, 3]", Arrays.toString(insertionSort.sortDescending1(new int[] { 3, 4, 5 })));
	}

	@Test
	public void testInsertionSortDesc2()
	{
		assertEquals("[2, 1]", Arrays.toString(insertionSort.sortDescending2(new int[] { 2, 1 })));
		assertEquals("[]", Arrays.toString(insertionSort.sortDescending2(new int[] {})));
		assertEquals("[1]", Arrays.toString(insertionSort.sortDescending2(new int[] { 1 })));
		assertEquals("[5, 4, 3, 3, 2, 1, 1]",
				Arrays.toString(insertionSort.sortDescending2(new int[] { 1, 3, 4, 5, 1, 2, 3 })));
		assertEquals("[5, 4, 3]", Arrays.toString(insertionSort.sortDescending2(new int[] { 3, 4, 5 })));
	}

	@Test
	public void testTransformWithSmallLetters()
	{

		Throwable exception = assertThrows(RuntimeException.class, () -> {
			cipher.encrypt("Hello");
			;
		});

		assertEquals("Only Capital Letters Supported", exception.getMessage());
	}

	@Test
	public void testCryptography()
	{

		String message = randomUtility.getRandomMessage();
		System.out.println(String.format("Original Message with rotation %d is %s", rotation, message));
		String encryptedMessage = cipher.encrypt(message);
		System.out.println(String.format("encrypted Message with rotation %d is %s", rotation, encryptedMessage));
		String decryptedMessage = cipher.decrypt(encryptedMessage);
		System.out.println(String.format("decrypted Message with rotation %d is %s", rotation, decryptedMessage));
		assertEquals(message, decryptedMessage);

	}

}
