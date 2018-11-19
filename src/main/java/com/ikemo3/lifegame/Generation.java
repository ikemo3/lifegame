package com.ikemo3.lifegame;

import com.ikemo3.lifegame.cell.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Generation {
    private final Grid grid;

    public Generation(List<Cell> cells, int columnSize, int rowSize) {
        this.grid = new Grid(columnSize, rowSize, cells);
    }

    public Generation next() {
        List<Cell> nextCells = new ArrayList<>();
        for (Cell cell : this.grid) {
            List<Cell> aroundCells = aroundCells(cell);
            nextCells.add(cell.next(aroundCells));
        }

        return new Generation(nextCells, grid.getColumnSize(), grid.getRowSize());
    }

    public List<Cell> aroundCells(Cell cell) {
        List<Cell> aroundCells = new ArrayList<>();

        Location loc = this.grid.getLocation(cell);

        // 周りのセルの位置を取得
        List<Location> aroundList = loc.aroundList();

        // 周りのセルを取得して追加(nullが入る可能性あり)
        for (Location around : aroundList) {
            aroundCells.add(this.grid.getCell(around.getX(), around.getY()));
        }

        // nullを除去して返す
        return aroundCells.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    public boolean isAlive(int x, int y) {
        Cell cell = this.grid.getCell(x, y);
        if (cell == null) {
            throw new IllegalArgumentException("セルが見つかりませんでした。");
        }

        return cell.isAlive();
    }

    @Override
    public String toString() {
        return this.grid.toString();
    }
}
