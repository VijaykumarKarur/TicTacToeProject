package dev.vijay.factory;

import dev.vijay.model.ComputerPlayer;
import dev.vijay.model.HumanPlayer;
import dev.vijay.model.Player;
import dev.vijay.model.PlayerType;

public class PlayerFactory {
    /***
     * The Factory Method returns concrete Player object based on the PlayerType
     * @param playerType Either HUMAN or COMPUTER
     * @return concrete Player object based on the Player Type
     */
    public static Player getPlayer(PlayerType playerType){
        //If PlayerType is HUMAN
        if(playerType == PlayerType.HUMAN){
            return new HumanPlayer();
        }
        //If PlayerType is COMPUTER
        else if(playerType == PlayerType.COMPUTER){
            return new ComputerPlayer();
        }
        else{
            return null;
        }
    }
}
