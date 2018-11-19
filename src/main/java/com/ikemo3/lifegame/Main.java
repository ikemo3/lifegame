package com.ikemo3.lifegame;

import com.ikemo3.lifegame.cell.AliveCell;
import com.ikemo3.lifegame.cell.Cell;
import com.ikemo3.lifegame.cell.DeadCell;

import java.util.Arrays;
import java.util.List;

public final class Main {
    public static final List<Cell> CELLS = Arrays.asList(
            new DeadCell(), new AliveCell(), new DeadCell(),
            new DeadCell(), new AliveCell(), new DeadCell(),
            new DeadCell(), new AliveCell(), new DeadCell()
    );

    public static void main(String[] args) {
        Generation generation = new Generation(CELLS);
        System.out.println(generation.toString());
        Generation nextGeneration = generation.next();
        System.out.println(nextGeneration.toString());
        Generation nextGeneration2 = nextGeneration.next();
        System.out.println(nextGeneration2.toString());
    }
}
