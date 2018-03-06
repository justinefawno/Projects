using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Proj10
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            //if num = 17 then that is the blank space
            // int[] startingPositions = RandomizeStartingPostions(); 
            string[] startingPositions = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16" };
            /*button1.Text = startingPositions[0].ToString();
            button2.Text = startingPositions[1].ToString();
            button3.Text = startingPositions[2].ToString();
            button4.Text = startingPositions[3].ToString();
            button5.Text = startingPositions[4].ToString();
            button6.Text = startingPositions[5].ToString();
            button7.Text = startingPositions[6].ToString();
            button8.Text = startingPositions[7].ToString();
            button9.Text = startingPositions[8].ToString();
            button10.Text = startingPositions[9].ToString();
            button11.Text = startingPositions[10].ToString();
            button12.Text = startingPositions[11].ToString();
            button13.Text = startingPositions[12].ToString();
            button14.Text = startingPositions[13].ToString();
            button15.Text = startingPositions[14].ToString();
            button16.Text = startingPositions[15].ToString();
            button1.Text = startingPositions[0];
            button2.Text = startingPositions[1];
            button3.Text = startingPositions[2];
            button4.Text = startingPositions[3];
            button5.Text = startingPositions[4];
            button6.Text = startingPositions[5];
            button7.Text = startingPositions[6];
            button8.Text = startingPositions[7];
            button9.Text = startingPositions[8];
            button10.Text = startingPositions[9];
            button11.Text = startingPositions[10];
            button12.Text = startingPositions[11];
            button13.Text = startingPositions[12];
            button14.Text = startingPositions[13];
            button15.Text = startingPositions[14];
            button16.Text = startingPositions[15];*/
            b1.Text = "test";

            /*int blankIndex = FindingBlankSpace(startingPositions);

            if (startingPositions[0] == blankIndex)
            {
                button1.Visible = false;
            }
            else if (startingPositions[1] == blankIndex)
            {
                button2.Visible = false;
            }
            else if (startingPositions[2] == blankIndex)
            {
                button3.Visible = false;
            }
            else if (startingPositions[3] == blankIndex)
            {
                button4.Visible = false;
            }
            else if (startingPositions[4] == blankIndex)
            {
                button5.Visible = false;
            }
            else if (startingPositions[5] == blankIndex)
            {
                button6.Visible = false;
            }
            else if (startingPositions[6] == blankIndex)
            {
                button7.Visible = false;
            }
            else if (startingPositions[7] == blankIndex)
            {
                button8.Visible = false;
            }
            else if (startingPositions[8] == blankIndex)
            {
                button9.Visible = false;
            }
            else if (startingPositions[9] == blankIndex)
            {
                button10.Visible = false;
            }
            else if (startingPositions[10] == blankIndex)
            {
                button11.Visible = false;
            }
            else if (startingPositions[11] == blankIndex)
            {
                button12.Visible = false;
            }
            else if (startingPositions[12] == blankIndex)
            {
                button13.Visible = false;
            }
            else if (startingPositions[13] == blankIndex)
            {
                button14.Visible = false;
            }
            else if (startingPositions[14] == blankIndex)
            {
                button15.Visible = false;
            }
            else
            {
                button16.Visible = false;
            }
            //end code that randomly determines starting positions*/








        }

        public int[] RandomizeStartingPostions()
        {
            //how would I make sure there was not any duplicate numbers?
            Random r = new Random();
            int[] randomNums = new int[16];
            for (int i = 0; i < 16; i++)
            {
                int position = r.Next(1, 17);
                randomNums[i] = position;
            }
            return randomNums;
        }//end random starting position method
        public int FindingBlankSpace(int[] buttons)
        {
            for (int i = 0; i < 16; i++)
            {
                if (buttons[i] == 16)
                {
                    return i;
                    break; //does this break just the if statement?
                }
            }
            return -1;
        }//end disabling single button method

    }
}

