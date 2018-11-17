package org.academiadecodigo.bootcamp.GameObjects.Enemy;

import org.academiadecodigo.bootcamp.GameEngine.Direction.Directions;
import org.academiadecodigo.bootcamp.GameEngine.Field.Position;
import org.academiadecodigo.bootcamp.GameEngine.GameConfigs;
import org.academiadecodigo.bootcamp.GameEngine.Objects.Explosion;
import org.academiadecodigo.bootcamp.GameEngine.Objects.Graphics;
import org.academiadecodigo.bootcamp.GameEngine.Random;
import org.academiadecodigo.bootcamp.GameObjects.Bullet;
import org.academiadecodigo.bootcamp.GameObjects.GameObjects;
import org.academiadecodigo.bootcamp.GameObjects.Shootable;

public abstract class Enemy extends GameObjects implements Shootable {

    private Graphics object;
    private boolean destroyed;
    private Directions direction;
    private int timesToMove;
    private Bullet[] bullets = new Bullet[100];



    public Enemy(Graphics object){

        this.destroyed = false;
        this.object = object;
        this.timesToMove = GameConfigs.CELLSIZE * 2;
        this.direction = Directions.LEFT;
    }

    @Override
    public void move(Directions direction) {

        if(isDestroyed()){
            return;
        }
        animate();
        getRandomShot();

        if (timesToMove == 0) {
            this.direction = getRandomDirection();
        }
        direction = this.direction;
        object.move(direction, 1);
        timesToMove--;

    }

    @Override
    public void shoot() {
        for(int i = 0; i < bullets.length; i++){
            if( bullets[i] != null && bullets[i].isDestroyed()){
                bullets[i] = null;
            }
            if(bullets[i] == null){
                bullets[i] = new Bullet( new Position(getGraphics().getPo().getRow(), getGraphics().getPo().getCol()),
                        this, 3);
                break;
            }
        }
    }

    public void moveBullet(){
        for(int i = 0; i < bullets.length; i++){
            if(bullets[i] != null && bullets[i].isDestroyed()) {
                continue;
            }
            if(bullets[i] != null){
                bullets[i].move(Directions.LEFT);
            }
        }
    }

    private void getRandomShot(){
        int random = Random.getRandomNumberWithZero(20);

        if(timesToMove == 40 || timesToMove == 0){
            if( random == 3){
                shoot();
            }
        }
    }

    private Directions getRandomDirection() {
        int random = Random.getRandomNumber(2);

        if(random != 2) {
            timesToMove = GameConfigs.CELLSIZE * 2;
            return Directions.LEFT;
        }

        timesToMove = GameConfigs.CELLSIZE;
        return Directions.values()[Random.getRandomNumberWithZero(3)];
    }


    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed() {
        destroyBullets();
        getGraphics().hide();
        Explosion explosion = new Explosion(getGraphics().getPo().getRow(),getGraphics().getPo().getCol(),7);
        this.destroyed = true;
    }

    public void destroyBullets() {
        for(Bullet bullet : bullets) {
            if(bullet == null) {
                continue;
            }
            bullet.destroyed();
        }
    }

    public void animate() {
        object.hide();
        object.show();
    }

    public Graphics getObject() {
        return object;
    }
    public Directions getDirection() {
        return direction;
    }
    public Bullet[] getBullets(){
        return this.bullets;
    }
    public Graphics getGraphics(){
        return this.object;
    }
}
