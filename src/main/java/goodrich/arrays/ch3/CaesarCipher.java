package goodrich.arrays.ch3;

// only for Capital Letters 

public class CaesarCipher
{
	char[] encoder = new char[26];
	char[] decoder = new char[26];

	public CaesarCipher(int rotation)
	{
		for (int i = 0; i < 26; ++i)
		{
			encoder[i] = (char) ('A' + (i + rotation) % 26);
			decoder[i] = (char) ('A' + (i - rotation + 26) % 26);
		}
//		System.out.println("encoder: " + new String(encoder));
//		System.out.println("decoder:" + new String(decoder));
	}

//	public static void main(String[] args)
//	{
//		System.out.println(new CaesarCipher(3).encrypt("HellO"));
//	}

	public String encrypt(String message)
	{
		return transform(message, encoder);
	}

	public String decrypt(String encryptedMessage)
	{
		return transform(encryptedMessage, decoder);
	}

	private String transform(String encryptedMessage, char[] coder)
	{
		char[] encyptedMessageArray = encryptedMessage.toCharArray();
		char[] result = new char[encryptedMessage.length()];
		for (int i = 0; i < encyptedMessageArray.length; ++i)
		{
			int codeCharacter = encyptedMessageArray[i];
			if (!Character.isUpperCase(codeCharacter))
			{
				throw new RuntimeException("Only Capital Letters Supported");
			}
			int j = codeCharacter - 'A';
			result[i] = coder[j];
		}
		return new String(result);
	}

}
