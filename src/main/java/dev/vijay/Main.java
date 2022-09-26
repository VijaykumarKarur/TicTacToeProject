package dev.vijay;

import dev.vijay.constant.PropertyConstants;
import dev.vijay.factory.WInningStrategyFactory;
import dev.vijay.model.Game;
import dev.vijay.model.PlayerType;
import dev.vijay.strategy.IWinningStrategy;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        //Initialize Game with dimension of the board and player types
        InputStream io;
        try{
            io = new FileInputStream("application.properties");
            Properties properties = new Properties();
            properties.load(io);

            //read playertype1, playertype2 and board dimension from properties
            PlayerType playerType1 = properties.getProperty(PropertyConstants.PLAYER1).equals(PropertyConstants.HUMAN) ? PlayerType.HUMAN : PlayerType.COMPUTER;
            PlayerType playerType2 = properties.getProperty(PropertyConstants.PLAYER2).equals(PropertyConstants.HUMAN) ? PlayerType.HUMAN : PlayerType.COMPUTER;
            String winningStrategyProperty = properties.getProperty(PropertyConstants.WINNING_STRATEGY);
            IWinningStrategy winningStrategy = WInningStrategyFactory.getWinningStrategy(winningStrategyProperty);
            Game game = new Game(Integer.parseInt(properties.getProperty(PropertyConstants.DIMENSION)),
                    playerType1,
                    playerType2,
                    winningStrategy);

            //launch the game
            game.launch();
        }
        catch(Exception exception){
            System.out.println("Exception Occurred : " + exception.getMessage());
        }
    }
}