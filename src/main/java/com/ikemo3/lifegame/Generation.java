package com.ikemo3.lifegame;

import com.ikemo3.lifegame.cell.Cell;

import java.util.List;
import java.util.stream.Collectors;

public final class Generation {
    private final Grid grid;

    public Generation(Grid grid) {
        this.grid = grid;
    }

    public Generation next() {
        List<Cell> nextCells = this.grid.stream()
                .map(cell -> cell.next(grid.aroundCells(cell)))
                .collect(Collectors.toList());

        Grid nextGrid = new SquareGrid(this.grid.getColumnSize(), grid.getRowSize(), nextCells);
        return new Generation(nextGrid);
    }

    public boolean isAlive(int x, int y) {
        return this.grid.getCell(x, y)
                .orElseThrow(() -> new IllegalArgumentException("セルが見つかりませんでした。"))
                .isAlive();
    }

    @Override
    public String toString() {
        return this.grid.toString();
    }
}
