package com.ikemo3.lifegame.cell;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public final class Cells {
    private final List<Cell> cells;

    public static Cells of(List<Cell> cellList) {
        return new Cells(cellList);
    }

    public static Cells of(Cell... cells) {
        return new Cells(Arrays.asList(cells));
    }

    private Cells(List<Cell> cells) {
        this.cells = Collections.unmodifiableList(cells);
    }

    public long countAlive() {
        return this.cells.stream().filter(Cell::isAlive).count();
    }

    public int size() {
        return this.cells.size();
    }

    public Cell get(int index) {
        return this.cells.get(index);
    }

    public int indexOf(Cell cell) {
        return this.cells.indexOf(cell);
    }

    public Stream<Cell> stream() {
        return this.cells.stream();
    }

    public List<List<Cell>> parted(int columnSize) {
        return Lists.partition(this.cells, columnSize);
    }
}
