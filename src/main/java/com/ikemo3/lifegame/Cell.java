package com.ikemo3.lifegame;

import java.util.List;

public interface Cell {
    Cell next(List<Cell> aroundCell);

    boolean isAlive();
}
