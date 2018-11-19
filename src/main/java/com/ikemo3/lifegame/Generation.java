package com.ikemo3.lifegame;

import com.ikemo3.lifegame.cell.Cell;
import com.ikemo3.lifegame.grid.Grid;
import com.ikemo3.lifegame.grid.RectangleLocation;

import java.util.List;
import java.util.stream.Collectors;

public final class Generation {
    private final Grid grid;

    Generation(Grid grid) {
        this.grid = grid;
    }

    Generation next() {
        List<Cell> nextCells = this.grid.stream()
                .map(cell -> cell.next(grid.aroundCells(cell)))
                .collect(Collectors.toList());

        // 次の世代のGridを作成して返す
        Grid nextGrid = grid.withNextCells(nextCells);

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
