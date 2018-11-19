package com.ikemo3.lifegame;

public final class Main {
    public static final Cell[] CELLS = {
            new DeadCell(), new AliveCell(), new DeadCell(),
            new DeadCell(), new AliveCell(), new DeadCell(),
            new DeadCell(), new AliveCell(), new DeadCell()
    };

    public static void main(String[] args) {
        Generation generation = new Generation(CELLS);
        System.out.println(generation.toString());
        Generation nextGeneration = generation.next();
        System.out.println(nextGeneration.toString());
        Generation nextGeneration2 = nextGeneration.next();
        System.out.println(nextGeneration2.toString());
    }
}
