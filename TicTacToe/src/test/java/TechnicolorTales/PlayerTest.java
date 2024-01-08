package TechnicolorTales;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    //ensures that expected maker is actual marker/returned
    void getPlayerMarker() {
        // Arrange
        char expectedMarker = 'X';
        Player player = new Player(expectedMarker);

        // Act & Assert
        char actualMarker = player.getMarker();
        assertEquals(expectedMarker, actualMarker, "Player's marker should match the expected marker");
    }

    @Test
    void playerIdentity() {
        // Arrange
        Player player1 = new Player('X');
        Player player2 = new Player('X');
        Player player3 = new Player('O');

        // Act & Assert
        //ensures that the objects are the same instances in memory --> does not rely on the "equals" and "hashCode" methods
        assertSame(player1, player1, "Players with the same reference should be identical");
        assertNotSame(player1, player2, "Players with the same marker should not be the same reference");
        assertNotSame(player1, player3, "Players with different markers should not be the same reference");
    }

}