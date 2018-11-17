package org.academiadecodigo.bootcamp.GameEngine.Direction;

public abstract class Direction {

    public abstract void move(Directions directions, int veloci) throws Exception;

    public abstract void  moveDirection(int x, int y) throws Exception;
}
