package goodrich.arrays.ch3;

import java.util.Arrays;

public class Scoreboard
{
	private GameEntry[] board; // [4,3,2]
	private int numberOfEntries;
	public Scoreboard(int capacity)
	{
		super();
		board = new GameEntry[capacity];
	}
	public void addEntry(GameEntry entry) // [3]
	{
		int score = entry.getScore();
		
		if(numberOfEntries<board.length || board[numberOfEntries-1].getScore()<score)
		{
			if(numberOfEntries<board.length)
			{
				++numberOfEntries;
			}
			// no item needs to be removed
			int index = numberOfEntries-1; // index = 2
			while(index>0 && board[index-1].getScore()<score)  // 2<3
			{
				board[index]=board[index-1];// [4 3 3]
				--index; // 1
			}
			// Now the index is before insert index position and as the next value has already been shifted
			// it is safe to insert the entry at index+1
			board[index]=entry;
		}
	}
	// returns the GameEntry to be removed
	public GameEntry removeEntry(GameEntry e)
	{
		GameEntry temp = e;
		int index=0;
		while(index<board.length && !e.equals(board[index]))
		{
			++index;
		}
		// Now the index is at the entry to be removed
		
		while((index+1)<board.length && (index+1)<numberOfEntries)
		{
			board[index]=board[index+1];
			++index;
		}
		board[index]=null;
		--numberOfEntries;
		return temp;
	}

	@Override
	public String toString()
	{
		return Arrays.toString(board);
	}
	
	
}
