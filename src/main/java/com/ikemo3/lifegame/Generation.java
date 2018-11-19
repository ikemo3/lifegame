package com.ikemo3.lifegame;

import com.google.common.collect.Lists;
import com.ikemo3.lifegame.cell.Cell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Generation {
    private static final int COL_COUNT = 3;
    private static final int ROW_COUNT = 3;
    private final List<Cell> cells;

    public Generation(List<Cell> cells) {
        this.cells = Collections.unmodifiableList(cells);
    }

    public Generation next() {
        List<Cell> nextCells = new ArrayList<>();
        for (Cell cell : this.cells) {
            List<Cell> aroundCells = aroundCells(cell);
            nextCells.add(cell.next(aroundCells));
        }

        return new Generation(nextCells);
    }

    public List<Cell> aroundCells(Cell cell) {
        List<Cell> aroundCells = new ArrayList<>();

        int i = getIndex(cell);
        int x = i % 3;
        int y = i / 3;

        // 最大8通りの可能性
        aroundCells.add(getCell(x - 1, y - 1));
        aroundCells.add(getCell(x, y - 1));
        aroundCells.add(getCell(x + 1, y - 1));
        aroundCells.add(getCell(x - 1, y));
        aroundCells.add(getCell(x + 1, y));
        aroundCells.add(getCell(x - 1, y + 1));
        aroundCells.add(getCell(x, y + 1));
        aroundCells.add(getCell(x + 1, y + 1));

        // nullを除去して返す
        return aroundCells.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    public Cell getCell(int x, int y) {
        if (x < 0 || x >= COL_COUNT) {
            return null;
        }

        if (y < 0 || y >= ROW_COUNT) {
            return null;
        }

        return this.cells.get(y * 3 + x);
    }

    public int getIndex(Cell cell) {
        return this.cells.indexOf(cell);
    }

    public boolean isAlive(int x, int y) {
        Cell cell = getCell(x, y);
        if (cell == null) {
            throw new IllegalArgumentException("セルが見つかりませんでした。");
        }

        return cell.isAlive();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        List<List<Cell>> parted = Lists.partition(this.cells, 3);
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
