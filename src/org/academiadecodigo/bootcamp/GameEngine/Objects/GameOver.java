package org.academiadecodigo.bootcamp.GameEngine.Objects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class GameOver {

    private Text object;

    public GameOver(){
        this.object = new Text(440,250,"GAME OVER");
        this.object.setColor(Color.WHITE);
        this.object.draw();
        this.object.grow(200, 70);
    }


}
