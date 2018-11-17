package org.academiadecodigo.bootcamp.GameEngine.Menu;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Animation {

    private Picture menu;
    private Picture[] pictures;
    private double maximumRadius;
    private int radius;
    private boolean isGrowing;
    private boolean isPumped;

    public Animation(Picture menu, int maximumRadius) {

        this.menu = menu;
        this.maximumRadius = maximumRadius;
        this.radius = 0;
        this.isGrowing = true;

        this.pictures = new Picture[3];
        pictures[0] = new Picture(menu.getWidth() / 2 - 93, 400, "resources/git_invaders_pressStart_001.png");
        pictures[1] = new Picture(menu.getWidth() / 2 - 93, 450, "resources/git_invaders_Exit_002.png");
        pictures[2] = new Picture(menu.getWidth() / 2 - 110.5, 500, "resources/git_invaders_pressCredits_003.png");

    }

    public void draw() {
        for (Picture pic : pictures) {
            System.out.println("draw");
            pic.draw();
        }
    }

    public void init() {
        System.out.println("in animation init");
        isPumped = true;



        while(isPumped) {
            System.out.println(isPumped);
            pump();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        collapse();
    }

    public void grow() {
        if (this.radius < this.maximumRadius) {

            for (Picture pic : pictures) {

                pic.grow(1, 1);
            }

            this.radius++;
        }
    }

    public void shrink() {
        if (this.radius > 0) {

            for (Picture pic : pictures) {
                pic.grow(-1, -1);
            }

            this.radius--;
        }
    }


    public void collapse() {
        this.radius = 0;
        this.isGrowing = true;

        for (Picture pic : pictures) {
            pic.delete();
        }
    }

    public void pump() {
        if (this.radius == 0) {

            this.isGrowing = true;
            this.grow();
        } else if (this.radius == this.maximumRadius) {

            this.isGrowing = false;
            this.shrink();
        } else if (this.isGrowing) {

            this.grow();
        } else {

            this.shrink();
        }
    }

    public Picture getMenu() {
        return menu;
    }

    public void setMenu(Picture menu) {
        this.menu = menu;
    }

    public Picture[] getPictures() {
        return pictures;
    }

    public void setPictures(Picture[] pictures) {
        this.pictures = pictures;
    }

    public double getMaximumRadius() {
        return maximumRadius;
    }

    public void setMaximumRadius(double maximumRadius) {
        this.maximumRadius = maximumRadius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean isGrowing() {
        return isGrowing;
    }

    public void setGrowing(boolean growing) {
        isGrowing = growing;
    }

    public boolean isPumped() {
        return isPumped;
    }

    public void setPumped(boolean pumped) {
        isPumped = pumped;
    }

}
