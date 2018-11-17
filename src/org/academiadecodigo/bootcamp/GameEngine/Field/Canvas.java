package org.academiadecodigo.bootcamp.GameEngine.Field;

import org.academiadecodigo.bootcamp.GameEngine.GameConfigs;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Canvas extends GameConfigs implements Grid {

    public double row = GameConfigs.ROW;
    public double col = GameConfigs.COL;
    public int CELLSIZE = GameConfigs.CELLSIZE;
    public Picture[] field;
    private int currentPic;

    public void init(){
        field = new Picture[39];
        currentPic = 0;
        for(int i = 0; i < field.length; i++) {
            int picNumber = i+1;
            field[i] = new Picture(0,0, "resources/background/bg (" + picNumber +").jpg");
        }
        field[0].draw();
    }

    public void animate() {
        field[currentPic].delete();
        currentPic++;
        if(currentPic >= field.length) {
            currentPic = 0;
        }
        field[currentPic].draw();
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

}
