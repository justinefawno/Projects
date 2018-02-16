using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CIS300Project2
{
    class PuzzleCell : Label
    {
        int _number;
        bool _white;
        int _row;
        int _col;
        bool _visited;
        /// <summary>
        /// This constructor sets all corresponding values
        /// </summary>
        /// <param name="n">integer that is the number in the puzzleCell</param>
        /// <param name="r">row number that the puzzlecell is in</param>
        /// <param name="c">column number that the puzzlecell is in</param>
        public PuzzleCell(int n, int r, int c) {
            _number = n;
            _white = true;
            _row = r;
            _col = c;
            _visited = false;
        }
        /// <summary>
        /// sets a new value to _number property
        /// </summary>
        /// <param name="nu">number that corresponds to _number</param>
        public void setNum(int nu) {
            _number = nu;
        }
        /// <summary>
        /// returns _number property to calling place
        /// </summary>
        /// <returns>_number property</returns>
        public int getNum() {
            return _number;
        }
        /// <summary>
        /// this sets _white property to new value
        /// </summary>
        /// <param name="w">boolean value that is to be set to _white property</param>
        public void setColor(bool w)
        {
            _white = w;
        }
        /// <summary>
        /// this method lets the _white property be accesses elsewhere
        /// </summary>
        /// <returns>returns value of _white property</returns>
        public bool getColor() {
            return _white;
        }
        /// <summary>
        /// this method sets the _row property to a new value
        /// </summary>
        /// <param name="ro">int value that will be set to _row property</param>
        public void setRow(int ro)
        {
            _row = ro;
        }
        /// <summary>
        /// this method lets the _row property be accessed elsewhere
        /// </summary>
        /// <returns>returns the value of the _row property</returns>
        public int getRow() {
            return _row;
        }
        /// <summary>
        /// this method sets a new value to the _col property
        /// </summary>
        /// <param name="co">integer value that is to be set the _col property</param>
        public void setCol(int co)
        {
            _col = co;
        }
        /// <summary>
        /// this method allows the _col property to be accessed elsewhere
        /// </summary>
        /// <returns>returns the value of the _col property</returns>
        public int getCol() {
            return _col;
        }
        /// <summary>
        /// this method sets the incoming bool to the _visted property
        /// </summary>
        /// <param name="v">bool value that is to be set to the _visted property</param>
        public void setVisited(bool v)
        {
            _visited = v;
        }
        /// <summary>
        /// this method allows the _visted property to be accessed elsewhere
        /// </summary>
        /// <returns></returns>
        public bool getVistited() {
            return _visited;
        }

    }
}
