package goodrich.arrays.ch3;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomUtility
{
	public static void main(String[] args)
	{
		RandomUtility obj = new RandomUtility();
		Random rand = new Random(50);
		Random rand2 = new Random(System.currentTimeMillis());
		// this will always create a new sequence every time program is run
		System.out.println(rand.nextInt(0, 10));
		IntStream.range(0, 10).mapToObj(i -> obj.getRandomArrays(0, 8))
				.forEach(var -> System.out.println(Arrays.toString(var)));
		/**
		 * 50 is the seed . This generates pseudoRandom Number
		 * 
		 * A formula which can be used for creating a pseudoRandom number is
		 * 
		 * next = (a*cur +b)% n ; where a, b , n can be chosen .
		 * 
		 * For Math.random n value is taken 2^48
		 */
		System.out.println(rand.nextInt(10)); // this will not give 10 in any case . 10 is excluded
		rand.nextBoolean();// this will give random boolean value;
	}

	public int[] getRandomArrays(int startSize, int endSize)
	{
		int size = new Random(System.currentTimeMillis()).nextInt(startSize, endSize);
		int[] result = new int[size];
		for (int i = 0; i < size; ++i)
		{
			result[i] = -10 + (int) (Math.random() * 10);
		}
		return result;
	}

	public String getRandomMessage()
	{
		Random random = new Random();
		int messageLength = random.nextInt(10);
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < messageLength; ++i)
		{
			int randomIndexforChar = random.nextInt(0, 26);
			result.append((char) ('A' + randomIndexforChar));
		}
		return result.toString();
	}

}
