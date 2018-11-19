package com.ikemo3.lifegame;

import com.ikemo3.lifegame.cell.Cell;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface Grid extends Iterable<Cell> {
    int getRowSize();

    int getColumnSize();

    Optional<Cell> getCell(int x, int y);

    Location getLocation(Cell cell);

    List<Cell> aroundCells(Cell cell);

    @Override
    Iterator<Cell> iterator();

    Stream<Cell> stream();
}
