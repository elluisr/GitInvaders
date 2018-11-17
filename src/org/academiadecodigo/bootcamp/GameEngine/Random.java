package org.academiadecodigo.bootcamp.GameEngine;

    public class Random {

        public static int getRandomNumberWithZero(int maxnumber){
        //Excludes max number
        return (int) Math.floor((Math.random() * maxnumber));
        }

        public static int getRandomNumber(int maxnumber) {
            //includes max number
            return (int) Math.floor((Math.random() * maxnumber) + 1);
        }

    }
