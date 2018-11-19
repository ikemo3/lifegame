package com.ikemo3.lifegame;

import com.ikemo3.lifegame.cell.Cell;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 格子
 */
public interface Grid extends Iterable<Cell> {
    Optional<Cell> getCell(Location location);

    Optional<Cell> getCell(int x, int y);

    Location getLocation(Cell cell);

    List<Cell> aroundCells(Cell cell);

    @Override
    Iterator<Cell> iterator();

    Stream<Cell> stream();

    Grid withNextCells(List<Cell> cells);
}
