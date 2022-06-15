package dev.vijay.model;

import dev.vijay.constant.ExceptionMessage;
import dev.vijay.exception.InvalidInputException;

import java.util.Scanner;

public class HumanPlayer extends Player{
    public int[] makeMove(int dimension) throws Exception{
        int[] position  = new int[2];

        //Read user input from console
        while(true) {
            try {
                Scanner inputScanner = new Scanner(System.in);
                position[0] = inputScanner.nextInt();
                position[1] = inputScanner.nextInt();

                //Validate user input
                if(position[0] < 0 || position[0] >= dimension ||
                position[1] < 0 || position[1] >= dimension){
                    throw new InvalidInputException(ExceptionMessage.INVALID_INPUT);
                }
                else{
                    break;
                }

            } catch (Exception exception) {
                throw new InvalidInputException(exception.getMessage());
            }
        }

        return position;
    }
}
