package dev.vijay.model;

public abstract class Player {
    private PlayerType playerType;
    private Symbol symbol;

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public abstract int[] makeMove(int dimension) throws Exception;
}
