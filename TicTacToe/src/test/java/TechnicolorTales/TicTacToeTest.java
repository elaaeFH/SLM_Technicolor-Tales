package TechnicolorTales;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
class TicTacToeTest {

   @SneakyThrows
   @Test
    void startDraw() { // Tests if input for "draw" is handled right
       // Arrange
       InputStream inputStream = new ByteArrayInputStream("0\n0\n2\n0\n1\n1\n2\n2\n1\n2\n0\n1\n0\n2\n1\n0\n2\n1".getBytes());
       System.setIn(inputStream);

       ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
       System.setOut(new PrintStream(outputStream));

       // Act and Assert
       TicTacToe ticTacToe = new TicTacToe();
       ticTacToe.start();

       assertTrue(outputStream.toString().contains("It is a draw"), "Expected a draw message in the output");
    }

    @SneakyThrows
    @Test
    void startPlayer_O_Wins() { // Tests if input for Player O wins is handled right
        // Arrange
        InputStream inputStream = new ByteArrayInputStream("1\n0\n0\n0\n1\n2\n1\n1\n2\n1\n2\n2".getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act and Assert
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.start();

        assertTrue(outputStream.toString().contains("Player O wins ҉ ヽ(^o^)/ ҉"), "Expected a message regarding the winner");
   }

    @SneakyThrows
    @Test
    void startPlayer_X_Wins() { // Tests if input for Player X wins is handled right
        // Arrange
        InputStream inputStream = new ByteArrayInputStream("0\n0\n1\n0\n1\n1\n2\n1\n2\n2".getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act and Assert
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.start();

        assertTrue(outputStream.toString().contains("Player X wins ҉ ヽ(^o^)/ ҉"), "Expected a message regarding the winner");
    }

/* not working, when the test starts it loops endlessly: keeping for documentation
    @SneakyThrows
    @Test
    void startCellAlreadyFull() {
        // Arrange
        InputStream inputStream = new ByteArrayInputStream("0\n0\n0\n0".getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act and Assert
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.start();

        assertTrue(outputStream.toString().contains("Cell is already full"), "Expected a message regarding state of the Cell");
    }
 */
    @SneakyThrows
    @Test
    void switchCurrentPlayer() { // Tests if the current player is switched
        // Arrange
        TicTacToe ticTacToe = new TicTacToe();
        Method switchCurrentPlayer = TicTacToe.class.getDeclaredMethod("switchCurrentPlayer");
        switchCurrentPlayer.setAccessible(true);

        // Act
        switchCurrentPlayer.invoke(ticTacToe); // Switch from player1 to player2
        Player currentPlayerAfterFirstSwitch = ticTacToe.getCurrentplayer();

        switchCurrentPlayer.invoke(ticTacToe); // Switch back to player1
        Player currentPlayerAfterSecondSwitch = ticTacToe.getCurrentplayer();

        // Assert
        assertEquals(ticTacToe.getPlayer2(), currentPlayerAfterFirstSwitch,
                "After the first switch, the current player should be player2");

        assertEquals(ticTacToe.getPlayer1(), currentPlayerAfterSecondSwitch,
                "After the second switch, the current player should be player1");
    }
}