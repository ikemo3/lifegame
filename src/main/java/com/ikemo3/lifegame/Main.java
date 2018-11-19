package com.ikemo3.lifegame;

import com.ikemo3.lifegame.cell.AliveCell;
import com.ikemo3.lifegame.cell.Cell;
import com.ikemo3.lifegame.cell.DeadCell;
import com.ikemo3.lifegame.grid.Grid;
import com.ikemo3.lifegame.grid.SquareGrid;

import java.util.Arrays;
import java.util.List;

public final class Main {
    public static final List<Cell> CELLS = Arrays.asList(
            new DeadCell(), new AliveCell(), new DeadCell(), new DeadCell(),
            new DeadCell(), new AliveCell(), new DeadCell(), new DeadCell(),
            new DeadCell(), new AliveCell(), new DeadCell(), new DeadCell()
    );

    public static void main(String[] args) {
        Grid grid = new SquareGrid(4, 3, CELLS);
        Generation generation = new Generation(grid);
        System.out.println(generation.toString());
        Generation nextGeneration = generation.next();
        System.out.println(nextGeneration.toString());
        Generation nextGeneration2 = nextGeneration.next();
        System.out.println(nextGeneration2.toString());
    }
}
