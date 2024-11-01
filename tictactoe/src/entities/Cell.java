package entities;

public class Cell {
    private int row;
    private int col;
    private CellStatus status;
    private Symbol symbol;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public void display(){
        if(this.status == CellStatus.FILL) {
            System.out.print("| " + this.symbol + " ");
        }else{
            System.out.print("| - |");
        }
    }
}
