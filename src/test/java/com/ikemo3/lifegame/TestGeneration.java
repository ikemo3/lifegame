package com.ikemo3.lifegame;

import com.ikemo3.lifegame.cell.AliveCell;
import com.ikemo3.lifegame.cell.Cell;
import com.ikemo3.lifegame.cell.DeadCell;
import com.ikemo3.lifegame.grid.Grid;
import com.ikemo3.lifegame.grid.RectangleLocation;
import com.ikemo3.lifegame.grid.RectangleGrid;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public final class TestGeneration {
    private static final List<Cell> CELLS = Arrays.asList(
            new DeadCell(), new AliveCell(), new DeadCell(),
            new AliveCell(), new DeadCell(), new DeadCell(),
            new AliveCell(), new DeadCell(), new DeadCell()
    );

    @Test
    public void testNextGeneration() {
        Grid grid = new RectangleGrid(3, 3, CELLS);
        Generation generation = new Generation(grid);
        Generation nextGeneration = generation.next();

        assertThat(nextGeneration.isAlive(new RectangleLocation(1, 1))).isTrue();
        assertThat(nextGeneration.isAlive(new RectangleLocation(2, 0))).isFalse();
    }
}
