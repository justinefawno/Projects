/**
 * Cipher handles the encryption and decryption of
 * messages according to the four-square cipher algorithm.
 *** @author (Justine Onnen)
 **@version (7)
 */

public class Cipher {
	private Square plainTopLeft;
	private Square plainBottomRight;
	private Square cipherTopRight;
	private Square cipherBottomLeft;

	/**
	 * Cipher creates the four squares based on
	 * two keys for the four-square cipher algorithm.
	 *
	 * @param key1 The first key (no Q's)
	 * @param key2 The second key (no Q's)
	 */
	public Cipher(String key1, String key2) {
		//COMPLETE THIS CONSTRUCTOR
		//CREATE plain1, plain2, cipher1, and cipher2
		plainTopLeft = new Square ();
		plainBottomRight = new Square ();
		cipherTopRight = new Square (key1);
		cipherBottomLeft = new Square (key2);
		
	} // end 2 arg constructor

	/**
	 * encrypt returns the encrypted message using the
	 * four-square cipher algorithm
	 *
	 * @param message The message to encrypt
	 *
	 * @return The encrypted message
	 */
	public String encrypt(String message) {
		//COMPLETE THIS METHOD
		message = message.toUpperCase().replaceAll(" ", "");
		String encryptedMessage = "";
		for (int i = 0 ; i < message.length(); i+=2)
		{
			char firstChar = message.charAt(i);
			char secondChar = message.charAt(i+1);
			int [] positionFirstChar = plainTopLeft.getPos(firstChar);
			int [] postionSecondChar = plainBottomRight.getPos(secondChar);
			int [] firstEncryption = new int [2];
			int [] secondEncryption = new int [2];
			firstEncryption[0] = positionFirstChar[0];
			firstEncryption[1] = postionSecondChar[1];
			secondEncryption[0] = postionSecondChar[0];
			secondEncryption[1] = positionFirstChar[1];
			char firstEncryptedChar = cipherTopRight.getChar(firstEncryption[0], firstEncryption[1]);
			char secondEncryptedChar = cipherBottomLeft.getChar(secondEncryption[0], secondEncryption[1]);
			encryptedMessage = encryptedMessage + firstEncryptedChar + secondEncryptedChar;
		}
		
		
		
		
		
		
		
		//RETURN THE ENCRYPTED message

		//UPDATE THIS LINE WHEN DONE
		return encryptedMessage;
	} // end encrypt

	/**
	 * decrypt returns the decrypted message using the
	 * four-square cipher algorithm
 	 *
	 * @param message The message to decrypt
	 *
	 * @return The decrypted message
	 */
	public String decrypt(String message) {
		//COMPLETE THIS METHOD
		message = message.toUpperCase().replaceAll(" ", "");
		String decryptedMessage = "";
		for (int i = 0 ; i < message.length(); i+=2)
		{
			char firstChar = message.charAt(i);
			char secondChar = message.charAt(i+1);
			int [] positionFirstChar = cipherTopRight.getPos(firstChar);
			int [] postionSecondChar = cipherBottomLeft.getPos(secondChar);
			int [] firstDecryption = new int [2];
			int [] secondDecryption = new int [2];
			firstDecryption[0] = positionFirstChar[0];
			firstDecryption[1] = postionSecondChar[1];
			secondDecryption[0] = postionSecondChar[0];
			secondDecryption[1] = positionFirstChar[1];
			char firstDecryptedChar = plainTopLeft.getChar(firstDecryption[0], firstDecryption[1]);
			char secondDecryptedChar = plainBottomRight.getChar(secondDecryption[0], secondDecryption[1]);
			decryptedMessage = decryptedMessage + firstDecryptedChar + secondDecryptedChar;
		}
		//RETURN THE DECRYPTED message

		//UPDATE THIS LINE WHEN DONE
		return decryptedMessage;
	} // end decrypt
} // end class