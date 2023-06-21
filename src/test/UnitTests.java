package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import binarysearch.BinarySearch;
import goodrich.arrays.ch3.GameEntry;
import goodrich.arrays.ch3.InsertionSort;
import goodrich.arrays.ch3.Scoreboard;

public class UnitTests
{
	private BinarySearch binarySearch;
	int[] emptyArr = {};
	int[] arr2 = {1,4,7,9,20};
	int[] arr3 = {1,4,7,9,20};
	int[] arr4 = {1,4,7,9,20};
	
	@BeforeEach
	public void setup()
	{
		binarySearch=new BinarySearch();
		
	}
	@Test
	public void testGameEntry()
	{
		Scoreboard board = new Scoreboard(4);
		board.addEntry(new GameEntry("manish", 5));
		board.addEntry(new GameEntry("vineet", 10 ));
		board.addEntry(new GameEntry("vineet", 6 ));
		board.addEntry(new GameEntry("vineet", 4 ));
		board.addEntry(new GameEntry("vineet", -1 ));		
		assertEquals("[10, 6, 5, 4]",board.toString());
		board.removeEntry(new GameEntry("vineet", 10 ));
		assertEquals("[6, 5, 4, null]",board.toString());
	}
	@Test
	public void testInsertionSort()
	{
		InsertionSort obj = new InsertionSort();
		assertEquals("[1, 2]",Arrays.toString(obj.sortAscending1(new int[] {2,1})) );
		assertEquals("[]",Arrays.toString(obj.sortAscending1(new int[] {})) );
		assertEquals("[1]",Arrays.toString(obj.sortAscending1(new int[] {1})) );
		assertEquals("[1, 1, 2, 3, 3, 4, 5]",Arrays.toString(obj.sortAscending1(new int[] {1,3,4,5,1,2,3})) );
	}
	@Test
	public void testInsertionSortNew()
	{
		InsertionSort obj = new InsertionSort();
		assertEquals("[1, 2]",Arrays.toString(obj.sortAscending2(new int[] {2,1})) );
		assertEquals("[]",Arrays.toString(obj.sortAscending2(new int[] {})) );
		assertEquals("[1]",Arrays.toString(obj.sortAscending2(new int[] {1})) );
		assertEquals("[1, 1, 2, 3, 3, 4, 5]",Arrays.toString(obj.sortAscending2(new int[] {1,3,4,5,1,2,3})) );
	}
	@Test
	public void testInsertionSortDesc1()
	{
		InsertionSort obj = new InsertionSort();
		assertEquals("[2, 1]",Arrays.toString(obj.sortDescending1(new int[] {2,1})) );
		assertEquals("[]",Arrays.toString(obj.sortDescending1(new int[] {})) );
		assertEquals("[1]",Arrays.toString(obj.sortDescending1(new int[] {1})) );
		assertEquals("[5, 4, 3, 3, 2, 1, 1]",Arrays.toString(obj.sortDescending1(new int[] {1,3,4,5,1,2,3})) );
		assertEquals("[5, 4, 3]",Arrays.toString(obj.sortDescending1(new int[] {3,4,5})) );
	}
	@Test
	public void testInsertionSortDesc2()
	{
		InsertionSort obj = new InsertionSort();
		assertEquals("[2, 1]",Arrays.toString(obj.sortDescending2(new int[] {2,1})) );
		assertEquals("[]",Arrays.toString(obj.sortDescending2(new int[] {})) );
		assertEquals("[1]",Arrays.toString(obj.sortDescending2(new int[] {1})) );
		assertEquals("[5, 4, 3, 3, 2, 1, 1]",Arrays.toString(obj.sortDescending2(new int[] {1,3,4,5,1,2,3})) );
		assertEquals("[5, 4, 3]",Arrays.toString(obj.sortDescending2(new int[] {3,4,5})) );
	}
}
