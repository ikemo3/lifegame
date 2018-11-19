package com.ikemo3.lifegame;

import com.ikemo3.lifegame.cell.Cell;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public final class Generation {
    private final Grid grid;

    public Generation(List<Cell> cells, int columnSize, int rowSize) {
        this.grid = new Grid(columnSize, rowSize, cells);
    }

    public Generation next() {
        List<Cell> nextCells = this.grid.stream()
                .map(cell -> cell.next(aroundCells(cell)))
                .collect(Collectors.toList());

        return new Generation(nextCells, grid.getColumnSize(), grid.getRowSize());
    }

    public List<Cell> aroundCells(Cell cell) {
        Location location = this.grid.getLocation(cell);

        // 周りのセルの位置を取得
        List<Location> aroundList = location.aroundList();

        // TODO: getX()を使わない
        return aroundList.stream()
                .map(around -> this.grid.getCell(around.getX(), around.getY())) // 周りのセルを取得して追加(nullが入る可能性あり)
                .filter(Optional::isPresent) // nullを除去
                .map(Optional::get)
                .collect(Collectors.toList());
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
