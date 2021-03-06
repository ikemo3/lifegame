package com.ikemo3.lifegame.cell;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class TestCell {
    @Test
    public void testAlive3() {
        Cell aliveCell = new AliveCell();
        Cells aroundCells = Cells.of(new DeadCell(), new AliveCell(), new AliveCell(), new AliveCell());

        Cell nextCell = aliveCell.next(aroundCells);
        assertThat(nextCell.isAlive()).isTrue();
    }

    @Test
    public void testAlive2() {
        Cell aliveCell = new AliveCell();
        Cells aroundCells = Cells.of(new DeadCell(), new AliveCell(), new AliveCell());

        Cell nextCell = aliveCell.next(aroundCells);
        assertThat(nextCell.isAlive()).isTrue();
    }

    @Test
    public void testUnderpopulation() {
        Cell aliveCell = new AliveCell();
        Cells aroundCells = Cells.of(new DeadCell(), new AliveCell());

        Cell nextCell = aliveCell.next(aroundCells);
        assertThat(nextCell.isAlive()).isFalse();
    }

    @Test
    public void testOverpopulation() {
        Cell aliveCell = new AliveCell();
        Cells aroundCells = Cells.of(new DeadCell(), new AliveCell(), new AliveCell(), new AliveCell(), new AliveCell());

        Cell nextCell = aliveCell.next(aroundCells);
        assertThat(nextCell.isAlive()).isFalse();
    }

    @Test
    public void testReproduction() {
        Cell deadCell = new DeadCell();
        Cells aroundCells = Cells.of(new DeadCell(), new AliveCell(), new AliveCell(), new AliveCell());

        Cell nextCell = deadCell.next(aroundCells);
        assertThat(nextCell.isAlive()).isTrue();
    }

    @Test
    public void testDead() {
        Cell deadCell = new DeadCell();
        Cells aroundCells = Cells.of(new DeadCell(), new AliveCell(), new AliveCell(), new AliveCell(), new AliveCell());

        Cell nextCell = deadCell.next(aroundCells);
        assertThat(nextCell.isAlive()).isFalse();
    }

    @Test
    public void testDeadToString() {
        Cell cell = new DeadCell();
        assertThat(cell.toString()).isEqualTo("□");
    }

    @Test
    public void testAliveToString() {
        Cell cell = new AliveCell();
        assertThat(cell.toString()).isEqualTo("■");
    }
}
