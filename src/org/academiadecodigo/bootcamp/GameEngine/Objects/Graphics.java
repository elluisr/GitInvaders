package org.academiadecodigo.bootcamp.GameEngine.Objects;

import org.academiadecodigo.bootcamp.GameEngine.Direction.Direction;
import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameEngine.Field.Position;
import org.academiadecodigo.bootcamp.GameEngine.GameConfigs;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Graphics extends Direction {

    private Position po;
    private Picture object;
    private String[] resource = {"resources/player.png", "resources/enemies.png", "resources/bullets.png",
                                 "resources/bullet_enemy.png"};
    private int resources;

    public Graphics(double row, double col, int resources){
        this.po = new Position(row, col);
        this.resources = resources;
        init();
    }

    public Graphics(Position position, int resources){
        this.po = position;
        this.resources = resources;
        init();
    }

    public void init(){
        this.object = new Picture(po.getWidth(),po.getHeight(),resource[resources]);
        this.object.draw();
    }

    public void hide(){
        object.delete();
    }

    public void show(){
        object.draw();
    }

    public void move(Directions direction, int speed){
        switch (direction){
            case UP:
                if(!(po.getRow() < 2)){
                    moveDirection(0, -speed);
                    getPos(speed, direction);
                }
                break;
            case DOWN:
                if(!(po.getRow() >= GameConfigs.ROW-2)){
                    moveDirection(0, speed);
                    getPos(speed, direction);
                    break;
                }
                break;
            case LEFT:
                if(!(po.getCol() < 1)){
                    moveDirection(-speed, 0);
                    getPos(speed, direction);
                    break;
                }
                break;
            case RIGHT:
                if(!(po.getCol() >= GameConfigs.COL-2 )){
                    moveDirection(speed, 0);
                    getPos(speed, direction);
                    break;
                }
                break;
        }
    }

    public void moveDirection(int x, int y){
        object.translate(x,y);
    }

    public Position getPo(){
        return po;
    }

    private void getPos(int speed, Directions direction){
        po.movePosition(speed, direction);
    }

    public void setPo(Position pos){
        this.po =pos;
    }

}
