package org.academiadecodigo.bootcamp.GameObjects;
import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameEngine.Objects.Graphics;

public abstract class GameObjects {

    public abstract void move(Directions direction);

    public abstract void hit();

    public abstract boolean isDestroyed();

    public abstract Graphics getGraphics();
}
