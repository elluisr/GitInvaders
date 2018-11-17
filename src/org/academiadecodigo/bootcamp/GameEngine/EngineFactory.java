package org.academiadecodigo.bootcamp.GameEngine;

import org.academiadecodigo.bootcamp.GameEngine.Field.Canvas;
import org.academiadecodigo.bootcamp.GameEngine.Objects.Graphics;
import org.academiadecodigo.bootcamp.GameEngine.Objects.Score;

public class EngineFactory {

    public static Canvas field(){
        return new Canvas();
    }

    public static void object(double row, double col, int resource){
        Graphics object = new Graphics(row,col, resource);
        object.init();
    }

}
