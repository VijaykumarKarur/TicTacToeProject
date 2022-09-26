package dev.vijay.strategy;

import dev.vijay.model.Board;
import dev.vijay.model.Player;

public interface IWinningStrategy {
    boolean hasWon(Board board, Player player, int rIndex, int cIndex);
}
