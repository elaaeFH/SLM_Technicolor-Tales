package TechnicolorTales;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

    public void print(){
        System.out.println("▁▁▁▁"); //Von der Angabe Output Example kopiert
        for (int i = 0; i < 3; i++) {
            System.out.println("|");
            for (int j = 0; j < 3; j++) {
                if(isCellEmpty(i,j))
                    System.out.println(" ");
                System.out.println(cells[i][j]);
                System.out.println("|");
            }
        }
        System.out.println("▔▔▔▔");
    }

}
