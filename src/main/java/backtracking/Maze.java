package backtracking;

public class Maze
{

	public static void main(String[] args)
	{
		Maze maze = new Maze();
		System.out.println(maze.countWays(3, 3));
		maze.path("", 3, 3);

	}

	public int countWays(int row, int col)
	{
		if (row == 1 || col == 1)
		{
			return 1;
		}
		int left = countWays(row - 1, col);

		int right = countWays(row, col - 1);

		return left + right;
	}

	public void path(String p, int row, int col)
	{
		if (row == 1 && col == 1)
		{
			System.out.println(p);
			return;
		}
		if (row > 1)
			path(p + "D", row - 1, col);
		if (col > 1)
			path(p + "R", row, col - 1);

	}
}
