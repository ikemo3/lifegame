package com.ikemo3.lifegame.cell;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public final class TestCell {
    @Test
    public void testAlive3() {
        Cell aliveCell = new AliveCell();
        List<Cell> aroundCell = Arrays.asList(new DeadCell(), new AliveCell(), new AliveCell(), new AliveCell());

        Cell nextCell = aliveCell.next(aroundCell);
        assertThat(nextCell.isAlive()).isTrue();
    }

    @Test
    public void testAlive2() {
        Cell aliveCell = new AliveCell();
        List<Cell> aroundCell = Arrays.asList(new DeadCell(), new AliveCell(), new AliveCell());

        Cell nextCell = aliveCell.next(aroundCell);
        assertThat(nextCell.isAlive()).isTrue();
    }

    @Test
    public void testUnderpopulation() {
        Cell aliveCell = new AliveCell();
        List<Cell> aroundCell = Arrays.asList(new DeadCell(), new AliveCell());

        Cell nextCell = aliveCell.next(aroundCell);
        assertThat(nextCell.isAlive()).isFalse();
    }

    @Test
    public void testOverpopulation() {
        Cell aliveCell = new AliveCell();
        List<Cell> aroundCell = Arrays.asList(new DeadCell(), new AliveCell(), new AliveCell(), new AliveCell(), new AliveCell());

        Cell nextCell = aliveCell.next(aroundCell);
        assertThat(nextCell.isAlive()).isFalse();
    }

    @Test
    public void testReproduction() {
        Cell deadCell = new DeadCell();
        List<Cell> aroundCell = Arrays.asList(new DeadCell(), new AliveCell(), new AliveCell(), new AliveCell());

        Cell nextCell = deadCell.next(aroundCell);
        assertThat(nextCell.isAlive()).isTrue();
    }

    @Test
    public void testDead() {
        Cell deadCell = new DeadCell();
        List<Cell> aroundCell = Arrays.asList(new DeadCell(), new AliveCell(), new AliveCell(), new AliveCell(), new AliveCell());

        Cell nextCell = deadCell.next(aroundCell);
        assertThat(nextCell.isAlive()).isFalse();
    }
}
