package org.academiadecodigo.bootcamp.GameEngine.Field;


import org.academiadecodigo.bootcamp.GameEngine.Direction.Direction;
import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;

public class Position implements Grid {

    private double row;
    private double col;
    private int CELLSIZE = 40;
    private int counterMovesRight = 0;
    private int counterMovesLeft = 0;
    private int counterMovesUp = 0;
    private int counterMovesDown = 0;


    public Position(double row, double col){
        this.row = row;
        this.col = col;
    }


    public double getRow(){
        return row;
    }

    public double getCol(){
        return col;
    }

    public double getWidth(){
        return col * CELLSIZE;
    }

    public double getHeight(){
        return row * CELLSIZE;
    }

    public void setCol(double col) {
        this.col = col;
    }


    public void movePosition(int speed, Directions direction){

        incrementMoves(speed,direction);

        if(counterMovesRight >= CELLSIZE ||
                counterMovesLeft >= CELLSIZE ||
                counterMovesDown >= CELLSIZE ||
                counterMovesUp >= CELLSIZE){

            switch (direction){
                case UP:
                    row = row - 1;
                    counterMovesUp = 0;
                    break;
                case DOWN:
                    row = row +1;
                    counterMovesDown = 0;
                    break;
                case LEFT:
                    col = col -1;
                    counterMovesLeft = 0;
                    break;
                case RIGHT:
                    col = col + 1;
                    counterMovesRight = 0;
                    break;
            }

        }
    }

    public void incrementMoves(int speed, Directions direction) {
        switch (direction) {
            case UP:
               counterMovesUp += speed;
               break;
            case DOWN:
                counterMovesDown += speed;
                break;
            case LEFT:
                counterMovesLeft += speed;
                break;
            case RIGHT:
                counterMovesRight += speed;
                break;
        }
    }
}
