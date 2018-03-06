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
    class View
    {
        ArrayList allHands = new ArrayList();
        public View(ArrayList pokerHands, double royalTotal, double straighFlushTotal, double fourTotal, double fullHouseTotal, double flushTotal, double straightTotal, double threeTotal, double twoPairsTotal, double pairTotal, double otherTotal, int total)
        {
           try{
            StreamWriter sw = new StreamWriter("poker_results.txt");
                for (int i = 0; i < pokerHands.Count; i++)
                {
                    sw.WriteLine(pokerHands[i]);
                }
            }
            catch (Exception e)
             {
             Console.WriteLine("Exception: " + e.Message);
             }
            double royalPercentage = royalTotal / total;
            double straightFlushPercentage = straighFlushTotal / total;
            double fourPercentage = fourTotal / total;
            double fullHousePercentage = fullHouseTotal / total;
            double flushPercentage = flushTotal / total;
            double straightPercentage = straightTotal / total;
            double threePercentage = threeTotal / total;
            double twoPairsPercentage = twoPairsTotal / total;
            double pairPercentage = pairTotal / total;
            double otherPercentage = otherTotal / total;

            Console.WriteLine("Results (" + total + " hands): ");
            Console.WriteLine("Royal Flush: " + string.Format("{0:F1}", royalPercentage) + "%");
            Console.WriteLine("Straight Flush: " + string.Format("{0:F1}", straightFlushPercentage) + "%");
            Console.WriteLine("Four of a Kind: " + string.Format("{0:F1}", fourPercentage) + "%");
            Console.WriteLine("Full House: " + string.Format("{0:F1}", fullHousePercentage) + "%");
            Console.WriteLine("Flush: " + string.Format("{0:F1}", flushPercentage) + "%");
            Console.WriteLine("Straight: " + string.Format("{0:F1}", straightPercentage) + "%");
            Console.WriteLine("Three of a Kind: " + string.Format("{0:F1}", threePercentage) + "%");
            Console.WriteLine("Two pair: " + string.Format("{0:F1}", twoPairsPercentage) + "%");
            Console.WriteLine("One pair: " + string.Format("{0:F1}", pairPercentage) + "%");
            Console.WriteLine("Other: " + string.Format("{0:F1}", otherPercentage) + "%");
            Console.WriteLine();
            try
            {
                StreamWriter Newsw = new StreamWriter("poker_results.txt");
                Newsw.WriteLine("Results (" + total + " hands): ");
                Newsw.WriteLine("Royal Flush: " + string.Format("{0:F1}", royalPercentage) + "%");
                Newsw.WriteLine("Straight Flush: " + string.Format("{0:F1}", straightFlushPercentage) + "%");
                Newsw.WriteLine("Four of a Kind: " + string.Format("{0:F1}", fourPercentage) + "%");
                Newsw.WriteLine("Full House: " + string.Format("{0:F1}", fullHousePercentage) + "%");
                Newsw.WriteLine("Flush: " + string.Format("{0:F1}", flushPercentage) + "%");
                Newsw.WriteLine("Straight: " + string.Format("{0:F1}", straightPercentage) + "%");
                Newsw.WriteLine("Three of a Kind: " + string.Format("{0:F1}", threePercentage) + "%");
                Newsw.WriteLine("Two pair: " + string.Format("{0:F1}", twoPairsPercentage) + "%");
                Newsw.WriteLine("One pair: " + string.Format("{0:F1}", pairPercentage) + "%");
                Newsw.WriteLine("Other: " + string.Format("{0:F1}", otherPercentage) + "%");
            }
            catch (Exception e)
            {
                Console.WriteLine("Exception: " + e.Message);
            }

        }
        //display calculated results (percentages)
        //also  needs to write all of the poker hands contained in the ArrayList to a file called poker_results.txt
        //using the ToString method defined in the model calss, followed by the results shown below
        //you can also append to the existing poker.txt file but will have to rename the file afterwards to poker_results.txt
        
        

    }
}
