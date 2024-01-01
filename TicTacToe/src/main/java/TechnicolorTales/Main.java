package TechnicolorTales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            ticTacToe.start();
            System.out.println("--------------------");
            System.out.println("Start a new game? Y or N ");
            if (bufferedReader.readLine().trim().equalsIgnoreCase("Y")) {
                ticTacToe.getBoard().clear();
                ticTacToe.setCurrentplayer(ticTacToe.getPlayer1());
                ticTacToe.start();
            }

        } catch (IOException var4) {
            throw new RuntimeException(var4);
        }
    }
}