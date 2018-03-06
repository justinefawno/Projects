/** (this project calculates statistics of poker hands in a set)
* @author (Justine Onnen)
* @version (9)
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;
using System.IO;

namespace Project_9
{
    class Proj9
    {
        /** (this method is acting as the controller for the project)
 */

        static void Main(string[] args)
        {
        
            //use arraylist to read in hands from poker.txt (don't assume a 1,000 -- read until EOF)
            ArrayList PokerHands = new ArrayList ();
            int numOfHands = 0;
            string[] lines = System.IO.File.ReadAllLines("C:/Users/justi/Downloads/Proj9_poker.txt");
            for (int i = 1; i < lines.Length-4; i+=7)
            {
                Poker_Hand temp = new Poker_Hand(lines[i].Trim(), lines[i + 1].Trim(), lines[i + 2].Trim(), lines[i + 3].Trim(), lines[i + 4].Trim());
                PokerHands.Add(temp);
                numOfHands++;
            }
            //1-9, ace, jack, king, queen
            double royalFlushCount = 0.0;
            double straighFlushCount = 0.0;
            double fourCount = 0.0;
            double fullHouseCount = 0.0;
            double flushCount = 0.0;
            double straightCount = 0.0;
            double threeCount = 0.0;
            double pairsCount = 0.0;
            double pairCount = 0.0;
            double otherCount = 0.0;

            //so all hands should be sorted individually
            //why can't I access c1 from the pokerhands array?
            for (int i = 0; i < PokerHands.Count; i++)
            {
                string hands = PokerHands[i].ToString();
                string[] words = hands.Split(new char[]{ '\n', ' '});

                if (words[2] == words[5] && words[5] == words[8] && words[8] == words[11] && words[11] == words[14])//checks for same suit
                {
                    if (words[0] == "10" && words[3] == "Ace" && words[6] == "Jack" && words[9] == "King" && words[12] == "Queen")
                    {
                        royalFlushCount += 1.0;
                    }
                    else if (words[0] == "9" && words[3] == "10" && words[6] == "Jack" && words[9] == "King" && words[12] == "Queen")
                    {
                        straighFlushCount += 1.0;
                    }
                    else if (words[0] == "8" && words[3] == "9" && words[6] == "10" && words[9] == "Jack" && words[12] == "Queen")
                    {
                        straighFlushCount += 1.0;
                    }
                    else if (words[0] == "7" && words[3] == "8" && words[6] == "9" && words[9] == "10" && words[12] == "Jack")
                    {
                        straighFlushCount += 1.0;
                    }
                    else if (words[0] == "6" && words[3] == "7" && words[6] == "8" && words[9] == "9" && words[12] == "10")
                    {
                        straighFlushCount += 1.0;
                    }
                    else if (words[0] == "5" && words[3] == "6" && words[6] == "7" && words[9] == "8" && words[12] == "9")
                    {
                        straighFlushCount += 1.0;
                    }
                    else if (words[0] == "4" && words[3] == "5" && words[6] == "6" && words[9] == "7" && words[12] == "8")
                    {
                        straighFlushCount += 1.0;
                    }
                    else if (words[0] == "3" && words[3] == "4" && words[6] == "5" && words[9] == "6" && words[12] == "7")
                    {
                        straighFlushCount += 1.0;
                    }
                    else if (words[0] == "2" && words[3] == "3" && words[6] == "4" && words[9] == "5" && words[12] == "6")
                    {
                        straighFlushCount += 1.0;
                    }
                }
                else if ((words[0] == words[3] && words[3] == words[6] && words[6] == words[9]) || (words[3] == words[6] && words[6] == words[9] && words[9] == words[12]))
                {
                    fourCount += 1.0;
                }
                else if (((words[0] == words[3]) && (words[6] == words[9] && words[9] == words[12])) || ((words[0] == words[3] && words[3] == words[6]) && (words[9] == words[12])))
                {
                    fullHouseCount += 1.0;
                }
                else if (words[2] == words[5] && words[5] == words[8] && words[8] == words[11] && words[11] == words[14])
                {
                    flushCount += 1.0;
                }
                else if (
                   (words[0] == "10" && words[3] == "Ace" && words[6] == "Jack" && words[9] == "King" && words[12] == "Queen") ||
                   (words[0] == "9" && words[3] == "10" && words[6] == "Jack" && words[9] == "King" && words[12] == "Queen") ||
                   (words[0] == "8" && words[3] == "9" && words[6] == "10" && words[9] == "Jack" && words[12] == "Queen") ||
                   (words[0] == "7" && words[3] == "8" && words[6] == "9" && words[9] == "10" && words[12] == "Jack") ||
                   (words[0] == "6" && words[3] == "7" && words[6] == "8" && words[9] == "9" && words[12] == "10") ||
                   (words[0] == "5" && words[3] == "6" && words[6] == "7" && words[9] == "8" && words[12] == "9") ||
                   (words[0] == "4" && words[3] == "5" && words[6] == "6" && words[9] == "7" && words[12] == "8") ||
                   (words[0] == "3" && words[3] == "4" && words[6] == "5" && words[9] == "6" && words[12] == "7") ||
                   (words[0] == "2" && words[3] == "3" && words[6] == "4" && words[9] == "5" && words[12] == "6")
                   )
                {
                    straightCount += 1.0;
                } else if ((words[0] == words[3] && words[3] == words[6]) || (words[6] == words[9] && words[9] == words[12]))
                {
                    threeCount += 1.0;
                } else if ((words[0] == words[3] && words[6] == words[9]) || (words[0] == words[3] && words[9] == words[12]))
                    {
                    pairsCount += 1.0;
                } else if (words[0] == words[3] || words[3] == words[6] || words[6] == words[9] || words[9] == words[12])
                {
                    pairCount += 1.0;
                }
                else {
                    otherCount += 1.0;
                }
                





            }
            View IO = new View(PokerHands, royalFlushCount, straighFlushCount, fourCount, fullHouseCount, flushCount, straightCount,threeCount,pairsCount, pairCount,otherCount, numOfHands);
        } 
    }
}
