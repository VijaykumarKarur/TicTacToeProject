package dev.vijay.model;

public class Cell {
    private Symbol symbol;

    public Cell(){
        this.symbol = Symbol.NONE;
    }
    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
