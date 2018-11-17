package org.academiadecodigo.bootcamp.GameObjects.Enemy;

import org.academiadecodigo.bootcamp.GameEngine.GameConfigs;
import org.academiadecodigo.bootcamp.GameEngine.Objects.Graphics;
import org.academiadecodigo.bootcamp.GameEngine.Random;


public class Ship extends Enemy {

    public Ship(){
        super(new Graphics((double)Random.getRandomNumberWithZero(GameConfigs.ROW-2)+1,
                GameConfigs.COL -1,
                1));
    }

    public void move() {
        move(getDirection());
    }

    @Override
    public void hit() {
        setDestroyed();
    }
    public Graphics getGraphics(){
        return super.getGraphics();
    }
    public void hide(){
        getObject().hide();
    }
}