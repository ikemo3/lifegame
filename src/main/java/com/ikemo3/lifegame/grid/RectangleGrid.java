package com.ikemo3.lifegame.grid;

import com.ikemo3.lifegame.cell.Cell;
import com.ikemo3.lifegame.cell.Cells;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 正方形の格子
 */
public final class RectangleGrid implements Grid {
    private final int rowSize;
    private final int columnSize;
    private final Cells cells;

    public RectangleGrid(int columnSize, int rowSize, Cells cells) {
        this.columnSize = columnSize;
        this.rowSize = rowSize;
        this.cells = cells;
    }

    @Override
    public Optional<Cell> getCell(RectangleLocation location) {
        int x = location.getX();
        int y = location.getY();
        if (x < 0 || x >= columnSize) {
            return Optional.empty();
        }

        if (y < 0 || y >= rowSize) {
            return Optional.empty();
        }

        return Optional.of(this.cells.get(y * columnSize + x));
    }

    @Override
    public RectangleLocation getLocation(Cell cell) {
        int index = this.cells.indexOf(cell);
        int x = index % this.columnSize;
        int y = index / this.columnSize;

        return new RectangleLocation(x, y);
    }

    @Override
    public Cells aroundCells(Cell cell) {
        RectangleLocation location = this.getLocation(cell);

        // 周りのセルの位置を取得
        List<RectangleLocation> aroundList = location.aroundList();

        List<Cell> aroundCells = aroundList.stream()
                .map(this::getCell) // 周りのセルを取得して追加(nullが入る可能性あり)
                .filter(Optional::isPresent).map(Optional::get)  // nullを除去して値を取得
                .collect(Collectors.toList());

        return Cells.of(aroundCells);
    }

    @Override
    public Grid next() {
        Cells nextCells = this.cells.map(cell -> cell.next(aroundCells(cell)));

        return new RectangleGrid(this.columnSize, this.rowSize, nextCells);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        List<List<Cell>> parted = this.cells.parted(this.columnSize);
        for (List<Cell> row : parted) {
            for (Cell cell : row) {
                builder.append(cell.toString());
            }
            builder.append('\n');
        }

        return builder.toString();
    }
}
