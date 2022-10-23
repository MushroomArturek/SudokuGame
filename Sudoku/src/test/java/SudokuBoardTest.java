import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;


public class SudokuBoardTest {
    private SudokuBoard sudokuBoard;
    public int [][] exampleBoardGood = {
            {5,3,4,6,7,8,9,1,2},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,7,2,8,4},
            {2,8,7,4,1,9,6,3,5},
            {3,4,5,2,8,6,1,7,9}
    };

    public int [][] exampleBoardGood2 = {
            {5,3,4,6,7,8,9,1,2},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,7,2,8,4},
            {2,8,7,4,1,9,6,3,5},
            {3,4,5,2,8,6,1,7,9}
    };
    public int [][] exampleBoardWrongRow = {
            {5,5,4,6,7,8,9,1,2},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,7,2,8,4},
            {2,8,7,4,1,9,6,3,5},
            {3,4,5,2,8,6,1,7,9}
    };
    public int [][] exampleBoardWrongColumn = {
            {6,3,4,5,7,8,9,1,2},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,7,2,8,4},
            {2,8,7,4,1,9,6,3,5},
            {3,4,5,2,8,6,1,7,9}
    };
    public int [][] exampleBoardWrongSquare = {
            {0,3,4,6,7,8,9,1,2},
            {6,0,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,7,2,8,4},
            {2,8,7,4,1,9,6,3,5},
            {3,4,5,2,8,6,1,7,9}
    };

    @BeforeEach
    public void setUp() {
        SudokuSolver solvik = new BacktrackingSudokuSolver();
        sudokuBoard = new SudokuBoard(solvik);
    }
    //TESTY DLA RZEDOW
    SudokuBoard boardzik = new SudokuBoard(exampleBoardGood);
    SudokuBoard boardzik1 = new SudokuBoard(exampleBoardGood2);
    @Test
    public void checkValidTest(){
        assertTrue(sudokuBoard.checkValid(exampleBoardGood));
        assertFalse(sudokuBoard.checkValid(exampleBoardWrongRow));
        assertFalse(sudokuBoard.checkValid(exampleBoardWrongColumn));
        assertFalse(sudokuBoard.checkValid(exampleBoardWrongSquare));
    }


    @Test
    public void getAndSetTest() {
        assertEquals(sudokuBoard.get(0, 0), 0);
        sudokuBoard.set(1, 2, 3 );
        assertEquals(sudokuBoard.get(1, 2), 3);
    }

    @Test
    public void ConstructorTest() {
        boolean z = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++){
                if (boardzik.get(i,j) != boardzik1.get(i,j)) {
                    z = false;
                    break;
                }
            }
        }
    }


    @Test
    public void equalsTest() {
        assertTrue(sudokuBoard.equals(sudokuBoard));
    }
    //TESTY DLA KOLUMN

    @Test
    public void toStringTest() {
        String tmp = "";
        for(int i = 0; i < 9; i++)
        {
            tmp += "0 0 0 0 0 0 0 0 0 \n";
        }
        assertTrue(sudokuBoard.toString().equals(tmp));
    }

}
