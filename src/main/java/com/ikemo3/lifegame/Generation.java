package com.ikemo3.lifegame;

import com.ikemo3.lifegame.cell.Cell;

import java.util.List;
import java.util.stream.Collectors;

public final class Generation {
    private final Grid grid;

    public Generation(List<Cell> cells, int columnSize, int rowSize) {
        this.grid = new Grid(columnSize, rowSize, cells);
    }

    public Generation next() {
        List<Cell> nextCells = this.grid.stream()
                .map(cell -> cell.next(grid.aroundCells(cell)))
                .collect(Collectors.toList());

        return new Generation(nextCells, grid.getColumnSize(), grid.getRowSize());
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
