package com.ikemo3.lifegame.cell;

/**
 * 生きているセル
 */
public final class AliveCell implements Cell {
    @Override
    public Cell next(Cells aroundCells) {
        long countAlive = aroundCells.countAlive();

        if (countAlive == 2 || countAlive == 3) {
            return new AliveCell();
        } else {
            return new DeadCell();
        }
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public String toString() {
        return "■";
    }
}
