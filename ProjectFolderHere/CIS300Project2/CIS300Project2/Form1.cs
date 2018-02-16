using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;
using System.Timers;
namespace CIS300Project2
{
    public partial class Form1 : Form
    {
        PuzzleCell[,] puzzle = new PuzzleCell[5, 5];
        bool puzzleLoaded = false;
        
        public Form1()
        {
            InitializeComponent();
            int yCoorCounter = 5;
            for (int i = 0; i < 5; i++)
            {
                int xCoorCounter = 60;
                yCoorCounter += 60;
                for (int j = 0; j < 5; j++)
                {
                    PuzzleCell temp = new PuzzleCell(0, 0, 0);
                    temp.Location = new Point(xCoorCounter, yCoorCounter);
                    temp.Size = new Size(50, 50);
                    temp.BackColor = Color.White;
                    temp.Click += new EventHandler(LabelClicked);
                    puzzle[i, j] = temp;
                    Controls.Add(puzzle[i, j]);
                    xCoorCounter += 60;
                }
            }
        }
        /// <summary>
        /// This method controls the events when the check solution button is clicked; this method calls the check solution method and determines whether the user solved the puzzle or not
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void button1_Click(object sender, EventArgs e) //this is the check solution button
        {
            if (checkSolution())
            {
                MessageBox.Show("You solved it!");
            }
            else {
                MessageBox.Show("Puzzle is not solved. Check the rules and try again!");
            }


        }//end of check solution button click
        /// <summary>
        /// This method controls the user opening up an input file and also splitting up and assigned number values to each of the PuzzleCell items in puzzle[]
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void uxOpenMenuItem_Click(object sender, EventArgs e)
        {
            uxOpenFileDialog.ShowDialog();
            if (uxOpenFileDialog.ShowDialog() == DialogResult.OK)
            {
                string openFileName = uxOpenFileDialog.FileName;
                string openFileContents = File.ReadAllText(openFileName);
                string[] lines = openFileContents.Split('\n');
                if (lines.Length != 5)
                {
                    MessageBox.Show("Invalid file format");
                }//end if asking about how many lines there is in the file opened
                else
                {
                    string line1Text = lines[0];
                    string line2Text = lines[1];
                    string line3Text = lines[2];
                    string line4Text = lines[3];
                    string line5Text = lines[4];
                    string[] line1 = line1Text.Split(' ');
                    string[] line2 = line2Text.Split(' ');
                    string[] line3 = line3Text.Split(' ');
                    string[] line4 = line4Text.Split(' ');
                    string[] line5 = line5Text.Split(' ');

                    if (line1.Length != 5 || line2.Length != 5 || line3.Length != 5 || line4.Length != 5 || line5.Length != 5) {
                        MessageBox.Show("Invalid file format");
                        return;
                    }//checking file format

                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            puzzle[i, j].setColor(true);
                            puzzle[i, j].BackColor = Color.White;
                            puzzle[i, j].ForeColor = Color.Black;
                        }
                    }

                    //end separating out numbers from opened file
                    
                    for (int i = 0; i < 5; i++) {
                        puzzle[0, i].Text = line1[i];
                        string temp = puzzle[0, i].Text;
                        puzzle[0, i].setNum(Convert.ToInt32(temp));
                        puzzle[0, i].setCol(i);
                        puzzle[0, i].setRow(0); //THIS MIGHT BE A PROBLEM? NEED TO INCREMENT?
                    }

                    for (int i = 0; i < 5; i++)
                    {
                        puzzle[1, i].Text = line2[i];
                        string temp = puzzle[1, i].Text;
                        puzzle[1, i].setNum(Convert.ToInt32(temp));
                        puzzle[1, i].setCol(i);
                        puzzle[1, i].setRow(1); //THIS MIGHT BE A PROBLEM? NEED TO INCREMENT?
                    }

                    for (int i = 0; i < 5; i++)
                    {
                        puzzle[2, i].Text = line3[i];
                        string temp = puzzle[2, i].Text;
                        puzzle[2, i].setNum(Convert.ToInt32(temp));
                        puzzle[2, i].setCol(i);
                        puzzle[2, i].setRow(2); //THIS MIGHT BE A PROBLEM? NEED TO INCREMENT?
                    }

                    for (int i = 0; i < 5; i++)
                    {
                        puzzle[3, i].Text = line4[i];
                        string temp = puzzle[3, i].Text;
                        puzzle[3, i].setNum(Convert.ToInt32(temp));
                        puzzle[3, i].setCol(i);
                        puzzle[3, i].setRow(3); //THIS MIGHT BE A PROBLEM? NEED TO INCREMENT?
                    }

                    for (int i = 0; i < 5; i++)
                    {
                        puzzle[4, i].Text = line5[i];
                        string temp = puzzle[4, i].Text;
                        puzzle[4, i].setNum(Convert.ToInt32(temp));
                        puzzle[4, i].setCol(i);
                        puzzle[4, i].setRow(4); //THIS MIGHT BE A PROBLEM? NEED TO INCREMENT?
                    }
                    puzzleLoaded = true;
                }//end else if number of lines was okay
            }//end if (uxOpenFileDialog.ShowDialog() == DialogResult.OK)
            else {
                MessageBox.Show("Invalid File");
            }//end else for invalid file type

        }//end openButton method
        /// <summary>
        /// this method lets the user click PuzzleCell objects in the GUI and change them to black or white and also sets the color property for each PuzzleCell object
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void LabelClicked(object sender, EventArgs e) {
            PuzzleCell temp = (PuzzleCell)sender;

            if (temp.getColor() == true)
            {
                temp.ForeColor = Color.White;
                temp.BackColor = Color.Black;
                temp.setColor(false);
            }
            else {
                temp.ForeColor = Color.Black;
                temp.BackColor = Color.White;
                temp.setColor(true);
            }
        }//end label click event handler
        /// <summary>
        /// this method controls when the user clicks on the display solution button. This method calls the check solution method and adds objects into the allMoves List.
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void uxDisplaySolutionButton_Click(object sender, EventArgs e)
        {
            if (puzzleLoaded == false) {
                MessageBox.Show("First please load a puzzle.");
                return;
            }


            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    puzzle[i, j].BackColor = Color.White;
                    puzzle[i, j].ForeColor = Color.Black;
                    puzzle[i, j].setColor(true);
                    puzzle[i, j].setVisited(false);
                }
            }


            List<PuzzleCell> allMoves = new List<PuzzleCell>();

            for (int i = 0; i < 5; i++) {
                
                for (int j = 0; j < 5; j++) {
                    PuzzleCell temp = puzzle[i,j];
                    for (int h = 0; h < 5; h++) {
                        if (puzzle[i, h].getNum() == temp.getNum() && h != j) {
                            allMoves.Add(temp);
                        }
                        else if (puzzle[h, j].getNum() == temp.getNum() && h != i)
                        {
                            allMoves.Add(temp);
                        }

                    }

                }
            }

            /*int[,] nums = new int[5, 5];


            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    nums[i, j] = puzzle[i, j].getNum();
                }
            }

            for (int i = 0; i < 5; i++) {
                if (nums[i, 0] == nums[i, 1]) {
                    allMoves.Add(puzzle[i, 0]);
                    allMoves.Add(puzzle[i, 1]);
                }
                if (nums[i, 1] == nums[i, 2])
                {
                    allMoves.Add(puzzle[i, 1]);
                    allMoves.Add(puzzle[i, 2]);
                }
                if (nums[i, 2] == nums[i, 3])
                {
                    allMoves.Add(puzzle[i, 2]);
                    allMoves.Add(puzzle[i, 3]);
                }
                if (nums[i, 3] == nums[i, 4])
                {
                    allMoves.Add(puzzle[i, 3]);
                    allMoves.Add(puzzle[i, 4]);
                }
                if (nums[i, 1] == nums[i, 3])
                {
                    allMoves.Add(puzzle[i, 3]);
                    allMoves.Add(puzzle[i, 1]);
                }
                if (nums[i, 1] == nums[i, 4])
                {
                    allMoves.Add(puzzle[i, 4]);
                    allMoves.Add(puzzle[i, 1]);
                }
                if (nums[i, 2] == nums[i, 4])
                {
                    allMoves.Add(puzzle[i, 2]);
                    allMoves.Add(puzzle[i, 4]);
                }

            }

            for (int i = 0; i < 5; i++)
            {
                if (nums[0, i] == nums[1, i])
                {
                    allMoves.Add(puzzle[0, i]);
                    allMoves.Add(puzzle[1, i]);
                }
                if (nums[1, i] == nums[2, i])
                {
                    allMoves.Add(puzzle[1, i]);
                    allMoves.Add(puzzle[2, i]);
                }
                if (nums[2, i] == nums[3, i])
                {
                    allMoves.Add(puzzle[2, i]);
                    allMoves.Add(puzzle[3, i]);
                }
                if (nums[3, i] == nums[4, i])
                {
                    allMoves.Add(puzzle[3, i]);
                    allMoves.Add(puzzle[4, i]);
                }
                if (nums[1, i] == nums[3, i])
                {
                    allMoves.Add(puzzle[3, i]);
                    allMoves.Add(puzzle[1, i]);
                }
                if (nums[1, i] == nums[4, i])
                {
                    allMoves.Add(puzzle[4, i]);
                    allMoves.Add(puzzle[1, i]);
                }
                if (nums[2, i] == nums[4, i])
                {
                    allMoves.Add(puzzle[2, i]);
                    allMoves.Add(puzzle[4, i]);
                }

            }*/





            if (SolvePuzzle(allMoves, 0) == false)
            {
                MessageBox.Show("No solution");
            }


        }//end display solution button method

        /// <summary>
        /// this recursive method determines whether or not all the white PuzzleCells are connected in the puzzle
        /// </summary>
        /// <param name="cur"></param>
        /// <returns>whether all the white PuzzleCells are connected</returns>
        private bool Connected(PuzzleCell cur) {
            //For each of cur's neighbors (above, below, left, and right) that are UNVISITED and WHITE:
            //Recursively call Connected with that neighbor.
            //If any of those recursive calls return true, that means that all cells were visited and that all the white cells must be connected
            //Console.WriteLine("Visited: " + cur.getRow().ToString() + " " + cur.getCol().ToString());
            cur.setVisited(true);


            bool done = false;


            if (cur.getRow() - 1 >= 0) {
                PuzzleCell upNeighbor = puzzle[cur.getRow() - 1, cur.getCol()];
                if (upNeighbor.getColor() == true && upNeighbor.getVistited() == false) {
                    done = Connected(upNeighbor);
                }
                if (done) {
                    return true;
                }
            }

            if (cur.getRow() + 1 <= 4)
            {
                PuzzleCell downNeighbor = puzzle[cur.getRow() + 1, cur.getCol()];
                if (downNeighbor.getColor() == true && downNeighbor.getVistited() == false)
                {
                    done = Connected(downNeighbor);
                }
                if (done)
                {
                    return true;
                }
            }

            if (cur.getCol() - 1 >= 0)
            {
                PuzzleCell leftNeighbor = puzzle[cur.getRow(), cur.getCol() - 1];
                if (leftNeighbor.getColor() == true && leftNeighbor.getVistited() == false)
                {
                    done = Connected(leftNeighbor);
                }
                if (done)
                {
                    return true;
                }
            }

            if (cur.getCol() + 1 <= 4)
            {
                PuzzleCell rightNeighbor = puzzle[cur.getRow(), cur.getCol() + 1];
                if (rightNeighbor.getColor() == true && rightNeighbor.getVistited() == false)
                {
                    done = Connected(rightNeighbor);
                }
                if (done)
                {
                    return true;
                }
            }


            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (puzzle[i, j].getColor() == true) {
                        if (puzzle[i, j].getVistited() == false) {

                            return false;

                        }
                    }
                }
            }

            return true;


        }//end of Connected method

        /// <summary>
        /// This recursive method goes through and tries different squares to turn black to see if it can find a solution for the given puzzle
        /// </summary>
        /// <param name="allMoves">this is a list of all the duplicate numbers in the puzzle</param>
        /// <param name="pos">this is the current position in the allMoves list</param>
        /// <returns>returns whether a solution was found or not</returns>
        private bool SolvePuzzle(List<PuzzleCell> allMoves, int pos) {


            if (checkSolution())
            {
                return true;
            }

            if (pos >= allMoves.Count) {
                return false;
            }

            allMoves[pos].BackColor = Color.Black;
            allMoves[pos].setColor(false);
            allMoves[pos].ForeColor = Color.White;
            if (SolvePuzzle(allMoves, pos + 1)) {
                return true;
            }
            allMoves[pos].BackColor = Color.White;
            allMoves[pos].setColor(true);
            allMoves[pos].ForeColor = Color.Black;

            return SolvePuzzle(allMoves, pos + 1);




        }//end solve puzzle method
        /// <summary>
        /// this method checks for adjacent black cells and duplicate numbers in columns and rows
        /// </summary>
        /// <returns>whether or not a solution is correct </returns>
        public bool checkSolution() {

            if (puzzleLoaded == false)
            {
                MessageBox.Show("Puzzle not loaded");
                return false;
            }//end check to see if puzzle was loaded

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    puzzle[i, j].setVisited(false);
                }
            }

            for (int i = 0; i < 5; i++)
            {
                int num1 = puzzle[0, i].getNum();
                int num2 = puzzle[1, i].getNum();
                int num3 = puzzle[2, i].getNum();
                int num4 = puzzle[3, i].getNum();
                int num5 = puzzle[4, i].getNum();

                if (puzzle[0, i].getColor() == false)
                {
                    num1 = -1;
                }
                if (puzzle[1, i].getColor() == false)
                {
                    num2 = -2;
                }
                if (puzzle[2, i].getColor() == false)
                {
                    num3 = -3;
                }
                if (puzzle[3, i].getColor() == false)
                {
                    num4 = -4;
                }
                if (puzzle[4, i].getColor() == false)
                {
                    num5 = -5;
                }

                if (num1 == num2 || num1 == num3 || num1 == num4 || num2 == num3 || num2 == num4 || num3 == num4)
                {
                    return false;
                }
            }//checking for duplicates in columns

            for (int i = 0; i < 5; i++)
            {
                int num1 = puzzle[i, 0].getNum();
                int num2 = puzzle[i, 1].getNum();
                int num3 = puzzle[i, 2].getNum();
                int num4 = puzzle[i, 3].getNum();
                int num5 = puzzle[i, 4].getNum();

                if (puzzle[i, 0].getColor() == false)
                {
                    num1 = -1;
                }
                if (puzzle[i, 1].getColor() == false)
                {
                    num2 = -2;
                }
                if (puzzle[i, 2].getColor() == false)
                {
                    num3 = -3;
                }
                if (puzzle[i, 3].getColor() == false)
                {
                    num4 = -4;
                }
                if (puzzle[i, 4].getColor() == false)
                {
                    num5 = -5;
                }

                if (num1 == num2 || num1 == num3 || num1 == num4 || num2 == num3 || num2 == num4 || num3 == num4)
                {
                    return false;
                }
            }//checking for duplicates in rows

            //ensure that no two black cells are adjacent horizontally or vertically
            for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 5; j++)
                {

                    if (puzzle[i, j].getColor() == false)
                    {
                        int left = j - 1;
                        int right = j + 1;
                        int up = i - 1;
                        int down = i + 1;

                        if (left >= 0)
                        {
                            if (puzzle[i, left].getColor() == false)
                            {
                                return false;
                            }
                        }
                        if (right <= 4)
                        {
                            if (puzzle[i, right].getColor() == false)
                            {
                                return false;
                            }
                        }

                        if (up >= 0)
                        {
                            if (puzzle[up, j].getColor() == false)
                            {
                                return false;
                            }
                        }
                        if (down <= 4)
                        {
                            if (puzzle[down, j].getColor() == false)
                            {
                                return false;
                            }
                        }



                    }//end checking for adjacent black cells




                }//end inner for loop
            }//end outer for loop
            PuzzleCell tempo = null;
            for (int h = 0; h < 5; h++)
            {
                for (int w = 0; w < 5; w++)
                {
                    if (puzzle[h, w].getColor() == true)
                    {
                        tempo = puzzle[h, w];
                        break;
                    }

                }
                if (tempo != null)
                {
                    break;
                }
            }

            if (Connected(tempo))
            {
                return true;
            }

            /*for (int h = 0; h < 5; h++)
            {
                for (int w = 0; w < 5; w++)
                {
                    if (puzzle[h, w].getColor() == true)
                    {
                        tempo = puzzle[h, w];
                        if (puzzle[h, w].getVistited() == false)
                        {
                            Console.WriteLine("" + h + " " + w);
                        }
                    }

                }

            }*/

            return false;
        }//end check solution method



    }
}
