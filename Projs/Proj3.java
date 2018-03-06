/**
 * Justine Onnen
 * Due: September 28th
 * Instructor: Lang
 * Purpose: The program is to read in a file (and make sure it exists) to determine if the words in the file are palindrome.
 * this program also counts character, spaces, ect.
 */
import java.util.*;
import java.io.*;
public class Proj3 {
	public static void main(String[] args) throws IOException
	{
		//declaring variables---------------------------------------------------------
		Scanner s = new Scanner(System.in);
		String fileName;
		String[] wordsInFile;
		boolean postivePalindrome;
		List<String> palindromeArray = new ArrayList<String>();
		int totalWords = 0;
		//end declaration of variables------------------------------------------------

		fileName = getFileInfo();
		wordsInFile = readFile(fileName);
		for (int i = 0; i < wordsInFile.length; i++)
		{
			postivePalindrome = isPalindrome(wordsInFile[i]);
			if (postivePalindrome == true)
			{
				int j = 0;
				palindromeArray.add(wordsInFile[i]);
				j++;
			}
		}	
		int numOfChars = countCharacters(palindromeArray);
		int numOfLines = palindromeArray.size();
		
		for (int w = 0; w < palindromeArray.size(); w++)
		{
			totalWords += avgNumOfWords(palindromeArray.get(w));
		}
		int avgNumOfWords = totalWords/numOfLines;
		PrintWriter resultingFile = saveLine(palindromeArray, numOfLines, numOfChars, avgNumOfWords);
		saveResults(resultingFile, numOfChars, avgNumOfWords, numOfLines);
		displayResults(palindromeArray, numOfLines, numOfChars, avgNumOfWords);
	}//end main
	
	
	/** getFileInfo()
	 * This method gets the name of the file and makes sure it is a valid file name and loops if it is not
	 * no parameters pass to this method
	 * @return is returning the name of the file
	 */
	
	public static String getFileInfo()
	{
		Scanner s = new Scanner(System.in);
		
		String getFileName = null;
		
		boolean getValidFileName = false;
		//WHAT KIND OF LOOP SHOULD I USE????????
		
		do
		{
			System.out.print("Please enter the file name: ");
			getFileName = (s.nextLine() + ".txt");
		try
		{
			Scanner openFile = new Scanner(new File(getFileName));
			getValidFileName = true;
		}
		catch (FileNotFoundException ex)
		{
			System.out.println("File not found!");
			continue;
			
		}
		}while(getValidFileName == false);
		
		
		
		return getFileName;
	}//end method getting the file name and verifying the file name
	
	
	/** readFile()
	 * This method is to take all the words in the file and throw them into an array
	 * @param theFileName is the name of the file used to get words from
	 * @return is returning the word array to the main method; array contains all words in the file given
	 * @throws FileNotFoundException
	 */
	public static String[] readFile(String theFileName) throws FileNotFoundException
	{
		File file = new File(theFileName);
		Scanner inFile = new Scanner(file);
		//String[] wordArray = new String [];
		List<String> wordArray = new ArrayList<String>();
		
		/*do
		{
			wordArray[i] = inFile.nextLine();
			i++;
		}while((wordArray[i] = inFile.nextLine()) != null);*/
		 while (inFile.hasNextLine()) {
             String line = inFile.nextLine();
             wordArray.add(line);
         }
		inFile.close();
		return wordArray.toArray(new String[0]);
	}//end method that reads the file and places word in an array
	
	/** isPalindrome()
	 * This method is to determine whether or not an word is a palindrome
	 * 
	 * @param fileArray this parameter is one of the words of the array that contains all the words in it
	 * @return returns a boolean true or false to determine whether the word is or is not a palindrome
	 */
	public static boolean isPalindrome(String fileArray)
	{
		boolean answer = false;
		fileArray = fileArray.toLowerCase();
		String out = ",.- ";
		char[]ca = out.toCharArray();
		for (char c : ca)
			{
				fileArray = fileArray.replace(""+c, "");
			}
		
		if((fileArray.length()%2)==0)
		{
			int arrayCalculation = fileArray.length() / 2;
			int maxLength = fileArray.length()-1;
			int count = 0;
			for (int t = 0; t < arrayCalculation; t++)
			{
				char x = fileArray.charAt(t);
				char y = fileArray.charAt(maxLength);
				if (x==y)
				{
					count += 1;
					maxLength -= 1;
				}
			}
			if (count == arrayCalculation)
			{
				answer = true;
			}
		}//end finding palindrome for even number of letters
		else
		{
			int arrayCalculation2 = (fileArray.length()-1)/2;
			int minLength = arrayCalculation2;
			int maxLength2 = fileArray.length()-1;
			int count2 = 0;
			for (int t = 0; t < minLength; t++)
			{
				char u = fileArray.charAt(t);
				char q = fileArray.charAt(maxLength2);
				if (u==q)
				{
					count2 += 1;
					maxLength2 -= 1;
				}
			}
			if (count2 == arrayCalculation2)
			{
				answer = true;
			}
		}//end finding palindrome for odd number of letters
		return answer;
	}//end method determining if the word is a palindrome
	
