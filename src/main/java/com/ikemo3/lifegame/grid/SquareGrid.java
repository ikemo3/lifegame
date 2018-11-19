package com.ikemo3.lifegame.grid;

import com.google.common.collect.Lists;
import com.ikemo3.lifegame.Location;
import com.ikemo3.lifegame.cell.Cell;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 正方形の格子
 */
public final class SquareGrid implements Grid {
    private final int rowSize;
    private final int columnSize;
    private final List<Cell> cells;

    public SquareGrid(int columnSize, int rowSize, List<Cell> cells) {
        this.columnSize = columnSize;
        this.rowSize = rowSize;
        this.cells = Collections.unmodifiableList(cells);
    }

    @Override
    public Optional<Cell> getCell(Location location) {
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
    public Location getLocation(Cell cell) {
        int index = this.cells.indexOf(cell);
        int x = index % this.columnSize;
        int y = index / this.columnSize;

        return new Location(x, y);
    }

    @Override
    public List<Cell> aroundCells(Cell cell) {
        Location location = this.getLocation(cell);

        // 周りのセルの位置を取得
        List<Location> aroundList = location.aroundList();

        return aroundList.stream()
                .map(this::getCell) // 周りのセルを取得して追加(nullが入る可能性あり)
                .filter(Optional::isPresent).map(Optional::get)  // nullを除去して値を取得
                .collect(Collectors.toList());
    }

    @Override
    public Stream<Cell> stream() {
        return this.cells.stream();
    }

    @Override
    public Grid withNextCells(List<Cell> nextCells) {
        return new SquareGrid(this.columnSize, this.rowSize, nextCells);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        List<List<Cell>> parted = Lists.partition(this.cells, this.columnSize);
        for (List<Cell> row : parted) {
            for (Cell cell : row) {
                builder.append(cell.toString());
            }
            builder.append('\n');
        }

        return builder.toString();
    }
}
