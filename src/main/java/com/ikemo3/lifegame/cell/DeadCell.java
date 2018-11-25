package com.ikemo3.lifegame.cell;

/**
 * 死んでいるセル
 */
public final class DeadCell implements Cell {
    @Override
    public Cell next(Cells aroundCells) {
        long countAlive = aroundCells.countAlive();

        if (countAlive == 3) {
            return new AliveCell();
        } else {
            return new DeadCell();
        }
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public String toString() {
        return "□";
    }
}
