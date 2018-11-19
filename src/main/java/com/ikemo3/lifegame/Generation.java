package com.ikemo3.lifegame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Generation {
    private final Cell[][] cells;

    public Generation(Cell[][] cells) {
        this.cells = cells;
    }

    public Generation next() {
        Cell[][] nextCells = new Cell[3][3];
        for (int x = 0; x <= 2; x++) {
            nextCells[x] = new Cell[3];
            for (int y = 0; y <= 2; y++) {
                Cell cell = this.cells[x][y];
                List<Cell> aroundCells = aroundCells(cell);
                nextCells[x][y] = this.cells[x][y].next(aroundCells);
            }
        }

        return new Generation(nextCells);
    }

    public List<Cell> aroundCells(Cell cell) {
        List<Cell> aroundCells = new ArrayList<>();

        int[] xy = getIndex(cell);
        int x = xy[0];
        int y = xy[1];

        // 最大8通りの可能性
        aroundCells.add(getCell(x - 1, y - 1));
        aroundCells.add(getCell(x - 1, y));
        aroundCells.add(getCell(x - 1, y + 1));
        aroundCells.add(getCell(x, y - 1));
        aroundCells.add(getCell(x, y + 1));
        aroundCells.add(getCell(x + 1, y - 1));
        aroundCells.add(getCell(x + 1, y));
        aroundCells.add(getCell(x + 1, y + 1));

        // nullを除去して返す
        return aroundCells.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    public Cell getCell(int x, int y) {
        if (x < 0 || x >= 3) {
            return null;
        }

        if (y < 0 || y >= 3) {
            return null;
        }

        return this.cells[x][y];
    }

    public int[] getIndex(Cell cell) {
        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                // オブジェクトそのものを比較するので、==を使うのに注意
                if (this.cells[x][y] == cell) {
                    return new int[]{x, y};
                }
            }
        }

        throw new IllegalArgumentException("セルが見つかりませんでした。");
    }

    public boolean isAlive(int i, int j) {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                Cell cell = this.cells[x][y];
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
