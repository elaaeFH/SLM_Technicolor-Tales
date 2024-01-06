package TechnicolorTales;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
    private char[][] cells; //Reihe und Spalte

    public Board() {
        cells=new char[3][3];
    }

    public boolean isCellEmpty(int x, int y){
        if(cells[x][y]==' ')
            return true;
        return false;
    }

    public void place(int x,int y, char marker){
        if(isCellEmpty(x,y)){
            cells[x][y]=marker;
        }
    }

    public boolean isFull(){
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if(cells[i][j]==' ') //Wenn noch eine Zelle leer ist
                    return false;
            }
        }
        return true; //Keine leeren Zellen gefunden also ist der Board voll
    }
    public void clear(){
        for (int i = 0; i < 3; i++) { // Von 0 bis exklusive 3
            for (int j = 0; j < 3; j++) {
                cells[i][j]=' ';
            }
        }
    }

    public boolean hasWinner(){
        for(int i = 0; i < 3; ++i) { //Reihen Check
            if (this.cells[i][0] != ' ' && this.cells[i][0] == this.cells[i][1] && this.cells[i][0] == this.cells[i][2]) {
                return true;
            }
        }

        for(int i = 0; i < 3; ++i) { //Spalten Check
            if (this.cells[0][i] != ' ' && this.cells[0][i] == this.cells[1][i] && this.cells[0][i] == this.cells[2][i]) {
                return true;
            }
        }

        // Diagonale von (0,0) bis (2,2)
        if (this.cells[0][0] != ' ' && this.cells[0][0] == this.cells[1][1] && this.cells[0][0] == this.cells[2][2])
            return true;

        // Diagonale von (0,2) bis (2,0)
        if (this.cells[0][2] != ' ' && this.cells[0][2] == this.cells[1][1] && this.cells[0][2] == this.cells[2][0])
            return true;

        return false;
    }

    public void print(){
        System.out.println("▁▁▁▁▁▁▁▁▁▁"); //Von der Angabe Output Example kopiert
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                if(isCellEmpty(i,j))
                    System.out.print(" ");
                System.out.print(cells[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("▔▔▔▔▔▔▔▔▔▔");
    }

}
