package com.ikemo3.lifegame;

import java.util.List;

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
}
