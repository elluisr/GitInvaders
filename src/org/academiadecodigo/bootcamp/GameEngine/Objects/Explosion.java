package org.academiadecodigo.bootcamp.GameEngine.Objects;

import org.academiadecodigo.bootcamp.GameEngine.Field.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Explosion {

        private Position po;
        private Picture object;
        private String[] resource = {"resources/explosion/1.png","resources/explosion/2.png","resources/explosion/3.png","resources/explosion/4.png"};
        private int delay;

        public Explosion(double row, double col, int delay){
            this.delay = delay;
            this.po = new Position(row, col);
            init();
        }

        public void loopImage(){
            for(int i = 0; i < 4 ; i++){
                this.object.draw();
                try {
                    Thread.sleep(delay);
                }catch (Exception e){
                    System.out.println("teste");
                }
                this.object.delete();
                this.object = new Picture(po.getWidth(),po.getHeight(),resource[i]);
            }
        }

        public void init(){
            this.object = new Picture(po.getWidth(),po.getHeight(),resource[0]);
            loopImage();
        }

        public void hide(){
            object.delete();
        }

        public void show(){
            object.draw();
        }

}


