package com.ikemo3.lifegame;

import com.ikemo3.lifegame.grid.Grid;
import com.ikemo3.lifegame.grid.RectangleLocation;

public final class Generation {
    private final Grid grid;

    Generation(Grid grid) {
        this.grid = grid;
    }

    Generation next() {
        // 次の世代のGridを作成
        Grid nextGrid = this.grid.next();

        return new Generation(nextGrid);
    }

    boolean isAlive(RectangleLocation location) {
        return grid.getCell(location)
                .orElseThrow(() -> new IllegalArgumentException("セルが見つかりませんでした。"))
                .isAlive();
    }

    @Override
    public String toString() {
        return this.grid.toString();
    }
}
