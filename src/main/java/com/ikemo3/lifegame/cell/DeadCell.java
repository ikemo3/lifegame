package com.ikemo3.lifegame.cell;

import java.util.List;

/**
 * 死んでいるセル
 */
public final class DeadCell implements Cell {
    @Override
    public Cell next(List<Cell> aroundCell) {
        long countAlive = aroundCell.stream().filter(Cell::isAlive).count();

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
