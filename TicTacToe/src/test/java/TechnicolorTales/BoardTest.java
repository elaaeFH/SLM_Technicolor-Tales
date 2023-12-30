package TechnicolorTales;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    /*Test Klasse für die Board Klasse, beinhaltet Positive & Negative
    Tests per Methode in der Board Klasse */

    @Test
    public void IsCellEmpty_Positive() {
        Board board= new Board();
        assertTrue(board.isCellEmpty(0,0)); //Wenn das Board wirklich empty ist -> dann True
    }

    @Test
    public void IsCellEmpty_Negative() {
        Board board= new Board();
        board.place(0,0,'X'); //X in (0,0) gesetzt um einen Negativen Fall zu testen
        assertFalse(board.isCellEmpty(0,0));
    }

    @Test
    public void Place_Positive() { //P-Case: Zeichen in einer leeren Zelle setzen
        Board board=new Board();
        board.place(1,1,'X');
        assertTrue(!board.isCellEmpty(1,1));
    }
    @Test
    public void Place_Negative() { //N-Case: Zeichen in einer nicht leeren Zelle setzen
        Board board=new Board();
        board.place(1,1,'X');
        board.place(1,1,'O');
        assertEquals('X', board.getCells()[1][1]);
    }
    @Test
    public void isFull_Positive() { //P-Case: Board ist voll -> Zeichen in allen zellen setzen
        Board board=new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i,j,'X');
            }
        }
        assertTrue(board.isFull());
    }
    @Test
    public void isFull_Negative() { //N-Case: Board ist nicht voll
        Board board=new Board();
        board.place(0,0,'X');
        board.place(1,0,'O');
        assertFalse(board.isFull());
    }

    //Methode Clear hat nur einen Test -> nur ein Test Case
    @Test
    public void clear_Test() { //Case: Board leer nach dem clearen
        Board board=new Board();
        board.place(0,0,'X');
        board.clear();
        assertTrue(board.isCellEmpty(0,0));
    }

    //Methode Print testen -> tricky, WIP
}