package goodrich.arrays.ch3;

import java.util.Objects;

public class GameEntry
{
	String name;
	int score;
	
	public GameEntry(String name, int score)
	{
		super();
		this.name = name;
		this.score = score;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getScore()
	{
		return score;
	}
	public void setScore(int score)
	{
		this.score = score;
	}
	@Override
	public String toString()
	{
		return Integer.toString(score);
	}
	@Override
	public int hashCode()
	{
		return Objects.hash(name, score);
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameEntry other = (GameEntry) obj;
		return Objects.equals(name, other.name) && score == other.score;
	}
	
}
