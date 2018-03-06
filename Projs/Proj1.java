/*
 * Proj1.java
 * Justine Onnen
 * CIS 200 Scholar's Section
 * 
 * This program is a blackjack simulator with a play and test mode. This program allows for users to hit or stay and dealer operates functionally too.
 */


import java.util.*;
public class Proj1 {
	public static void main(String[] args) {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		int suitTypeDealer = 0, cardValueDealer = 0, totalUser = 0, totalDealer = 0;
		String suitDisplayDealer = "", higherCardDealer = "";
		
		int suitTypeUser = 0, cardValueUser = 0;
		String suitDisplayUser = "", higherCardUser = "";
		System.out.print("Enter player's name: ");
		String userName = sc.nextLine();
		System.out.print( "\n" );
		System.out.print("Do you want to enter P)lay mode or T)est mode? ");
		char userInput = sc.nextLine().charAt(0);
		System.out.print( "\n" );
		//set up an if-else statement that allows for if they select p then it goes the if, and if they select T then it goes if else mode
		int dealerAceIsThere1 = 0, dealerAceIsThere2 = 0, userAceIsThere1 = 0, userAceIsThere2 = 0;
		
		if (userInput == 'P' || userInput == 'p')
		{
			System.out.println("Dealer has:");
			for (int count = 0; count < 2; count++)
			{
			suitTypeDealer = r.nextInt(3);
			cardValueDealer = r.nextInt(11);
			suitTypeUser = r.nextInt(3);
			cardValueUser = r.nextInt(11);
			
			
			
			switch(suitTypeDealer) //switch statement handling random suit for dealer
			{
				case 0:
					suitDisplayDealer = (" of hearts");
					break;
				case 1:
					suitDisplayDealer = (" of spades");
					break;
				case 2:
					suitDisplayDealer = (" of clubs");
					break;
				case 3:
					suitDisplayDealer = (" of diamonds");
					break;
			} //end switch
			
			switch(cardValueDealer) //switch statement handling random card value for user
			{
				case 0:
					cardValueDealer = 1; //Reconsider how to handle this since it is an ace
					higherCardDealer = "Ace";
					dealerAceIsThere1 = 1;
					break;
				case 1:
					cardValueDealer = 2;
					higherCardDealer = "2";
					break;
				case 2:
					cardValueDealer = 3;
					higherCardDealer = "3";
					break;
				case 3:
					cardValueDealer = 4;
					higherCardDealer = "4";
					break;
				case 4:
					cardValueDealer = 5;
					higherCardDealer = "5";
					break;
				case 5:
					cardValueDealer = 6;
					higherCardDealer = "6";
					break;
				case 6:
					cardValueDealer = 7;
					higherCardDealer = "7";
					break;
				case 7:
					cardValueDealer = 8;
					higherCardDealer = "8";
					break;
				case 8:
					cardValueDealer = 9;
					higherCardDealer = "9";
					break;
				case 9:
					cardValueDealer = 10;
					higherCardDealer = "10";
				case 10:
					cardValueDealer = 10;
					higherCardDealer = ("Jack");
					break;
				case 11:
					cardValueDealer = 10;
					higherCardDealer = ("Queen");
					break;
				case 12:
					cardValueDealer = 10;
					higherCardDealer = ("King");
					break;
			} //end switch
			totalDealer = totalDealer + cardValueDealer;
			
			System.out.println("\t" + cardValueDealer + suitDisplayDealer);
			}//end for loop
	
			System.out.println("Dealer total: " + totalDealer);
			System.out.print( "\n" );
			System.out.println(userName + " has:");
			
			
			for (int count1 = 0; count1 < 2; count1++)
			{
				switch(suitTypeUser) //switch statement handling random suit for user
				{
					case 0:
						suitDisplayUser = (" of hearts");
						break;
					case 1:
						suitDisplayUser = (" of spades");
						break;
					case 2:
						suitDisplayUser = (" of clubs");
						break;
					case 3:
						suitDisplayUser = (" of diamonds");
						break;
				} //end switch
				
				switch(cardValueUser) //switch statement handling random card value for user
				{
					case 0:
						cardValueUser = 1; //Reconsider how to handle this since it is an ace
						higherCardUser = "Ace";
						userAceIsThere1 = 1;
						break;
					case 1:
						cardValueUser = 2;
						higherCardUser = "2";
						break;
					case 2:
						cardValueUser = 3;
						higherCardUser = "3";
						break;
					case 3:
						cardValueUser = 4;
						higherCardUser = "4";
						break;
					case 4:
						cardValueUser = 5;
						higherCardUser = "5";
						break;
					case 5:
						cardValueUser = 6;
						higherCardUser = "6";
						break;
					case 6:
						cardValueUser = 7;
						higherCardUser = "7";
						break;
					case 7:
						cardValueUser = 8;
						higherCardUser = "8";
						break;
					case 8:
						cardValueUser = 9;
						higherCardUser = "9";
						break;
					case 9:
						cardValueUser = 10;
						higherCardUser = "10";
					case 10:
						cardValueUser = 10;
						higherCardUser = ("Jack");
						break;
					case 11:
						cardValueUser = 10;
						higherCardUser = ("Queen");
						break;
					case 12:
						cardValueUser = 10;
						higherCardUser = ("King");
						break;
				} //end switch
				totalUser = totalUser + cardValueUser;
				System.out.println("\t" + cardValueUser + suitDisplayUser);
			} //end for loop
			System.out.println(userName + "'s total: " + totalUser);
			System.out.print( "\n" );
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
			
			
			
			
			System.out.print("Enter (h)it or (s)tay: ");
			char userDecision = sc.nextLine().charAt(0);
			
			if (userDecision == 'h' || userDecision == 'H')
			{
				suitTypeUser = r.nextInt(3);
				cardValueUser = r.nextInt(11);
				
				switch(cardValueUser) //switch statement handling random card value for user
				{
					case 0:
						cardValueUser = 1; //Reconsider how to handle this since it is an ace
						higherCardUser = "Ace";
						userAceIsThere1 = 1;
						break;
					case 1:
						cardValueUser = 2;
						higherCardUser = "2";
						break;
					case 2:
						cardValueUser = 3;
						higherCardUser = "3";
						break;
					case 3:
						cardValueUser = 4;
						higherCardUser = "4";
						break;
					case 4:
						cardValueUser = 5;
						higherCardUser = "5";
						break;
					case 5:
						cardValueUser = 6;
						higherCardUser = "6";
						break;
					case 6:
						cardValueUser = 7;
						higherCardUser = "7";
						break;
					case 7:
						cardValueUser = 8;
						higherCardUser = "8";
						break;
					case 8:
						cardValueUser = 9;
						higherCardUser = "9";
						break;
					case 9:
						cardValueUser = 10;
						higherCardUser = "10";
					case 10:
						cardValueUser = 10;
						higherCardUser = ("Jack");
						break;
					case 11:
						cardValueUser = 10;
						higherCardUser = ("Queen");
						break;
					case 12:
						cardValueUser = 10;
						higherCardUser = ("King");
						break;
				} //end switch
				
				switch(suitTypeUser) //switch statement handling random suit for user
				{
					case 0:
						suitDisplayUser = (" of hearts");
						break;
					case 1:
						suitDisplayUser = (" of spades");
						break;
					case 2:
						suitDisplayUser = (" of clubs");
						break;
					case 3:
						suitDisplayUser = (" of diamonds");
						break;
				} //end switch
				System.out.print( "\n" );
				System.out.println(userName + " draws: " + higherCardUser + suitDisplayUser);
				totalUser = totalUser + cardValueUser;
				} //end if for hit mode
						
				if (totalDealer < 17)
				{
					suitTypeDealer = r.nextInt(3);
					cardValueDealer = r.nextInt(11);
					
					switch(suitTypeDealer) //switch statement handling random suit for dealer
					{
						case 0:
							suitDisplayDealer = (" of hearts");
							break;
						case 1:
							suitDisplayDealer = (" of spades");
							break;
						case 2:
							suitDisplayDealer = (" of clubs");
							break;
						case 3:
							suitDisplayDealer = (" of diamonds");
							break;
					} //end switch
					
					switch(cardValueDealer) //switch statement handling random card value for user
					{
						case 0:
							cardValueDealer = 1; //Reconsider how to handle this since it is an ace
							higherCardDealer = "Ace";
							dealerAceIsThere1 = 1;
							break;
						case 1:
							cardValueDealer = 2;
							higherCardDealer = "2";
							break;
						case 2:
							cardValueDealer = 3;
							higherCardDealer = "3";
							break;
						case 3:
							cardValueDealer = 4;
							higherCardDealer = "4";
							break;
						case 4:
							cardValueDealer = 5;
							higherCardDealer = "5";
							break;
						case 5:
							cardValueDealer = 6;
							higherCardDealer = "6";
							break;
						case 6:
							cardValueDealer = 7;
							higherCardDealer = "7";
							break;
						case 7:
							cardValueDealer = 8;
							higherCardDealer = "8";
							break;
						case 8:
							cardValueDealer = 9;
							higherCardDealer = "9";
							break;
						case 9:
							cardValueDealer = 10;
							higherCardDealer = "10";
						case 10:
							cardValueDealer = 10;
							higherCardDealer = ("Jack");
							break;
						case 11:
							cardValueDealer = 10;
							higherCardDealer = ("Queen");
							break;
						case 12:
							cardValueDealer = 10;
							higherCardDealer = ("King");
							break;
					} //end switch
					totalDealer = totalDealer + cardValueDealer;
			
					System.out.println("Dealer draws: " + higherCardDealer + suitDisplayDealer);
				} //end of dealer draws
				else
				{
					System.out.println("Dealer stays");
				} //end of dealer staying
			
				if (userDecision == 's' || userDecision == 'S')
				{
					System.out.println(userName + " stays");
				} //end of stay decision
				
				if (userAceIsThere1 == 1 && totalUser == 11)
				{
					totalUser = 21;
				}
				if(userAceIsThere1 == 1 && totalUser < 11)
				{
					totalUser = (totalUser - 1) + 11;
				}
				
				if (dealerAceIsThere1 == 1 && totalDealer == 11)
				{
					totalDealer = 21;
				}
				if (dealerAceIsThere1 == 1 && totalDealer < 11)
				{
					totalDealer = (totalDealer - 1) + 11;
				}
				System.out.print( "\n" );
				System.out.println(userName + "'s total: " + totalUser);
				System.out.println("Dealer's total: " + totalDealer);
				System.out.print( "\n" );
				if (totalDealer > totalUser && totalDealer < 22)
				{
					System.out.println("Dealer Wins.");
				}
				else if (totalUser > totalDealer && totalUser < 22)
				{
				System.out.println(userName + " Wins!");
				}
				else if (totalDealer > 21 && totalUser < 22)
				{
					System.out.println(userName + " Wins!");
				}
				else if (totalUser > 21 && totalDealer < 22)
				{
					System.out.println("Dealer Wins.");
				}
				else if (totalUser == totalDealer)
				{
					System.out.println("It is a tie, house wins.");
				} //end if statements concerning ending totals
				else
				{
					System.out.println("Both bust, house wins.");
				}
			} //end if for play mode
		else if (userInput == 'T' || userInput == 't')
		{
			System.out.print("Enter a first face value for user: ");
			int userFirstValue = sc.nextInt();
			System.out.print("Enter a second face value for user: ");
			int userSecondValue = sc.nextInt();
			System.out.print("Enter a first face value for dealer: ");
			int dealerFirstValue = sc.nextInt();
			System.out.print("Enter a second face value for dealer: ");
			int dealerSecondValue = sc.nextInt();
			System.out.print( "\n" );
			int suitTypeDealer1 = r.nextInt(3);
			int suitTypeUser1 = r.nextInt(3);
			int suitTypeDealer2 = r.nextInt(3);
			int suitTypeUser2 = r.nextInt(3);
			String suitDisplayDealer1 = "", suitDisplayDealer2 = "", suitDisplayUser1 = "", suitDisplayUser2 = "";
			
			switch(suitTypeDealer1) //switch statement handling random suit for dealer
			{
				case 0:
					suitDisplayDealer1 = (" of hearts");
					break;
				case 1:
					suitDisplayDealer1 = (" of spades");
					break;
				case 2:
					suitDisplayDealer1 = (" of clubs");
					break;
				case 3:
					suitDisplayDealer1 = (" of diamonds");
					break;
			} //end switch
			
			switch(suitTypeUser1) //switch statement handling random suit for user
			{
				case 0:
					suitDisplayUser1 = (" of hearts");
					break;
				case 1:
					suitDisplayUser1 = (" of spades");
					break;
				case 2:
					suitDisplayUser1 = (" of clubs");
					break;
				case 3:
					suitDisplayUser1 = (" of diamonds");
					break;
			} //end switch
			
			switch(suitTypeDealer2) //switch statement handling random suit for dealer
			{
				case 0:
					suitDisplayDealer2 = (" of hearts");
					break;
				case 1:
					suitDisplayDealer2 = (" of spades");
					break;
				case 2:
					suitDisplayDealer2 = (" of clubs");
					break;
				case 3:
					suitDisplayDealer2 = (" of diamonds");
					break;
			} //end switch
			
			switch(suitTypeUser2) //switch statement handling random suit for user
			{
				case 0:
					suitDisplayUser2 = (" of hearts");
					break;
				case 1:
					suitDisplayUser2 = (" of spades");
					break;
				case 2:
					suitDisplayUser2 = (" of clubs");
					break;
				case 3:
					suitDisplayUser2 = (" of diamonds");
					break;
			} //end switch
			
			if(dealerFirstValue == 1 || dealerSecondValue == 1)
			{
				dealerAceIsThere2 = 1;
			}
			
			if(userFirstValue == 1 || userSecondValue == 1)
			{
				userAceIsThere2 = 1;
			}
			System.out.println("Dealer has: ");
			System.out.println(dealerFirstValue + suitDisplayDealer1);
			System.out.println(dealerSecondValue + suitDisplayDealer2);
			System.out.print( "\n" );
			System.out.println(userName + " has: ");
			System.out.println(userFirstValue + suitDisplayUser1);
			System.out.println(userSecondValue + suitDisplayUser2);
			totalUser = userFirstValue + userSecondValue;
			totalDealer = dealerFirstValue + dealerSecondValue;
			System.out.print( "\n" );
			System.out.println(userName + "'s total: " + totalUser);
			System.out.println("Dealer's total: " + totalDealer);
			
			System.out.print( "\n" );
			System.out.print("Enter (h)it or (s)tay: ");
			char userDecision1 = sc.next().charAt(0);
			
			if (userDecision1 == 'h' || userDecision1 == 'H')
			{
				System.out.print( "\n" );
				System.out.print("Enter value for user card: ");
				int newUserValue = sc.nextInt();
				suitTypeUser = r.nextInt(3);
				
				if (newUserValue == 1)
				{
					userAceIsThere2 = 1;
				}
				
				switch(suitTypeUser) //switch statement handling random suit for user
				{
					case 0:
						suitDisplayUser = (" of hearts");
						break;
					case 1:
						suitDisplayUser = (" of spades");
						break;
					case 2:
						suitDisplayUser = (" of clubs");
						break;
					case 3:
						suitDisplayUser = (" of diamonds");
						break;
				} //end switch
				System.out.print( "\n" );
				System.out.println(userName + " draws: " + higherCardUser + suitDisplayUser);
				totalUser = totalUser + newUserValue;
				} //end if for hit mode
			
			if (totalDealer < 17)
			{
				suitTypeDealer = r.nextInt(3);
				cardValueDealer = r.nextInt(11);
				
				switch(suitTypeDealer) //switch statement handling random suit for dealer
				{
					case 0:
						suitDisplayDealer = (" of hearts");
						break;
					case 1:
						suitDisplayDealer = (" of spades");
						break;
					case 2:
						suitDisplayDealer = (" of clubs");
						break;
					case 3:
						suitDisplayDealer = (" of diamonds");
						break;
				} //end switch
				
				switch(cardValueDealer) //switch statement handling random card value for user
				{
					case 0:
						cardValueDealer = 1; //Reconsider how to handle this since it is an ace
						higherCardDealer = "Ace";
						dealerAceIsThere2 = 1;
						break;
					case 1:
						cardValueDealer = 2;
						higherCardDealer = "2";
						break;
					case 2:
						cardValueDealer = 3;
						higherCardDealer = "3";
						break;
					case 3:
						cardValueDealer = 4;
						higherCardDealer = "4";
						break;
					case 4:
						cardValueDealer = 5;
						higherCardDealer = "5";
						break;
					case 5:
						cardValueDealer = 6;
						higherCardDealer = "6";
						break;
					case 6:
						cardValueDealer = 7;
						higherCardDealer = "7";
						break;
					case 7:
						cardValueDealer = 8;
						higherCardDealer = "8";
						break;
					case 8:
						cardValueDealer = 9;
						higherCardDealer = "9";
						break;
					case 9:
						cardValueDealer = 10;
						higherCardDealer = "10";
					case 10:
						cardValueDealer = 10;
						higherCardDealer = ("Jack");
						break;
					case 11:
						cardValueDealer = 10;
						higherCardDealer = ("Queen");
						break;
					case 12:
						cardValueDealer = 10;
						higherCardDealer = ("King");
						break;
				} //end switch
				totalDealer = totalDealer + cardValueDealer;
				System.out.println("Dealer draws: " + higherCardDealer + suitDisplayDealer);
			} //end of dealer draws
			else
			{
				System.out.println("Dealer stays");
			} //end of dealer staying
			
			if (userDecision1 == 's' || userDecision1 == 'S')
			{
				System.out.println(userName + " stays");
			} //end of stay decision
			
			if(dealerAceIsThere2 == 1 && totalDealer == 11)
			{
				totalDealer = 21;
			}
			
			if(dealerAceIsThere2 == 1 && totalDealer < 11)
			{
				totalDealer = (totalUser - 1) + 11;
			}
			
			if(userAceIsThere2 == 1 && totalUser == 11)
			{
				totalUser = 21;
			}
			if(userAceIsThere2 == 1 && totalUser < 11)
			{
				totalUser = (totalUser - 1) + 11;
			}
			
			System.out.print( "\n" );
			System.out.println(userName + "'s total: " + totalUser);
			System.out.println("Dealer's total: " + totalDealer);
			System.out.print( "\n" );
			if (totalDealer > totalUser && totalDealer < 22)
			{
				System.out.println("Dealer Wins.");
			}
			else if (totalUser > totalDealer && totalUser < 22)
			{
			System.out.println(userName + " Wins!");
			}
			else if (totalDealer > 21 && totalUser < 22)
			{
				System.out.println(userName + " Wins!");
			}
			else if (totalUser > 21 && totalDealer < 22)
			{
				System.out.println("Dealer Wins.");
			}
			else if (totalUser == totalDealer)
			{
				System.out.println("It is a tie, house wins.");
			} //end if statements concerning ending totals
		} //end else if for test mode
		else
		{
			System.out.print("Invalid Input");
		} //end else for invalid original input
	}
} //end class
