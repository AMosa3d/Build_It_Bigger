package com.example;

import java.util.Random;

public final class Joker {
    static String[] JOKES = {"Joke 1", "Joke 2","Joke 3"};

    public static String TellJoke()
    {
        Random random = new Random();
        return JOKES[new Random().nextInt() % JOKES.length];
    }
}
