package com.ikemo3.lifegame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Generation {
    private static final int CELL_COUNT = 9;
    private static final int COL_COUNT = 3;
    private static final int ROW_COUNT = 3;
    private final List<Cell> cells;

    public Generation(List<Cell> cells) {
        this.cells = Collections.unmodifiableList(cells);
    }

    public Generation next() {
        List<Cell> nextCells = new ArrayList<>();
        for (int i = 0; i < CELL_COUNT; i++) {
            Cell cell = this.cells.get(i);
            List<Cell> aroundCells = aroundCells(cell);
            nextCells.add(this.cells.get(i).next(aroundCells));
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
        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                Cell cell = this.cells.get(x * 3 + y);
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
