package com.ikemo3.lifegame;

import java.util.ArrayList;
import java.util.List;

public final class Location {
    private final int x;
    private final int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<Location> aroundList() {
        List<Location> aroundList = new ArrayList<>();
        aroundList.add(new Location(x - 1, y - 1));
        aroundList.add(new Location(x, y - 1));
        aroundList.add(new Location(x + 1, y - 1));
        aroundList.add(new Location(x - 1, y));
        aroundList.add(new Location(x + 1, y));
        aroundList.add(new Location(x - 1, y + 1));
        aroundList.add(new Location(x, y + 1));
        aroundList.add(new Location(x + 1, y + 1));
        return aroundList;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
