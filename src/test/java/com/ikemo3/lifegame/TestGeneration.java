package com.ikemo3.lifegame;

import com.ikemo3.lifegame.cell.AliveCell;
import com.ikemo3.lifegame.cell.Cell;
import com.ikemo3.lifegame.cell.DeadCell;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public final class TestGeneration {
    public static final List<Cell> CELLS = Arrays.asList(new DeadCell(), new AliveCell(), new DeadCell(),
            new AliveCell(), new DeadCell(), new DeadCell(),
            new AliveCell(), new DeadCell(), new DeadCell());

    @Test
    public void testNextGeneration() {
        Generation generation = new Generation(CELLS);
        Generation nextGeneration = generation.next();

        assertThat(nextGeneration.isAlive(1, 1)).isTrue();
        assertThat(nextGeneration.isAlive(2, 0)).isFalse();
    }

    @Test
    public void testAroundCells() {
        Generation generation = new Generation(CELLS);

        assertThat(generation.aroundCells(CELLS.get(4)).size()).isEqualTo(8);
        assertThat(generation.aroundCells(CELLS.get(0)).size()).isEqualTo(3);
    }
}
