import java.util.*;

/**
 * Square represents one of the squares in the four-square cipher algorithm.
 ** @author (Justine Onnen)
 **@version (7)
 */

public class Square {
	private char[][] matrix;
	String allLetters = "ABCDEFGHIJKLMNOPRSTUVWXYZ";

	/**
	 * Square constructs a matrix with the letters A-Z, skipping Q.
	 */
	public Square() {
		// matrix = new char[5][5];

		// COMPLETE THIS CONSTRUCTOR
		/*
		 * char [][] matrix = { {'A','B','C','D','E'}, {'F','G','H','I','J'},
		 * {'K','L','M','N','O'}, {'P','R','S','T','U'}, {'V','W','X','Y','Z'} };
		 */
		this.matrix = createMatrixFromString(allLetters);

		// FILL matrix WITH A-Z, SKIPPING Q
	} // end no-arg constructor

	/**
	 * Square first puts the characters from key into the matrix, and then fills the
	 * matrix with the remaining letters (skipping Q).
	 *
	 * @param key
	 *            One of the encryption keys
	 */
	public Square(String key) {
		matrix = new char[5][5];
		// ArrayList <String> word = new ArrayList<String>();
		key = key.toUpperCase().replaceAll(" ", "");
		key = removeDups(key);

		String unusedLetters = allLetters;
		for (char letter : key.toCharArray()) {
			unusedLetters = unusedLetters.replace("" + letter, "");
		}

		String fullKey = key + unusedLetters;

		this.matrix = createMatrixFromString(fullKey);

		/*
		 * for (int i = 0; i < key.length(); i++) { int counter = 0; for (int j = 0; j <
		 * word.length(); j++) { if (key.charAt(i) != word.charAt(j)) { counter += 1;
		 * }//end checking for unique characters }//end inner for loop
		 * 
		 * if (counter == word.length()) { word += key.charAt(i); }//end if statement
		 * 
		 * }//end outer for loop
		 */
		/*
		 * Character nextLetter = null; for (int r = 0; r <= 5; r++) { for (int c = 0; c
		 * <= 5; c++) { if (r*5+c >= word.length()) { nextLetter = null; break; } else {
		 * nextLetter = word.charAt(r*5+c); matrix[r][c] = nextLetter; } }//end inner
		 * for loop if (nextLetter == null) { break; }
		 * 
		 * }//end outer for loop
		 */

		// COMPLETE THIS CONSTRUCTOR
		// FILL matrix WITH key, THEN REMAINING A-Z, SKIPPING Q
	} // end one-arg constructor

	/**
	 * getChar returns the character at a given row and column in the matrix.
	 *
	 * @param row
	 *            The row to look in
	 * @param col
	 *            The column to look in
	 *
	 * @return The character at (row, col)
	 */
	public char getChar(int row, int col) {
		// COMPLETE THIS METHOD
		// RETURN THE CHARACTER IN MATRIX AT POSITION row,col

		// UPDATE THIS LINE WHEN DONE
		return matrix[row][col];
	} // end getChar

	/**
	 * getPos returns the [row,col] position of the given character.
	 *
	 * @param c
	 *            The character to look for
	 *
	 * @return A 1D array holding the row and col of c stored in [0] and [1]
	 */
	public int[] getPos(char c) {
		// COMPLETE THIS METHOD
		// RETURN this array holding the row and col of c stored in [0] and [1],
		// respectively
		int[] pos = new int[2];
		// Search through matrix for 'c' and, when found
		// store row in pos[0] and col in pos[1]
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (matrix[i][j] == c) {
					pos[0] = i;
					pos[1] = j;
					return pos;
				}
			}
		}

		// If NOT found...
		// Leave this code in so that it will compile
		// Assuming char is found so don't need to
		// add code to handle if the char isn't found

		// character not found
		pos[0] = -1;
		pos[1] = -1;

		return pos;
	} // end getPos

	/**
	 * strContains returns whether the given string contains the given character
	 *
	 * @param str
	 *            The string to search
	 * @param c
	 *            The character to search for
	 *
	 * @return true if c is in str else false
	 */
	private boolean strContains(String str, char c) {

		// COMPLETE THIS METHOD (Optional, but strongly suggested)

		// REMOVE THIS LINE WHEN DONE
		return false;

	} // end strContains

	/*
	 * removeDups removes all duplicate characters from the string
	 *
	 * @param key The string to remove duplicates from
	 *
	 * @return The string with all duplicates removed
	 */
	private String removeDups(String key) {
		// COMPLETE THIS METHOD (Optional, but strongly suggested)
		String word = "";
		while (!key.isEmpty()) {
			char c = key.charAt(0);
			key = key.replace(c + "", "");
			word = word + c;
		}
		// REMOVE THIS LINE WHEN DONE
		return word;

	} // end removeDups

	public char[][] createMatrixFromString(String input) {
		if (input.length() != 25) {
			throw new RuntimeException("Wrong String Length: " + input);
		}

		char[][] newMatrix = new char[5][5];

		for (int index = 0; index < input.length(); index++) {
			newMatrix[index / 5][index % 5] = input.charAt(index);
		}

		return newMatrix;
	}

} // end class