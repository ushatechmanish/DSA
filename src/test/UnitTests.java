package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import binarysearch.BinarySearch;
import goodrich.arrays.ch3.GameEntry;
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
	
}
