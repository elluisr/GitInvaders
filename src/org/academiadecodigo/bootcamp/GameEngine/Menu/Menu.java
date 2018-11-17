package org.academiadecodigo.bootcamp.GameEngine.Menu;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.GameEngine.EngineFactory;
import org.academiadecodigo.bootcamp.GameEngine.Field.Grid;
import org.academiadecodigo.bootcamp.GameEngine.GameConfigs;
import org.academiadecodigo.bootcamp.music.Music;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.io.IOException;


public class Menu implements Grid, KeyboardHandler {

    private Game game;
    private Picture menu;
    private int row;
    private int col;
    private int CELLSIZE = GameConfigs.CELLSIZE;
    private Keyboard keyboard;
    private boolean isInCredits = false;
    private Animation animation;
    private boolean status = true;

    public Menu(int row, int col) {
        this.row = row;
        this.col = col;
        this.keyboard = new Keyboard(this);
        EngineFactory.field();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        Music music = new Music("menu");
        music.startMusic(true);
        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_1:
                menu.delete();
                status = false;
                break;

            case KeyboardEvent.KEY_2:
                System.exit(0);
                break;

            case KeyboardEvent.KEY_3:

                if (isInCredits) {
                    System.out.println("main menu");
                    menu.delete();
                    mainMenu();
                    isInCredits = false;
                } else {
                    // animation.setPumped(false);
                    credits();
                    isInCredits = true;
                    //}
                    break;

                }
        }
    }
        @Override
        public void keyReleased (KeyboardEvent keyboardEvent){

        }

        public void init () {

            KeyboardEvent enterKey = new KeyboardEvent();
            enterKey.setKey(KeyboardEvent.KEY_1);
            enterKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(enterKey);


            KeyboardEvent escapeKey = new KeyboardEvent();
            escapeKey.setKey(KeyboardEvent.KEY_2);
            escapeKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(escapeKey);

            KeyboardEvent creditsKey = new KeyboardEvent();
            creditsKey.setKey(KeyboardEvent.KEY_3);
            creditsKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(creditsKey);

            KeyboardEvent creditsExitKey = new KeyboardEvent();
            creditsExitKey.setKey(KeyboardEvent.KEY_4);
            creditsExitKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(creditsExitKey);

            mainMenu();

        }

        private void mainMenu () {

            menu = new Picture(col, row, "resources/git_invaders_logo_4.png");
            menu.draw();
            this.animation = new Animation(menu, 6);
            //animation.draw();
            // animation.init();

        }

        private void credits () {
            menu.delete();
            menu = new Picture(col, row, "resources/git_invaders_credits.png");
            menu.draw();

        }

        private void gameOver () {
            menu = new Picture(col, row, "resources/git_invaders_gameOver.png");
            menu.draw();
        }


        public void delete () {
            menu.delete();
        }

        public double getRow () {
            return row;
        }

        public double getCol () {
            return col;
        }

        public double getWidth () {
            return col * CELLSIZE;
        }

        public double getHeight () {
            return row * CELLSIZE;
        }

        public void setRow ( int row){
            this.row = row;
        }

        public void setCol ( int col){
            this.col = col;
        }

        public int getCELLSIZE () {
            return CELLSIZE;
        }

        public void setCELLSIZE ( int CELLSIZE){
            this.CELLSIZE = CELLSIZE;
        }


    public boolean isStatus() {
        return status;
    }
}
