/**
 * This project implements the four-square cipher, allowing for
 * encryption and decryption.
 *
 * ** @author (Justine Onnen)
 **@version (7)
*/

public class Proj7 {
	public static void main(String[] args) {

// Complete the MAIN method
	// Get the KEYS and MESSAGE using IO class
		
		IO io = new IO();
		//create new IO object?
		String firstKey = io.firstKey();
		String secondKey = io.secondKey();
		
	// Pass KEYS to the CIPHER class to ENCRYPT/DECRYPT
		Cipher cipher = new Cipher(firstKey, secondKey);
		
	// Use CIPHER class to ENCRYPT/DECRYPT
		
		
		
		char option = io.encryptOrDecrypt();
		String message = io.message(option == 'e');
		if (option == 'e')
		{
			String encryptedMessage = cipher.encrypt(message);
			io.printResults(encryptedMessage, true);
		}
		else
		{
			String decryptedMessage = cipher.decrypt(message);
			io.printResults(decryptedMessage, false);
		}
		
		
		
	// Use IO class to display encrypted or decrypted message
		
		
 } // end main
} // end class