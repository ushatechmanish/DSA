import goodrich.arrays.ch3.GameEntry;
import goodrich.arrays.ch3.Scoreboard;

public class Main
{

	public static void main(String[] args)
	{
		
		Scoreboard board = new Scoreboard(4);
		board.addEntry(new GameEntry("manish", 5));
		board.addEntry(new GameEntry("vineet", 10 ));
		board.addEntry(new GameEntry("vineet", 6 ));
		board.addEntry(new GameEntry("vineet", 4 ));
		board.addEntry(new GameEntry("vineet", -1 ));	
		System.out.println(board);
	}

}
