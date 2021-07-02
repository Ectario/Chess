package com.ectario.tools;

public class Tools {
    public static int randrange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
