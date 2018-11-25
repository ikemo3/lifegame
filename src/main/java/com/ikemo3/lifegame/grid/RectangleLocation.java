package com.ikemo3.lifegame.grid;

import java.util.ArrayList;
import java.util.List;

public final class RectangleLocation implements Location {
    private final int x;
    private final int y;

    public RectangleLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public List<Location> aroundList() {
        List<Location> aroundList = new ArrayList<>();
        aroundList.add(new RectangleLocation(x - 1, y - 1));
        aroundList.add(new RectangleLocation(x, y - 1));
        aroundList.add(new RectangleLocation(x + 1, y - 1));
        aroundList.add(new RectangleLocation(x - 1, y));
        aroundList.add(new RectangleLocation(x + 1, y));
        aroundList.add(new RectangleLocation(x - 1, y + 1));
        aroundList.add(new RectangleLocation(x, y + 1));
        aroundList.add(new RectangleLocation(x + 1, y + 1));
        return aroundList;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }
}
