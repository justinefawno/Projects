/** (this project calculates statistics of poker hands in a set)
* @author (Justine Onnen)
* @version (9)
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Project_9
{
    class Poker_Hand
    {
        string c1, c2, c3, c4, c5;
        string[] cards = new string [5];
        // holds the contents of a single poker hand with a ToString method used to display the contents
        //of a single hand
        public Poker_Hand(string card1, string card2, string card3, string card4, string card5)
        {
            cards[0] = card1;
            cards[1] = card2;
            cards[2] = card3;
            cards[3] = card4;
            cards[4] = card5;
            Array.Sort(cards);
            c1 = cards[0];
            c2 = cards[1];
            c3 = cards[2];
            c4 = cards[3];
            c5 = cards[4];
        }
        /** (this method is to create the string with the hands included)
         * @returns (returns a string with all info)
 */
        public override String ToString()
        {
            string display = c1 + "\n" + c2 + "\n" + c3 + "\n" + c4 + "\n" + c5;
            return display;
        }
    }
}