	/**displayResults()
	 * This method displays all palindromes along with the stats found
	 * @param palindromeArray this param is all the palindromes in an array
	 * @param numOfLines this param is the number of lines that results.txt has
	 * @param numOfChars this param is the number of characters total in results.txt
	 * @param avgNumOfWords this param is the avg num of words in results.txt
	 */
	public static void displayResults(List<String> palindromeArray, int numOfLines, int numOfChars, int avgNumOfWords)
	{
		for (int i = 0; i < numOfLines; i++)
		{
			System.out.println(palindromeArray.get(i));
		}
		System.out.println("Input file contained a total of " + numOfChars + " characters");
		System.out.println("Input file contained a total of " + numOfLines + " lines");
		System.out.println("Input file contained on average of " + avgNumOfWords + " words per a line");
	}//end method for displaying the final results
	
	/**saveLine()
	 * this method is writing all the palindromes along with stats into results.txt
	 * @param palindromeArray this param is all the palindromes in an array
	 * @param numOfLines this param is the number of lines that results.txt has
	 * @param numOfChars this param is the number of characters total in results.txt
	 * @param avgNumOfWords this param is the avg num of words in results.txt
	 * @return this returns the file results.txt
	 * @throws FileNotFoundException
	 */
	public static PrintWriter saveLine(List<String> palindromeArray, int numOfLines, int numOfChars, int avgNumOfWords) throws FileNotFoundException
	{
		PrintWriter outputFile = new PrintWriter("Results.txt");
		for (int i = 0; i < palindromeArray.size(); i++)
		{
			outputFile.println(palindromeArray.get(i));
			
		}
		outputFile.println("Input file contained a total of " + numOfChars + " characters");
		outputFile.println("Input file contained a total of " + numOfLines + " lines");
		outputFile.println("Input file contained on average of " + avgNumOfWords + " words per a line");
		outputFile.flush();
		outputFile.close();
		return outputFile;
	}//end method for creating and writing individual Strings to the Results.txt file
	/**saveResults()
	 * this method prints the stats that we found
	 * 
	 * @param resultingFile this is the results.txt
	 * @param countingChars this is the total num of chars in results.txt
	 * @param countAvgWords this is the avg num of words per a line in results.txt
	 * @param countNumOfLines this is the total num of lines in results.txt
	 */
	public static void saveResults(PrintWriter resultingFile, int countingChars, int countAvgWords, int countNumOfLines)
	{
		resultingFile.println(countingChars);
		resultingFile.println(countAvgWords);
		resultingFile.println(countNumOfLines);
	}//end method for writing final summary stats (3 lines) to the Results.txt file
	
	/**countCharacters()
	 * this method is counting the number of characters in all words in the palindrome array
	 * @param palindromeArray this is the array that contains all palindromes
	 * @return returns the number of characters in the array
	 */
	public static int countCharacters(List<String> palindromeArray)
	{
		int count  = 0;
		for (int i = 0; i < palindromeArray.size(); i++)
		{
			count += palindromeArray.get(i).length();
		}
		return count;
	}
	
	/** avgNumOfWords
	 * this method is finding the approx. avg num of words per a line in the array
	 * @param palindromeArray this is the array of palindromes
	 * @return returns the avg num of words per a line in the array
	 */
	public static int avgNumOfWords(String palindromeArray)
	{
		int avg = 0;
		for (int u = 0; u < palindromeArray.length(); u++)
		{
			if ((palindromeArray.charAt(u)==' ')||(palindromeArray.charAt(u)=='-'))
			{
				avg += 1;
			}
			else
				avg = 1;
		}
		return avg;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//end overall class