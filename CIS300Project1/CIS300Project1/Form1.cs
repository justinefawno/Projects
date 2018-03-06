using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Timers;


//Problems
//Can't add new heat sources after start has been hit



namespace CIS300Project1
{
    public partial class Form1 : Form
    {
        System.Timers.Timer startTimer = new System.Timers.Timer(300);
        Label[,] gridItems = new Label[22, 67];
        Label[,] updatedColors = new Label[22, 67];



        /// <summary>
        /// This method contains the intial set of the gui which creates the labels and sets up the buffer rows and collums for the label array
        /// </summary>
        public Form1()
        {
            InitializeComponent();

           

            int xCoorCounter = 10;
            int yCoorCounter = 0;
            for (int i = 0; i < 22; i++)
            {
                xCoorCounter = 10;
                yCoorCounter += 20;
                for (int j = 0; j < 67; j++)
                {
                    Label temp = new Label();
                    //temp.AutoSize = true;
                    temp.Location = new Point(xCoorCounter, yCoorCounter);
                    temp.Size = new Size(15, 15);
                    temp.BackColor = Color.White;
                    temp.Click += new EventHandler(HeatIndicator);
                    gridItems[i, j] = temp;
                    updatedColors[i, j] = temp;
                    Controls.Add(gridItems[i, j]);
                    xCoorCounter += 20;
                }//end inside for loop
            }//end outside for loop

            for (int h = 0; h < 67; h++)
            {
                gridItems[0, h].Visible = false;
                gridItems[21, h].Visible = false;
                gridItems[0, h].BackColor = Color.White;
                gridItems[21, h].BackColor = Color.White;
            }//setting buffer zones to white and invisible

            for (int q = 0; q < 22; q++)
            {
                gridItems[q, 0].Visible = false;
                gridItems[q, 66].Visible = false;
                gridItems[q, 0].BackColor = Color.White;
                gridItems[q, 66].BackColor = Color.White;
            }//setting buffer zones to white and invisible
            

        }//end form1


        /// <summary>
        /// This method creates the timer object and starts the timer object; it also sets the BackColor properties for the new generation of labels and puts them in the new array
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void uxStartButton_Click(object sender, EventArgs e)
        {

            startTimer.Elapsed += new ElapsedEventHandler(startTimerEvent);
            startTimer.Enabled = true;
            startTimer.SynchronizingObject = this;
            startTimer.Start();

            for (int h = 0; h < 22; h++)
            {
                Label temp1 = new Label();
                temp1.BackColor = Color.White;
                updatedColors[h, 0] = temp1;
                updatedColors[h, 66] = temp1;
            }//setting buffer zones to white
            for (int q = 0; q < 67; q++)
            {
                Label temp2 = new Label();
                temp2.BackColor = Color.White;
                updatedColors[0, q] = temp2;
                updatedColors[21, q] = temp2;
            }//setting buffer zones to white


        }//end start button click event



        /// <summary>
        /// This method is what allows the user to click to turn labels red if they are white and white if they are red
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void HeatIndicator(object sender, EventArgs e)
        {
            Console.WriteLine(sender);
            Label temp = (Label)sender;

            if (temp.BackColor != Color.FromArgb(255,0,0))
            {
                //temp.BackColor = Color.Red;
               Color myRed = Color.FromArgb(255,0,0);
               temp.BackColor = myRed;
            }
            else if (temp.BackColor == Color.FromArgb(255,0,0))
            {
                temp.BackColor = Color.White;
            }
        }//end HeatIndicator method



        /// <summary>
        /// This method is what happens anytime the timer object is started; it calls the createNextSquare mthod to determine the new generation of colors then sets the original array backcolors to the same of the corresponding new generation
        /// </summary>
        /// <param name="source"></param>
        /// <param name="e"></param>
        private void startTimerEvent(object source, ElapsedEventArgs e)
        {
            //use stacked for loop to send index


            for (int i = 1; i < 21; i++)
            {
                for (int j = 1; j < 66; j++)
                {
                    createNextSquare(i, j);
                }
            }

           // gridItems = updatedColors;
            //updatedColors = new Label[22,67];

            /*for (int i = 0; i < 22; i++)
            {
                for (int j = 0; j < 67; j++)
                {
                    gridItems[i, j] = updatedColors[i, j];
                }//end inside for
            }//end outside for*/
        }//end startTimeEvent

        /// <summary>
        /// This method stops the timer object
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void uxStopButton_Click(object sender, EventArgs e)
        {
            startTimer.Stop();
        }


        /// <summary>
        /// This method sets all backcolors of the original array back to white and also stops the timer object
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void uxResetButton_Click(object sender, EventArgs e)
        {
            startTimer.Stop();
            for (int i = 0; i < 22; i++)
            {
                for (int j = 0; j < 67; j++)
                {
                        gridItems[i, j].BackColor = Color.White;
                }//end inside for loop
            }//end outside for loop
        }//end reset button click

        /// <summary>
        /// This method finds the neighbor of a given label object of the original array then computes the average green value then sets the new color found to the new updated color label in the corresponding spot; also checks to make sure label is not a heat source before going forth
        /// </summary>
        /// <param name="x">this is a x index of the original array</param>
        /// <param name="y">this is the y index of the original array</param>
        private void createNextSquare(int x, int y)
        {
            //gridItems[2,4].BackColor.R
            updatedColors[x, y] = gridItems[x, y];
            if (gridItems[x, y].BackColor == Color.FromArgb(255,0,0))
            {
                
                //updatedColors[x, y].Click += new EventHandler(HeatIndicator);
                return;
            }

            Color neighbor1 = gridItems[x - 1, y + 1].BackColor;
            Color neighbor2 = gridItems[x - 1, y].BackColor;
            Color neighbor3 = gridItems[x - 1, y - 1].BackColor;
            Color neighbor4 = gridItems[x, y + 1].BackColor;
            Color neighbor5 = gridItems[x, y - 1].BackColor;
            Color neighbor6 = gridItems[x + 1, y + 1].BackColor;
            Color neighbor7 = gridItems[x + 1, y].BackColor;
            Color neighbor8 = gridItems[x + 1, y - 1].BackColor;

            

            //add all the green (.g) of all neighbors then divide by 8
            //assign the new array at index xy toArgb(255, t, t)
            //updatedColors[x,y].BackColor = Color.FromArgb(255, t, t);
            int totalGreenValues = neighbor1.G + neighbor2.G + neighbor3.G + neighbor4.G + neighbor5.G + neighbor6.G + neighbor7.G + neighbor8.G;
            int average = totalGreenValues / 8;
            updatedColors[x, y].BackColor = Color.FromArgb(255, average, average);
            gridItems[x, y] = updatedColors[x, y];

        }




    }//end partial class
}//end namespace
