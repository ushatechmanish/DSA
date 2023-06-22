package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import binarysearch.BinarySearch;
import goodrich.arrays.ch3.CaesarCipher;
import goodrich.arrays.ch3.GameEntry;
import goodrich.arrays.ch3.InsertionSort;
import goodrich.arrays.ch3.RandomUtility;
import goodrich.arrays.ch3.Scoreboard;

public class UnitTests
{
	private BinarySearch binarySearch;
	RandomUtility randomUtility;
	InsertionSort insertionSort;
	CaesarCipher cipher;
	Random random;
	int rotation;
	int[] emptyArr =
	{};
	int[] arr2 =
	{ 1, 4, 7, 9, 20 };
	int[] arr3 =
	{ 1, 4, 7, 9, 20 };
	int[] arr4 =
	{ 1, 4, 7, 9, 20 };

	@BeforeEach
	public void setup()
	{
		binarySearch = new BinarySearch();
		randomUtility = new RandomUtility();
		insertionSort = new InsertionSort();
		random = new Random();
		rotation = random.nextInt(0, 10);
		cipher = new CaesarCipher(rotation);
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
		assertEquals("[1, 2]", Arrays.toString(insertionSort.sortAscending1(new int[]
		{ 2, 1 })));
		assertEquals("[]", Arrays.toString(insertionSort.sortAscending1(new int[]
		{})));
		assertEquals("[1]", Arrays.toString(insertionSort.sortAscending1(new int[]
		{ 1 })));
		assertEquals("[1, 1, 2, 3, 3, 4, 5]", Arrays.toString(insertionSort.sortAscending1(new int[]
		{ 1, 3, 4, 5, 1, 2, 3 })));
	}

	@Test
	public void testInsertionSortNew()
	{
		assertEquals("[1, 2]", Arrays.toString(insertionSort.sortAscending2(new int[]
		{ 2, 1 })));
		assertEquals("[]", Arrays.toString(insertionSort.sortAscending2(new int[]
		{})));
		assertEquals("[1]", Arrays.toString(insertionSort.sortAscending2(new int[]
		{ 1 })));
		assertEquals("[1, 1, 2, 3, 3, 4, 5]", Arrays.toString(insertionSort.sortAscending2(new int[]
		{ 1, 3, 4, 5, 1, 2, 3 })));
	}

	@Test
	public void testInsertionSortDesc1()
	{
		assertEquals("[2, 1]", Arrays.toString(insertionSort.sortDescending1(new int[]
		{ 2, 1 })));
		assertEquals("[]", Arrays.toString(insertionSort.sortDescending1(new int[]
		{})));
		assertEquals("[1]", Arrays.toString(insertionSort.sortDescending1(new int[]
		{ 1 })));
		assertEquals("[5, 4, 3, 3, 2, 1, 1]", Arrays.toString(insertionSort.sortDescending1(new int[]
		{ 1, 3, 4, 5, 1, 2, 3 })));
		assertEquals("[5, 4, 3]", Arrays.toString(insertionSort.sortDescending1(new int[]
		{ 3, 4, 5 })));
	}

	@Test
	public void testInsertionSortDesc2()
	{
		assertEquals("[2, 1]", Arrays.toString(insertionSort.sortDescending2(new int[]
		{ 2, 1 })));
		assertEquals("[]", Arrays.toString(insertionSort.sortDescending2(new int[]
		{})));
		assertEquals("[1]", Arrays.toString(insertionSort.sortDescending2(new int[]
		{ 1 })));
		assertEquals("[5, 4, 3, 3, 2, 1, 1]", Arrays.toString(insertionSort.sortDescending2(new int[]
		{ 1, 3, 4, 5, 1, 2, 3 })));
		assertEquals("[5, 4, 3]", Arrays.toString(insertionSort.sortDescending2(new int[]
		{ 3, 4, 5 })));
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
