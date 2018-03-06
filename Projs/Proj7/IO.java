/**
 * IO handles all input and output for the
 * four-square encryption algorithm
 *** @author (Justine Onnen)
 **@version (7)
 */

import java.util.*;

public class IO {
	private Scanner s;

	/**
	 * IO sets up a new Scanner to System.in
	 */
	public IO() {
		s = new Scanner(System.in);
	}

	/**
	 * firstKey returns the first key from the user
	 *
	 * @return The first key from the user
	 */
	public String firstKey() {
		//COMPLETE THIS TO GET THE FIRST KEY
		System.out.print("Enter the first key word: ");
		String firstKeyWord = s.nextLine();
		//UPDATE THIS LINE WHEN DONE
		firstKeyWord = firstKeyWord.replaceAll(" ", "");
		boolean qFound = firstKeyWord.toUpperCase().contains("Q");
		if (qFound)
		{
			String error = "No 'q' is allowed in keys";
			printError(error);
		}
		while (qFound)
		{
			System.out.print("Enter the second key word: ");
			firstKeyWord = s.nextLine();
			qFound = firstKeyWord.toUpperCase().contains("Q");
			if (qFound)
			{
				String error = "No 'q' is allowed in keys";
				printError(error);
			}
		}
		return firstKeyWord;
	} // end firstKey


	/**
	 * secondKey returns the second key from the user
	 *
	 * @return The second key from the user
	 */
	public String secondKey() {
		//COMPLETE THIS TO GET THE SECOND KEY
		System.out.print("Enter the second key word: ");
		String secondKeyWord = s.nextLine();
		secondKeyWord = secondKeyWord.replaceAll(" ", "");
		boolean qFound = secondKeyWord.toUpperCase().contains("Q");
		if (qFound)
		{
			String error = "No 'q' is allowed in keys";
			printError(error);
		}
		while (qFound)
		{
			System.out.print("Enter the second key word: ");
			secondKeyWord = s.nextLine();
			qFound = secondKeyWord.toUpperCase().contains("Q");
			if (qFound)
			{
				String error = "No 'q' is allowed in keys";
				printError(error);
			}
		}
		//UPDATE THIS LINE WHEN DONE
		return secondKeyWord;
	} // end secondKey

	/**
	 * gets and returns whether the user wants to encrypt or decrypt
	 *
	 * @return 'e' for encryption, and 'd' for decryption
	 */
	public char encryptOrDecrypt() {
		//COMPLETE THIS TO GET THE ENCRYPT OR DECRYPT OPTION
		System.out.print("(e)ncrypt or (d)ecrypt: ");
		String userSelection = s.nextLine();
		//UPDATE THIS LINE WHEN DONE
		return userSelection.charAt(0);

	} // end encryptOrDecrypt

	/**
	 * message returns the message from the user
	 *
	 * @param encrypt True if encrypting, false if decrypting
	 *
	 * @return The message from the user
	 */
	public String message(boolean encrypt) {
		//COMPLETE THIS TO GET THE MESSAGE
		String reply;
		if (encrypt)
		{
			System.out.print("Enter message to encrypt: ");
			reply = s.nextLine();
			reply = reply.replaceAll(" ", "");
			boolean unevenNumbers = false;
			boolean qFound = reply.toUpperCase().contains("Q");
			if (reply.length()%2!=0)
			{
				unevenNumbers = true;
				String error = "Uneven amount of characters";
				printError(error);
			}
			if (qFound)
			{
				String error = "No 'q' is allowed in keys";
				printError(error);
			}
			while (qFound || unevenNumbers)
			{
				System.out.print("Enter the word to be encrypted: ");
				reply = s.nextLine();
				reply = reply.replaceAll(" ", "");
				qFound = reply.toUpperCase().contains("Q");
				if (qFound)
				{
					qFound = true;
					String error = "No 'q' is allowed in keys";
					printError(error);
				}
				else
				{
					qFound = false;
				}
				if (reply.length() % 2 != 0)
				{
					unevenNumbers = true;
					String error = "Uneven amound of characters";
					printError(error);
				}
				else
				{
					unevenNumbers = false;
				}
			}
		}
		else
		{
			System.out.print("Enter message to decrypt: ");
			reply = s.nextLine();
			reply = reply.replaceAll(" ", "");
			boolean unevenNumbers = false;
			boolean qFound = reply.toUpperCase().contains("Q");
			if (reply.length()%2!=0)
			{
				unevenNumbers = true;
				String error = "Uneven amount of characters";
				printError(error);
			}
			if (qFound)
			{
				String error = "No 'q' is allowed in keys";
				printError(error);
			}
			while (qFound || unevenNumbers)
			{
				System.out.print("Enter the word to be decrypted: ");
				reply = s.nextLine();
				qFound = reply.toUpperCase().contains("Q");
				if (qFound)
				{
					String error = "No 'q' is allowed in keys";
					printError(error);
				}
				if (reply.length() % 2 != 0)
				{
					unevenNumbers = true;
					String error = "Uneven amound of characters";
					printError(error);
				}
			}
		}
		
		
		
		//UPDATE THIS LINE WHEN DONE
		return reply;
	} // end message

	/**
	 * printResults prints the encrypted and decrypted messages
	 *
	 * @param msg The resulting message
	 * @param encrypt True if encrypting, false if decrypting
	 */
	public void printResults(String msg, boolean encrypt) {
		//COMPLETE THIS TO PRINT THE RESULTS
		if (encrypt)
		{
			System.out.println("The encrypted message is " + msg);
		}
		else
		{
			System.out.println("The decrypted message is " + msg);
		}
	} // end printResults

	/*
	 * printError prints an error message
	 *
	 * @param err The error message to print
	 */
	public void printError(String err) {
		//COMPLETE THIS TO PRINT THE ERROR MESSAGE
		//displayed when there is a q or odd number of characters or if those are in the key
		System.out.println("Error: bad input");
		System.out.println(err);
	} // end printError

} // end class