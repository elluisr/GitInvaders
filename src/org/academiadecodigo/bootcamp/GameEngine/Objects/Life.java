package org.academiadecodigo.bootcamp.GameEngine.Objects;

import org.academiadecodigo.bootcamp.GameEngine.Field.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Life {

        private Position po;
        private Picture object;
        private String[] resource = {"resources/life.png"};
        private int resources;

        public Life(double col){
            this.po = new Position(0.2, col);
            this.resources = resources;
            init();
        }

        public void init(){
            this.object = new Picture(po.getWidth(),po.getHeight(),resource[0]);
            this.object.draw();
        }

        public void hide(){
            object.delete();
        }

        public void show(){
            object.draw();
        }
}
