package org.academiadecodigo.bootcamp.GameEngine.Objects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Score {

    private Text object;

    public Score(int score){
        this.object = new Text(440,250,"WAVE " + score);
        this.object.setColor(Color.WHITE);
        this.object.draw();
        this.object.grow(120, 70);
    }

    public void update(int score) {
        try{
            Thread.sleep(500);
        }catch (Exception e){
            System.out.println("error");
        }
        object.delete();

        object.draw();
        object.setText("WAVE " + score) ;
        try{
            Thread.sleep(500);
        }catch (Exception e){
            System.out.println("error");
        }

    }

    public void hide(){
        object.delete();
    }

    public void show(){
        object.draw();
    }
}
