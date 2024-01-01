package TechnicolorTales;

import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Getter
@Setter
public class TicTacToe {

    private final Player player1;
    private final Player player2;
    private Player currentplayer;
    private final Board board;

    public TicTacToe() {
        this.player1=new Player('X');
        this.player2=new Player('O');
        this.currentplayer=player1; //Player 1 beginnt, TicTacToe beginnt immer mit X
        this.board=new Board();
    }

    public void start() throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        board.clear();

        while(!board.hasWinner() && !board.isFull()){
            System.out.println();
            System.out.println("Current Player: "+currentplayer.getMarker());
            board.print();

            int x,y;

            System.out.println("row (0-2): ");
            x= Integer.parseInt(bufferedReader.readLine());
            System.out.println("column (0-2): ");
            y=Integer.parseInt(bufferedReader.readLine());

            if(!board.isCellEmpty(x,y)){
                System.out.println("Cell is already full");
            } else {
                board.place(x,y, currentplayer.getMarker());
                switchCurrentPlayer();
            }
        }

        if(board.hasWinner()){
            switchCurrentPlayer();
            System.out.println("Player "+ currentplayer.getMarker() + " wins ҉ ヽ(^o^)/ ҉ ");
        } else if(board.isFull()){
            System.out.println("It is a draw :/ ");
        }

    }
    //hasWinner Methode ist in der Board Klasse
    private void switchCurrentPlayer(){
        if(currentplayer==player1){
            currentplayer=player2;
        } else currentplayer= player1;
    }
}
