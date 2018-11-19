package com.ikemo3.lifegame;

import com.ikemo3.lifegame.cell.AliveCell;
import com.ikemo3.lifegame.cell.Cell;
import com.ikemo3.lifegame.cell.DeadCell;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public final class TestGrid {
    private static final List<Cell> CELLS = Arrays.asList(
            new DeadCell(), new AliveCell(), new DeadCell(),
            new AliveCell(), new DeadCell(), new DeadCell(),
            new AliveCell(), new DeadCell(), new DeadCell()
    );

    @Test
    public void testAroundCells() {
        Grid grid = new SquareGrid(3, 3, CELLS);

        assertThat(grid.aroundCells(CELLS.get(4)).size()).isEqualTo(8);
        assertThat(grid.aroundCells(CELLS.get(0)).size()).isEqualTo(3);
    }
}
