package com.ikemo3.lifegame;

import com.google.common.collect.Lists;
import com.ikemo3.lifegame.cell.Cell;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Grid implements Iterable<Cell> {
    private final int rowSize;
    private final int columnSize;
    private final List<Cell> cells;

    public Grid(int columnSize, int rowSize, List<Cell> cells) {
        this.columnSize = columnSize;
        this.rowSize = rowSize;
        this.cells = Collections.unmodifiableList(cells);
    }

    public int getRowSize() {
        return rowSize;
    }

    public int getColumnSize() {
        return columnSize;
    }

    public Cell getCell(int x, int y) {
        if (x < 0 || x >= columnSize) {
            return null;
        }

        if (y < 0 || y >= rowSize) {
            return null;
        }

        return this.cells.get(y * columnSize + x);
    }

    public Location getLocation(Cell cell) {
        int index = this.cells.indexOf(cell);
        int x = index % this.columnSize;
        int y = index / this.columnSize;

        return new Location(x, y);
    }

    @Override
    public Iterator<Cell> iterator() {
        return this.cells.iterator();
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        List<List<Cell>> parted = Lists.partition(this.cells, this.columnSize);
        for (List<Cell> row : parted) {
            for (Cell cell : row) {
                if (cell.isAlive()) {
                    builder.append("■");
                } else {
                    builder.append("□");
                }
            }
            builder.append('\n');
        }

        return builder.toString();
    }
}
