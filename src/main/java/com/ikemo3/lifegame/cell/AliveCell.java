package com.ikemo3.lifegame.cell;

import java.util.List;

public final class AliveCell implements Cell {
    @Override
    public Cell next(List<Cell> aroundCell) {
        long countAlive = aroundCell.stream().filter(Cell::isAlive).count();

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
}
