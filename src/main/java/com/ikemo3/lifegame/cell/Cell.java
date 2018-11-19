package com.ikemo3.lifegame.cell;

import java.util.List;

public interface Cell {
    Cell next(List<Cell> aroundCell);

    boolean isAlive();
}
