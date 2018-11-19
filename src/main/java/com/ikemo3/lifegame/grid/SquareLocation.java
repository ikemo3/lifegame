package com.ikemo3.lifegame.grid;

import java.util.ArrayList;
import java.util.List;

public final class SquareLocation {
    private final int x;
    private final int y;

    public SquareLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<SquareLocation> aroundList() {
        List<SquareLocation> aroundList = new ArrayList<>();
        aroundList.add(new SquareLocation(x - 1, y - 1));
        aroundList.add(new SquareLocation(x, y - 1));
        aroundList.add(new SquareLocation(x + 1, y - 1));
        aroundList.add(new SquareLocation(x - 1, y));
        aroundList.add(new SquareLocation(x + 1, y));
        aroundList.add(new SquareLocation(x - 1, y + 1));
        aroundList.add(new SquareLocation(x, y + 1));
        aroundList.add(new SquareLocation(x + 1, y + 1));
        return aroundList;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }
}
