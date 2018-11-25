package com.ikemo3.lifegame.grid;

import java.util.List;

public interface Location {
    /**
     * 周りのロケーションのリストを返す
     *
     * @return 周りのロケーションのリスト
     */
    List<Location> aroundList();
}
