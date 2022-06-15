package dev.vijay.model;

import java.util.Random;

public class ComputerPlayer extends Player{
    public int[] makeMove(int dimension){
        Random random = new Random();
        int[] position = new int[2];
        position[0] = random.nextInt(dimension);
        position[1] = random.nextInt(dimension);
        System.out.println(position[0] + " " + position[1]);
        return position;
    }
}
