package entities;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> grid;

    public Board(int size) {
        this.size = size;
        grid = new ArrayList<>();
        for(int i=0; i<size; i++){
            grid.add(new ArrayList<>());
            for(int j=0; j<size; j++){
                grid.get(i).add(new Cell(i,j));
            }
        }
    }

    public int getSize() {
        return size;
    }

    public List<List<Cell>> getGrid() {
        return grid;
    }

    public void display(){
        System.out.println("Current Status of the Board");
        for (List<Cell> cellList : grid){
            for(Cell cell : cellList){
                cell.display();
            }
            System.out.println();
        }
    }


}
